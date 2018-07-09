package com.xiaomiStore.pojo;

import java.sql.Timestamp;

public class Order {
    private String orderId;
    private String userId;
    private int sum;
    private Timestamp createTime;
    private String status;

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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Order(String orderId, String userId, int sum, Timestamp createTime, String status) {

        this.orderId = orderId;
        this.userId = userId;
        this.sum = sum;
        this.createTime = createTime;
        this.status = status;
    }

    public Order() {

    }
}
