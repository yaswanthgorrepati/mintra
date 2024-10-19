package com.mintra.backend.repository.impl;

import com.mintra.backend.entities.Picture;
import com.mintra.backend.repository.PictureRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Repository
public class PictureRepositoryImpl implements PictureRepository {

    @Autowired
    private EntityManager entityManager;

    @Override
    public Picture getPictureById(long id) {
        TypedQuery<Picture> typedQuery = entityManager.createNamedQuery("getPictureById", Picture.class);
        typedQuery.setParameter("pictureId", id);
        List<Picture> pictureList = typedQuery.getResultList();
        return CollectionUtils.isEmpty(pictureList) ? null : pictureList.get(0);
    }

    @Override
    public Picture getPictureByProductId(long productId) {
        TypedQuery<Picture> typedQuery = entityManager.createNamedQuery("getPictureByProductId", Picture.class);
        typedQuery.setParameter("productId", productId);
        List<Picture> pictureList = typedQuery.getResultList();
        return CollectionUtils.isEmpty(pictureList) ? null : pictureList.get(0);
    }

    @Override
    public Picture savePicture(Picture picture) {
        entityManager.persist(picture);
        return picture;
    }
}
