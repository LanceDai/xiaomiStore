package com.xiaomiStore.pojo;

public class Coupon {
    //优惠券
    private String couponId;
    private String name;
    private String price;
    private String description;
    private String status;

    public Coupon() {
    }

    @Override
    public String toString() {
        return "Coupon{" +
                "couponId='" + couponId + '\'' +
                ", name='" + name + '\'' +
                ", price='" + price + '\'' +
                ", description='" + description + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Coupon(String couponId, String name, String price, String description, String status) {

        this.couponId = couponId;
        this.name = name;
        this.price = price;
        this.description = description;
        this.status = status;
    }
}
