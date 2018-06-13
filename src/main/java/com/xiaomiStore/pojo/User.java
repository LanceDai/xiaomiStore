package com.xiaomiStore.pojo;


import java.sql.Timestamp;

public class User {
   private String userId;
   private String userName;
   private String telephoneNumber;
   private Timestamp createTime;
   private String img;
   private String hobby;
   private String address;
   private String sign;
    private String password;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public User(String userId, String userName, String password, String telephoneNumber, Timestamp createTime, String img, String hobby, String address, String sign) {

        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.telephoneNumber = telephoneNumber;
        this.createTime = createTime;
        this.img = img;
        this.hobby = hobby;
        this.address = address;
        this.sign = sign;
    }

    public User() {

    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", telephoneNumber='" + telephoneNumber + '\'' +
                ", createTime=" + createTime +
                ", img='" + img + '\'' +
                ", hobby='" + hobby + '\'' +
                ", address='" + address + '\'' +
                ", sign='" + sign + '\'' +
                '}';
    }
}
