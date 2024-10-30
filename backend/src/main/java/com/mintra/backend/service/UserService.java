package com.mintra.backend.service;

import com.mintra.backend.json.UserCredsJson;
import com.mintra.backend.json.UserDetailsJson;
import com.mintra.backend.json.response.GenericResponse;
import com.mintra.backend.json.response.UserCredsResponseJson;

public interface UserService {

    GenericResponse registerNewUser(UserCredsJson userCredsJson);

    GenericResponse isUserValid(String password, String  userName);

    GenericResponse saveOrUpdateUserDetails(UserDetailsJson userDetailsJson);

    //retrieve useraddress as well
    GenericResponse getUserDetails(String userName, boolean fetchUserAddress);

    GenericResponse saveOrUpdateUserAddress(UserDetailsJson userDetailsJson);

    GenericResponse deleteUserAddress(UserDetailsJson userDetailsJson);


}
