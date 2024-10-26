package com.mintra.backend.service;

import com.mintra.backend.entities.Users;
import com.mintra.backend.json.UserCredsJson;
import com.mintra.backend.json.response.GenericResponse;
import com.mintra.backend.json.response.UserCredsResponseJson;
import com.mintra.backend.repository.UserRepository;
import com.mintra.backend.util.image.Encryption;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static com.mintra.backend.json.error.MessageDescriptions.*;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public GenericResponse registerNewUser(UserCredsJson userCredsJson) {

        Users existingUser = userRepository.getUserByUserName(userCredsJson.getUserName());
        if(Objects.nonNull(existingUser)){
            return new GenericResponse(USER_REGISTRATION_FAILED);
        }
        Users user = new Users(userCredsJson.getUserName(), Encryption.encrypt(userCredsJson.getPassword()));
        userRepository.addUser(user);
        return new UserCredsResponseJson(USER_REGISTRATION_SUCCESSFULL, user.getId(), user.getUserName());
    }

    @Override
    public GenericResponse isUserValid(String encryptedPassword, String userName) {
        Users user = userRepository.getUserByUserName(userName);
        if(Objects.nonNull(user) && user.getPassword().equals(encryptedPassword)){
            return new GenericResponse(VALID_USER);
        }else {
            return new GenericResponse(INVALID_USER);
        }
    }
}
