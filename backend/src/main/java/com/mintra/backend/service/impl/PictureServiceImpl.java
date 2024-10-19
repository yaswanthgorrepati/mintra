package com.mintra.backend.service.impl;

import com.mintra.backend.entities.Picture;
import com.mintra.backend.repository.PictureRepository;
import com.mintra.backend.service.PictureService;
import com.mintra.backend.util.image.ImageUploader;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

@Service
public class PictureServiceImpl implements PictureService {

    @Autowired
    private PictureRepository pictureRepository;

    @Autowired
    private ImageUploader imageUploader;

    @Override
    public Picture getPictureById(long id) {
        return pictureRepository.getPictureById(id);
    }

    @Override
    public Picture getPictureByProductId(long productId) {
        return pictureRepository.getPictureByProductId(productId);
    }

    @Override
    @Transactional
    public Picture savePicture(MultipartFile multipartFile1, MultipartFile multipartFile2, MultipartFile multipartFile3, long productId) {
        Map res1 = imageUploader.uploadImage(multipartFile1);
        Map res2= imageUploader.uploadImage(multipartFile2);
        Map res3 = imageUploader.uploadImage(multipartFile3);
        Picture picture= new Picture((String) res1.get("url"), (String) res2.get("url"), (String) res3.get("url"), productId);
        return pictureRepository.savePicture(picture);
    }
}
