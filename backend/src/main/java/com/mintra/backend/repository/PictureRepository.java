package com.mintra.backend.repository;

import com.mintra.backend.entities.Picture;

public interface PictureRepository {

    Picture getPictureById(long id);

    Picture getPictureByProductId(long productId);

    Picture savePicture(Picture picture);
}
