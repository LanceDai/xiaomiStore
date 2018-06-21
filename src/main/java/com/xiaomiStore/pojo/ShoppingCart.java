package com.xiaomiStore.pojo;

public class ShoppingCart {
    private String cartId;
    private String userId;
    private int number;
    private int specificationId;

    @Override
    public String toString() {
        return "ShoppingCart{" +
                "cartId='" + cartId + '\'' +
                ", userId='" + userId + '\'' +
                ", number=" + number +
                ", specificationId=" + specificationId +
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

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public int getSpecificationId() {
        return specificationId;
    }

    public void setSpecificationId(int specificationId) {
        this.specificationId = specificationId;
    }

    public ShoppingCart(String cartId, String userId, int number, int specificationId) {

        this.cartId = cartId;
        this.userId = userId;
        this.number = number;
        this.specificationId = specificationId;
    }

    public ShoppingCart() {

    }
}
