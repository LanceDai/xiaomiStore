package com.xiaomiStore.utils;

public class ShoppingCartList {
    private String productName;
    private String detailVersion;
    private String colorName;
    private double price;
    private int number;

    @Override
    public String toString() {
        return "ShoppingCartList{" +
                "productName='" + productName + '\'' +
                ", detailVersion='" + detailVersion + '\'' +
                ", colorName='" + colorName + '\'' +
                ", price=" + price +
                ", number=" + number +
                '}';
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getDetailVersion() {
        return detailVersion;
    }

    public void setDetailVersion(String detailVersion) {
        this.detailVersion = detailVersion;
    }

    public String getColorName() {
        return colorName;
    }

    public void setColorName(String colorName) {
        this.colorName = colorName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ShoppingCartList(String productName, String detailVersion, String colorName, double price, int number) {

        this.productName = productName;
        this.detailVersion = detailVersion;
        this.colorName = colorName;
        this.price = price;
        this.number = number;
    }

    public ShoppingCartList() {

    }
}