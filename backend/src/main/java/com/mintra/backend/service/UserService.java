package com.mintra.backend.service;

import com.mintra.backend.json.UserCredsJson;
import com.mintra.backend.json.UserDetailsJson;
import com.mintra.backend.json.response.GenericResponse;
import com.mintra.backend.json.response.UserCredsResponseJson;

public interface UserService {

    GenericResponse registerNewUser(UserCredsJson userCredsJson);

    GenericResponse isUserValid(String encryptedPassword, String  userName);

    GenericResponse saveOrUpdateUserDetails(UserDetailsJson userDetailsJson);

    GenericResponse getUserDetails(String userName);


}
