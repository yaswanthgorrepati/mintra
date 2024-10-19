package com.mintra.backend.service;

import com.mintra.backend.entities.Picture;
import org.springframework.web.multipart.MultipartFile;

public interface PictureService {

    Picture getPictureById(long id);

    Picture getPictureByProductId(long productId);

    Picture savePicture(MultipartFile multipartFile1, MultipartFile multipartFile2, MultipartFile multipartFile3, long productId);
}
