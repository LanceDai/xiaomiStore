package com.xiaomiStore.pojo;

public class Specification {
    private String colorId;
    private String productId;
    private String versionId;
    private String stock;
    private String price;

    @Override
    public String toString() {
        return "Specification{" +
                "colorId='" + colorId + '\'' +
                ", productId='" + productId + '\'' +
                ", versionId='" + versionId + '\'' +
                ", stock='" + stock + '\'' +
                ", price='" + price + '\'' +
                '}';
    }

    public Specification(String colorId, String productId, String versionId, String stock, String price) {
        this.colorId = colorId;
        this.productId = productId;
        this.versionId = versionId;
        this.stock = stock;
        this.price = price;
    }

    public Specification() {

    }

    public String getColorId() {

        return colorId;
    }

    public void setColorId(String colorId) {
        this.colorId = colorId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
