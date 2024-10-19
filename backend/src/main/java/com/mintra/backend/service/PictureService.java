package com.mintra.backend.service;

import com.mintra.backend.entities.Picture;
import org.springframework.web.multipart.MultipartFile;

public interface PictureService {

    Picture getPictureById(long id);

    Picture getPictureByProductId(long productId);

    Picture savePicture(MultipartFile[] images, long productId);
}
