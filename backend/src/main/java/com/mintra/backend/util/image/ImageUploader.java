package com.mintra.backend.util.image;

import com.cloudinary.Cloudinary;
import com.cloudinary.api.ApiResponse;
import com.cloudinary.utils.ObjectUtils;
import com.google.common.io.Files;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.nio.file.Paths;
import java.util.Map;

@RestController
@RequestMapping("/image")
public class ImageUploader {

    @Value("${CLOUDINARY_KEY}")
    private String CLOUDINARY_KEY;
    @Value("${CLOUDINARY_SECRET}")
    private String CLOUDINARY_SECRET;
    @Value("${CLOUDINARY_CLOUD_NAME}")
    private String CLOUDINARY_CLOUD_NAME;

    public static void main(String[] args) throws Exception {
        // Copy and paste your API environment variable
        String CLOUDINARY_URL = "CLOUDINARY_URL=cloudinary://<API_KEY>:<API_SECRET>@<CLOUD_NAME>";

        // Set your Cloudinary credentials
        // Dotenv dotenv = Dotenv.load();
        Cloudinary cloudinary = new Cloudinary(CLOUDINARY_URL);
        System.out.println(cloudinary.config.cloudName);

        // Upload the image
        Map params1 = ObjectUtils.asMap(
                "use_filename", true,
                "unique_filename", false,
                "overwrite", true
        );
        System.out.println(cloudinary.uploader().upload("https://cloudinary-devs.github.io/cld-docs-assets/assets/images/coffee_cup.jpg", params1));

        // Get the asset details
        Map params2 = ObjectUtils.asMap(
                "quality_analysis", true
        );
        System.out.println(cloudinary.api().resource("coffee_cup", params2));
    }

    @PostMapping("")
    public Map uploadImage(@RequestParam MultipartFile multipartFile) {
        try {
            String name = multipartFile.getOriginalFilename();
            String[] namearr = name.split("\\.");
            File tempDir = Files.createTempDir();
            File tempFile = Paths.get(tempDir.getAbsolutePath(), multipartFile.getOriginalFilename()).toFile();

            multipartFile.transferTo(tempFile);
            Cloudinary cloudinary = new Cloudinary(getCloudinaryUrl());
            System.out.println(cloudinary.config.cloudName);
            // Upload the image
            Map params1 = ObjectUtils.asMap(
                    "use_filename", true,
                    "unique_filename", false,
                    "overwrite", true
            );
            Map res = cloudinary.uploader().upload(tempFile, params1);
            System.out.println(res.get("url"));
            tempFile.delete();
            return res;
        } catch (Exception exception) {
            System.out.println(exception);
        }
        return null;
    }

    @GetMapping("")
    public ApiResponse getImage(@RequestParam String name){
        try {
            Cloudinary cloudinary = new Cloudinary(getCloudinaryUrl());
            // Get the asset details
            Map params2 = ObjectUtils.asMap(
                    "quality_analysis", true
            );
           return cloudinary.api().resource(name, params2);
        } catch (Exception exception) {
            System.out.println(exception);
        }
        return null;
    }

    private String getCloudinaryUrl() {
        return "cloudinary://" + CLOUDINARY_KEY + ":" + CLOUDINARY_SECRET + "@" + CLOUDINARY_CLOUD_NAME;
    }
}
