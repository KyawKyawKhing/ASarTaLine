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

@Entity(tableName = "shop_by_popularity")
@TypeConverters(MealShopTypeConvertor.class)
public class ShopByPopularity {

    @NonNull
    @PrimaryKey(autoGenerate = true)
    private long id;

    @SerializedName("shopByPopularityId")
    @Expose
    private String shopByPopularityId;


    @SerializedName("mealShop")
    @Expose
    private MealShop mealShop;

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

    public String getShopByPopularityId() {
        return shopByPopularityId;
    }

    public void setShopByPopularityId(String shopByPopularityId) {
        this.shopByPopularityId = shopByPopularityId;
    }

    public MealShop getMealShop() {
        return mealShop;
    }

    public void setMealShop(MealShop mealShop) {
        this.mealShop = mealShop;
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