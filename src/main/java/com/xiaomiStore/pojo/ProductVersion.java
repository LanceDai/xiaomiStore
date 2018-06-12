package com.xiaomiStore.pojo;

public class ProductVersion {
    private String versionId;
    private String productId;
    private String detailVersion;
    private String img;
    private int number;
    private int price;

    @Override
    public String toString() {
        return "ProductVersion{" +
                "versionId='" + versionId + '\'' +
                ", productId='" + productId + '\'' +
                ", detailVersion='" + detailVersion + '\'' +
                ", img='" + img + '\'' +
                ", number=" + number +
                ", price=" + price +
                '}';
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getDetailVersion() {
        return detailVersion;
    }

    public void setDetailVersion(String detailVersion) {
        this.detailVersion = detailVersion;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public ProductVersion(String versionId, String productId, String detailVersion, String img, int number, int price) {

        this.versionId = versionId;
        this.productId = productId;
        this.detailVersion = detailVersion;
        this.img = img;
        this.number = number;
        this.price = price;
    }

    public ProductVersion() {

    }
}
