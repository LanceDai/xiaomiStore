package com.xiaomiStore.pojo;

import java.sql.Timestamp;

public class Order {
    private String orderId;
    private String userId;
    private int sum;
    private Timestamp timestamp;
    private String status;

    @Override
    public String toString() {
        return "Order{" +
                "orderId='" + orderId + '\'' +
                ", userId='" + userId + '\'' +
                ", sum=" + sum +
                ", timestamp=" + timestamp +
                ", status='" + status + '\'' +
                '}';
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Order() {

    }

    public Order(String orderId, String userId, int sum, Timestamp timestamp, String status) {

        this.orderId = orderId;
        this.userId = userId;
        this.sum = sum;
        this.timestamp = timestamp;
        this.status = status;
    }
}
