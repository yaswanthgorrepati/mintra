package com.mintra.backend.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.mintra.backend.entities.Users;
import com.mintra.backend.repository.UserRepository;
import org.apache.commons.lang3.ArrayUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import static com.mintra.backend.json.error.MessageDescriptions.TOKEN;
import static com.mintra.backend.json.error.MessageDescriptions.USER_NAME;

@Component
public class JWTTokenGenerator {

    @Autowired
    private UserRepository userRepository;

    private static long expirationTimeMillis = 3600_000;

    public String createJWT(Map<String, String> payload) {
        Algorithm algorithm = Algorithm.HMAC256(AESEncryption.key);

        String token = JWT.create()
                .withIssuedAt(new Date())
                .withExpiresAt(new Date(System.currentTimeMillis() + expirationTimeMillis))
                .withPayload(payload)
                .sign(algorithm);

        return token;
    }

    public static void main2(String[] args) {
        JWTTokenGenerator jwtTokenGenerator = new JWTTokenGenerator();
        String userId = "1234";
        String username = "testUser";
//        String role = "admin";
        String email = "user@example.com";
        String token1 = "fgdkjnb3498";

        Map<String, String> payload = new HashMap<>();
        payload.put("userId", userId);
        payload.put("username", username);
//        payload.put("role", role);
        payload.put("email", email);
        payload.put("token", token1);

        String token = jwtTokenGenerator.createJWT(payload);
        System.out.println("Generated JWT Token: \n" + token);

        System.out.println(ArrayUtils.toString(token.split("\\.")));
        System.out.println(new String(Base64.getDecoder().decode(token.split("\\.")[0])));
        System.out.println(new String(Base64.getDecoder().decode(token.split("\\.")[1])));

        DecodedJWT decodedJWT = JWT.decode(token);
        String pwdToken = decodedJWT.getClaim("email").asString();
        System.out.println(pwdToken);
        System.out.println(decodedJWT.getPayload());

        boolean isTokenValid = jwtTokenGenerator.validateJWT(token);
        System.out.println("Is token valid: " + isTokenValid);
    }

    public boolean validateJWT(String token) {
        try {
            DecodedJWT decodedJWT = JWT.decode(token);
            String userName = decodedJWT.getClaim(USER_NAME).asString();
            Users users = userRepository.getUserByUserName(userName);

            Algorithm algorithm = Algorithm.HMAC256(AESEncryption.key);

            JWTVerifier verifier = JWT.require(algorithm)
                    .withClaim(TOKEN, AESEncryption.encrypt(users.getPassword()))
                    .build();

            verifier.verify(token);

            return true;
        } catch (JWTVerificationException e) {
            // Invalid signature, token expired, or claim mismatch
            System.err.println("Token is invalid: " + e.getMessage());
            return false;
        }
    }
}
