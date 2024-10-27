package com.mintra.backend.repository;

import com.mintra.backend.entities.UserAddress;

import java.util.List;

public interface UserAddressRepository {

    UserAddress saveOrUpdateUserAddress(UserAddress userAddress);

    List<UserAddress> retrieveUserAddressByUserName(String userName);

    int deleteUserAddress(long addressId, String userName);

}
