package com.mintra.backend.service.impl;

import com.mintra.backend.entities.Picture;
import com.mintra.backend.repository.PictureRepository;
import com.mintra.backend.service.PictureService;
import com.mintra.backend.util.ImageUploader;
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
    public Picture savePicture(MultipartFile[] images, long productId) {
        Map res1 = imageUploader.uploadImage(images[0]);
        Map res2= imageUploader.uploadImage(images[1]);
        Map res3 = imageUploader.uploadImage(images[2]);
        Picture picture= new Picture((String) res1.get("url"), (String) res2.get("url"), (String) res3.get("url"), productId);
        return pictureRepository.savePicture(picture);
    }
}
