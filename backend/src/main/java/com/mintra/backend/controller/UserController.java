package com.mintra.backend.controller;

import com.google.gson.Gson;
import com.mintra.backend.json.UserCredsJson;
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

    @PostMapping("")
    public ResponseEntity<String> registerNewUser(@RequestBody UserCredsJson userCredsJson){
        GenericResponse genericResponse = userService.registerNewUser(userCredsJson);
        return new ResponseEntity<>(gson.toJson(genericResponse), HttpStatus.OK);
    }

    @GetMapping("")
    public ResponseEntity<String> validateUser(@RequestBody UserCredsJson userCredsJson){
        GenericResponse genericResponse = userService.isUserValid(userCredsJson.getPassword(), userCredsJson.getUserName());
        return new ResponseEntity<>(gson.toJson(genericResponse), HttpStatus.OK);
    }
}
