package com.mintra.backend.json.response;

import com.mintra.backend.json.ReviewJson;

public class ReviewResponseJson extends ReviewJson {
    private long productId;

    public ReviewResponseJson(String userName, String description, double stars, long productId) {
        super(userName, description, stars);
        this.productId = productId;
    }

    public long getProductId() {
        return productId;
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }
}
