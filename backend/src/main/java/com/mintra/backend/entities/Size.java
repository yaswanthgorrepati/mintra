package com.mintra.backend.entities;


import jakarta.persistence.*;

@Entity
@Table(name = "SIZE")
@NamedQueries({@NamedQuery(name = "getSizeById", query = "SELECT s FROM Size s WHERE s.id =:id"),
        @NamedQuery(name = "getSizeByProductId", query = "SELECT s FROM Size s WHERE s.productId =:productId")})
public class Size {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "size")
    private String size;
    @Column(name = "productId")
    private long productId;

    public Size() {
    }

    public Size(String size, long productId) {
        this.size = size;
        this.productId = productId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
