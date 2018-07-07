
package com.aceplus.asartaline.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.aceplus.asartaline.persistence.typeconvertor.MealShopTypeConvertor;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "shop_by_distance")
@TypeConverters(MealShopTypeConvertor.class)
public class ShopByDistance {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private long id;

    @SerializedName("shopByDistanceId")
    @Expose
    private String shopByDistanceId;

    @SerializedName("mealShop")
    @Expose
    private MealShop mealShop;

    @SerializedName("distanceInFeet")
    @Expose
    private Double distanceInFeet;

    @ColumnInfo(name = "warDeeId")
    private String warDeeId;

    @Ignore
    private AstlMealShop astlMealShop;

    @NonNull
    public long getId() {
        return id;
    }

    public void setId(@NonNull long id) {
        this.id = id;
    }

    public String getShopByDistanceId() {
        return shopByDistanceId;
    }

    public void setShopByDistanceId(String shopByDistanceId) {
        this.shopByDistanceId = shopByDistanceId;
    }

    public MealShop getMealShop() {
        return mealShop;
    }

    public void setMealShop(MealShop mealShop) {
        this.mealShop = mealShop;
    }

    public Double getDistanceInFeet() {
        return distanceInFeet;
    }

    public void setDistanceInFeet(Double distanceInFeet) {
        this.distanceInFeet = distanceInFeet;
    }

    public String getWarDeeId() {
        return warDeeId;
    }

    public void setWarDeeId(String warDeeId) {
        this.warDeeId = warDeeId;
    }

    public AstlMealShop getAstlMealShop() {
        return astlMealShop;
    }

    public void setAstlMealShop(AstlMealShop astlMealShop) {
        this.astlMealShop = astlMealShop;
    }
}