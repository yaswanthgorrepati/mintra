package com.mintra.backend.json;

public class RatingJson {
    private double stars;
    private int totalRatings;

    public RatingJson(double stars, int totalRatings) {
        this.stars = stars;
        this.totalRatings = totalRatings;
    }

    public double getStars() {
        return stars;
    }

    public void setStars(double stars) {
        this.stars = stars;
    }

    public int getTotalRatings() {
        return totalRatings;
    }

    public void setTotalRatings(int totalRatings) {
        this.totalRatings = totalRatings;
    }
}
