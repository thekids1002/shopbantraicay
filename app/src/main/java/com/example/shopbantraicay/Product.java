package com.example.shopbantraicay;

import java.io.Serializable;

public class Product implements Serializable {
    private int id;
    private String image;
    private String name;
    private double price;
    private String description;

    private int quanity ;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getQuanity() {
        return quanity;
    }

    public void setQuanity(int quanity) {
        this.quanity = quanity;
    }

    // Constructors
    public Product() {
        // Default constructor
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", image='" + image + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                ", description='" + description + '\'' +
                '}';
    }

    public Product(int id, String image, String name, double price, String description) {
        this.id = id;
        this.image = image;
        this.name = name;
        this.price = price;
        this.description = description;
    }
}
