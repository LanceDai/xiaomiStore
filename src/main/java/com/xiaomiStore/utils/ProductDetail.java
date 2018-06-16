package com.xiaomiStore.utils;

import java.util.Map;

public class ProductDetail {

    private String productName;

    public Map<String, String> getVersionList() {
        return versionList;
    }

    private Map<String, String> versionList;

    public Map<String, String> getColorList() {
        return colorList;
    }

    private Map<String, String> colorList;

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

    public void setVersionList(Map<String, String> versionList) {
        this.versionList = versionList;
    }

    public void setColorList(Map<String, String> colorList) {
        this.colorList = colorList;
    }
}
