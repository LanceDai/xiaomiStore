package com.xiaomiStore.pojo;

import java.sql.Timestamp;

public class Comment {
    //评论
    private String commentId;
    private String userId;
    private String productId;
    private Timestamp createTime;
    private String comment;

    @Override
    public String toString() {
        return "Comment{" +
                "commentId='" + commentId + '\'' +
                ", userId='" + userId + '\'' +
                ", productId='" + productId + '\'' +
                ", createTime=" + createTime +
                ", comment='" + comment + '\'' +
                '}';
    }

    public String getCommentId() {
        return commentId;
    }

    public void setCommentId(String commentId) {
        this.commentId = commentId;
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

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Comment(String commentId, String userId, String productId, Timestamp createTime, String comment) {

        this.commentId = commentId;
        this.userId = userId;
        this.productId = productId;
        this.createTime = createTime;
        this.comment = comment;
    }

    public Comment() {

    }
}
