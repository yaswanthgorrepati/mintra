package com.mintra.backend.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "PICTURE")
@NamedQueries({@NamedQuery(name = "getPictureById", query = "SELECT p FROM Picture p WHERE p.id =:pictureId"),
                @NamedQuery(name = "getPictureByProductId", query = "SELECT p FROM Picture p WHERE p.productId =:productId")
})
public class Picture {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "imageUrl_1")
    private String imageUrl_1;
    @Column(name = "imageUrl_2")
    private String imageUrl_2;
    @Column(name = "imageUrl_3")
    private String imageUrl_3;
    @Column(name = "productId")
    private long productId;

    public Picture() {
    }

    public Picture(String imageUrl_1, String imageUrl_2, String imageUrl_3, long productId) {
        this.imageUrl_1 = imageUrl_1;
        this.imageUrl_2 = imageUrl_2;
        this.imageUrl_3 = imageUrl_3;
        this.productId = productId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
