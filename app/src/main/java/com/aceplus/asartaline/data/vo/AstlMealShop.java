package com.aceplus.asartaline.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.aceplus.asartaline.persistence.typeconvertor.WarDeeImagesTypeConvertor;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "astl_meal_shop")
@TypeConverters(WarDeeImagesTypeConvertor.class)
public class AstlMealShop {

    @NonNull
    @PrimaryKey
    @SerializedName("shopId")
    @Expose
    @ColumnInfo(name = "astlMealShopId")
    private String shopId;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("address")
    @Expose
    private String address;

    @SerializedName("lat")
    @Expose
    private Double lat;

    @SerializedName("lng")
    @Expose
    private Double lng;

    @SerializedName("township")
    @Expose
    private String township;

    @SerializedName("popularity")
    @Expose
    private Double popularity;

    @SerializedName("shopImages")
    @Expose
    private List<String> shopImages = null;

    @Ignore
    @SerializedName("reviews")
    @Expose
    private List<Review> reviews = null;

    public String getShopId() {
        return shopId;
    }

    public void setShopId(String shopId) {
        this.shopId = shopId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getTownship() {
        return township;
    }

    public void setTownship(String township) {
        this.township = township;
    }

    public Double getPopularity() {
        return popularity;
    }

    public void setPopularity(Double popularity) {
        this.popularity = popularity;
    }

    public List<String> getShopImages() {
        return shopImages;
    }

    public void setShopImages(List<String> shopImages) {
        this.shopImages = shopImages;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

}