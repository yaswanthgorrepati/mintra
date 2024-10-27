package com.mintra.backend.repository;

import com.mintra.backend.entities.UserDetails;

public interface UserDetailsRepository {

    UserDetails saveOrUpdateUserDetails(UserDetails userDetails);

    UserDetails getUserDetailsByuserName(String userName);
}
