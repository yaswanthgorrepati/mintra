package com.mintra.backend.repository.impl;

import com.mintra.backend.entities.UserDetails;
import com.mintra.backend.repository.UserDetailsRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class UserDetailsRepositoryImpl implements UserDetailsRepository {

    @Autowired
    private EntityManager entityManager;


    @Override
    public UserDetails saveOrUpdateUserDetails(UserDetails userDetails) {
        entityManager.persist(userDetails);
        return userDetails;
    }

    @Override
    public UserDetails getUserDetailsByuserName(String userName) {
        TypedQuery<UserDetails> typedQuery = entityManager.createNamedQuery("getUserDetailsByuserName", UserDetails.class);
        typedQuery.setParameter("userName", userName);
        List<UserDetails> userDetailsList= typedQuery.getResultList();
        return CollectionUtils.isEmpty(userDetailsList) ? null : userDetailsList.get(0);
    }
}
