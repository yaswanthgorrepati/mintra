package com.mintra.backend.repository.impl;

import com.mintra.backend.entities.Users;
import com.mintra.backend.repository.UserRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Users getUserByUserName(String userName) {
        TypedQuery<Users> typedQuery = entityManager.createNamedQuery("getUserByUserName", Users.class);
        typedQuery.setParameter("userName", userName);
        List<Users> userList = typedQuery.getResultList();
        return CollectionUtils.isEmpty(userList) ? null : userList.get(0);
    }

    @Override
    public Users getUserByUserId(long userId) {
        TypedQuery<Users> typedQuery = entityManager.createNamedQuery("getUserByUserId", Users.class);
        typedQuery.setParameter("id", userId);
        List<Users> userList = typedQuery.getResultList();
        return CollectionUtils.isEmpty(userList) ? null : userList.get(0);
    }

    @Override
    public Users addUser(Users user) {
        entityManager.persist(user);
        return user;
    }

    @Override
    public Users updateUser(Users user) {
        entityManager.persist(user);
        return user;
    }
}
