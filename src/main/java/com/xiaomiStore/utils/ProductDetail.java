package com.xiaomiStore.utils;

import java.util.List;

public class ProductDetail {

    private String productName;
    private List<String> versionList;
    private List<String> colorList;

    public ProductDetail() {

    }

    @Override
    public String toString() {
        return "ProductDetail{" +
                "productName='" + productName + '\'' +
                ", versionList=" + versionList +
                ", colorList=" + colorList +
                '}';
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public List<String> getVersionList() {
        return versionList;
    }

    public void setVersionList(List<String> versionList) {
        this.versionList = versionList;
    }

    public List<String> getColorList() {
        return colorList;
    }

    public void setColorList(List<String> colorList) {
        this.colorList = colorList;
    }
}
