package com.aceplus.asartaline.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "review")
public class Review {

    @NonNull
    @PrimaryKey
    @SerializedName("reviewId")
    @Expose
    private String reviewId;

    @SerializedName("review")
    @Expose
    private String review;

    @SerializedName("userId")
    @Expose
    private String userId;

    @SerializedName("userName")
    @Expose
    private String userName;

    @SerializedName("userImage")
    @Expose
    private String userImage;

    @SerializedName("timestamp")
    @Expose
    private String timestamp;

    @ColumnInfo(name = "astlMealShopId")
    private String astlMealShopId;

    public String getReviewId() {
        return reviewId;
    }

    public void setReviewId(String reviewId) {
        this.reviewId = reviewId;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

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

    public String getUserImage() {
        return userImage;
    }

    public void setUserImage(String userImage) {
        this.userImage = userImage;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getAstlMealShopId() {
        return astlMealShopId;
    }

    public void setAstlMealShopId(String astlMealShopId) {
        this.astlMealShopId = astlMealShopId;
    }
}