package com.xiaomiStore.pojo;

public class Product {
    private String productId;
    private String productName;
    private String productDescription;
    private String typeId;

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", productName='" + productName + '\'' +
                ", productDescription='" + productDescription + '\'' +
                ", typeId='" + typeId + '\'' +
                '}';
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductDescription() {
        return productDescription;
    }

    public void setProductDescription(String productDescription) {
        this.productDescription = productDescription;
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        this.typeId = typeId;
    }

    public Product(String productId, String productName, String productDescription, String typeId) {

        this.productId = productId;
        this.productName = productName;
        this.productDescription = productDescription;
        this.typeId = typeId;
    }

    public Product() {

    }
}
