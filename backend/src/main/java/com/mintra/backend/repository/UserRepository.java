package com.mintra.backend.repository;

import com.mintra.backend.entities.Users;

public interface UserRepository {

    Users getUserByUserName(String userName);
    Users getUserByUserId(long userId);
    Users addUser(Users user);
    Users updateUser(Users user);
}
