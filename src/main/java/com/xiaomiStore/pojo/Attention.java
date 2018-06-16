package com.xiaomiStore.pojo;

public class Attention {
    private String userId;
    private String productId;

    @Override
    public String toString() {
        return "Attention{" +
                "userId='" + userId + '\'' +
                ", productId='" + productId + '\'' +
                '}';
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public Attention(String userId, String productId) {

        this.userId = userId;
        this.productId = productId;
    }

    public Attention() {

    }
}
