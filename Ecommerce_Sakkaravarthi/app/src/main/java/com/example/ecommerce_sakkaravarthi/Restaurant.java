package com.example.ecommerce_sakkaravarthi;

public class Restaurant {
    private int id;
    private String name;
    private String categories;
    private String ratings;

    public Restaurant(String name, String categories, String ratings) {
        this.name = name;
        this.categories = categories;
        this.ratings = ratings;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategories() {
        return categories;
    }

    public void setCategories(String categories) {
        this.categories = categories;
    }

    public String getRatings() {
        return ratings;
    }

    public void setRatings(String ratings) {
        this.ratings = ratings;
    }
}
