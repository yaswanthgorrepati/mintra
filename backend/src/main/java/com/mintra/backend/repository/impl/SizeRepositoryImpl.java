package com.mintra.backend.repository.impl;

import com.mintra.backend.entities.Size;
import com.mintra.backend.repository.SizeRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class SizeRepositoryImpl implements SizeRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Size getSizeById(long id) {
        TypedQuery<Size> typedQuery = entityManager.createNamedQuery("getSizeById", Size.class);
        typedQuery.setParameter("id", id);
        List<Size> sizeList = typedQuery.getResultList();
        return CollectionUtils.isEmpty(sizeList) ? null : sizeList.get(0);
    }

    @Override
    public List<Size> getSizeByProductId(long productId) {
        TypedQuery<Size> typedQuery = entityManager.createNamedQuery("getSizeByProductId", Size.class);
        typedQuery.setParameter("productId", productId);
        List<Size> sizeList = typedQuery.getResultList();
        return sizeList;
    }

    @Override
    public List<Size> saveSizes(List<Size> sizeList) {
        for(Size size : sizeList){
            entityManager.persist(size);
        }
        return sizeList;
    }

    @Override
    public Size saveSize(Size size) {
        entityManager.persist(size);
        return size;
    }
}
