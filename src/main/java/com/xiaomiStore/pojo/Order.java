package com.xiaomiStore.pojo;

import java.sql.Timestamp;

public class Order {
    private String orderId;
    private String userId;
    private int sum;
    private Timestamp timestamp;

    @Override
    public String toString() {
        return "User{" +
                "orderId='" + orderId + '\'' +
                ", userId='" + userId + '\'' +
                ", sum=" + sum +
                ", timestamp=" + timestamp +
                '}';
    }

    public Order(String orderId, String userId, int sum, Timestamp timestamp) {
        this.orderId = orderId;
        this.userId = userId;
        this.sum = sum;
        this.timestamp = timestamp;
    }

    public Order() {

    }

    public String getOrderId() {

        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getSum() {
        return sum;
    }

    public void setSum(int sum) {
        this.sum = sum;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
