package com.mintra.backend.controller;

import com.google.gson.Gson;
import com.mintra.backend.json.UserCredsJson;
import com.mintra.backend.json.UserDetailsJson;
import com.mintra.backend.json.response.GenericResponse;
import com.mintra.backend.json.response.UserCredsResponseJson;
import com.mintra.backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    private Gson gson = new Gson();

    @PostMapping("/register")
    public ResponseEntity<String> registerNewUser(@RequestBody UserCredsJson userCredsJson){
        GenericResponse genericResponse = userService.registerNewUser(userCredsJson);
        return new ResponseEntity<>(gson.toJson(genericResponse), HttpStatus.OK);
    }

    @GetMapping("/validate")
    public ResponseEntity<String> validateUser(@RequestBody UserCredsJson userCredsJson){
        GenericResponse genericResponse = userService.isUserValid(userCredsJson.getPassword(), userCredsJson.getUserName());
        return new ResponseEntity<>(gson.toJson(genericResponse), HttpStatus.OK);
    }

    @PostMapping("/details")
    public ResponseEntity<String> saveOrUpdateUserDetails(@RequestBody UserDetailsJson userDetailsJson){
        GenericResponse genericResponse = userService.saveOrUpdateUserDetails(userDetailsJson);
        return new ResponseEntity<>(gson.toJson(genericResponse), HttpStatus.OK);
    }

    @GetMapping("/details")
    public ResponseEntity<String> getUserDetails(@RequestBody UserDetailsJson userDetailsJson){
        GenericResponse genericResponse = userService.getUserDetails(userDetailsJson.getUserName(), false);
        return new ResponseEntity<>(gson.toJson(genericResponse), HttpStatus.OK);
    }

    @PostMapping("/address")
    public ResponseEntity<String> saveOrUpdateUserAddress(@RequestBody UserDetailsJson userDetailsJson){
        GenericResponse genericResponse = userService.saveOrUpdateUserAddress(userDetailsJson);
        return new ResponseEntity<>(gson.toJson(genericResponse), HttpStatus.OK);
    }

    @GetMapping("/address")
    public ResponseEntity<String> getUserAddress(@RequestBody UserDetailsJson userDetailsJson){
        GenericResponse genericResponse = userService.getUserDetails(userDetailsJson.getUserName(), true);
        return new ResponseEntity<>(gson.toJson(genericResponse), HttpStatus.OK);
    }


    @DeleteMapping("/address")
    public ResponseEntity<String> deleteUserAddress(@RequestBody UserDetailsJson userDetailsJson){
        GenericResponse genericResponse = userService.deleteUserAddress(userDetailsJson);
        return new ResponseEntity<>(gson.toJson(genericResponse), HttpStatus.OK);
    }
}
