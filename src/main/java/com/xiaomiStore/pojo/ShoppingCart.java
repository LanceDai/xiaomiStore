package com.xiaomiStore.pojo;

public class ShoppingCart {
    private String cartId;
    private String userId;
    private String versionId;
    private int number;

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "cartId='" + cartId + '\'' +
                ", userId='" + userId + '\'' +
                ", versionId='" + versionId + '\'' +
                ", number=" + number +
                '}';
    }

    public String getCartId() {
        return cartId;
    }

    public void setCartId(String cartId) {
        this.cartId = cartId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVersionId() {
        return versionId;
    }

    public void setVersionId(String versionId) {
        this.versionId = versionId;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public ShoppingCart() {

    }

    public ShoppingCart(String cartId, String userId, String versionId, int number) {

        this.cartId = cartId;
        this.userId = userId;
        this.versionId = versionId;
        this.number = number;
    }
}
