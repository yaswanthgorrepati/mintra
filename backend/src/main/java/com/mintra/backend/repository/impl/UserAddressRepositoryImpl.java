package com.mintra.backend.repository.impl;

import com.mintra.backend.entities.UserAddress;
import com.mintra.backend.repository.UserAddressRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class UserAddressRepositoryImpl implements UserAddressRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public UserAddress saveOrUpdateUserAddress(UserAddress userAddress) {
        entityManager.persist(userAddress);
        return userAddress;
    }

    @Override
    public List<UserAddress> retrieveUserAddressByUserName(String userName) {
        TypedQuery<UserAddress> typedQuery = entityManager.createNamedQuery("getUserAddressByUserName", UserAddress.class);
        typedQuery.setParameter("userName", userName);
        List<UserAddress> userAddressList = typedQuery.getResultList();
        return CollectionUtils.isEmpty(userAddressList) ? null : userAddressList;
    }

    @Override
    public int deleteUserAddress(long addressId, String userName) {
        TypedQuery typedQuery = (TypedQuery) entityManager.createNamedQuery("deleteUserAddressByIdAndUserName");
        typedQuery.setParameter("id", addressId);
        typedQuery.setParameter("userName", userName);
        int rows = typedQuery.executeUpdate();
        return rows;
    }
}
