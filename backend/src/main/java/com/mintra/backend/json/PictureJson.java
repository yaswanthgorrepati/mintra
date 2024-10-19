package com.mintra.backend.json;

public class PictureJson {
    private String imageUrl_1;
    private String imageUrl_2;
    private String imageUrl_3;

    public PictureJson(String imageUrl_1, String imageUrl_2, String imageUrl_3) {
        this.imageUrl_1 = imageUrl_1;
        this.imageUrl_2 = imageUrl_2;
        this.imageUrl_3 = imageUrl_3;
    }

    public String getImageUrl_1() {
        return imageUrl_1;
    }

    public void setImageUrl_1(String imageUrl_1) {
        this.imageUrl_1 = imageUrl_1;
    }

    public String getImageUrl_2() {
        return imageUrl_2;
    }

    public void setImageUrl_2(String imageUrl_2) {
        this.imageUrl_2 = imageUrl_2;
    }

    public String getImageUrl_3() {
        return imageUrl_3;
    }

    public void setImageUrl_3(String imageUrl_3) {
        this.imageUrl_3 = imageUrl_3;
    }
}
