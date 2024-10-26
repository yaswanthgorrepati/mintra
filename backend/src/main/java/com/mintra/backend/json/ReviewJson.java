package com.mintra.backend.json;

public class ReviewJson {

    private String userName;
    private String description;
    private double stars;

    public ReviewJson(String userName, String description, double stars) {
        this.userName = userName;
        this.description = description;
        this.stars = stars;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }
}
