package com.aceplus.asartaline.data.vo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.aceplus.asartaline.persistence.typeconvertor.MatchWarDeeListTypeConvertor;
import com.aceplus.asartaline.persistence.typeconvertor.WarDeeImagesTypeConvertor;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "astl_wardee")
@TypeConverters({WarDeeImagesTypeConvertor.class, MatchWarDeeListTypeConvertor.class})
public class AstlWarDee implements DetailVO {

    @NonNull
    @PrimaryKey
    @SerializedName("warDeeId")
    @Expose
    private String warDeeId;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("images")
    @Expose
    private List<String> images = null;

    @Ignore
    @SerializedName("generalTaste")
    @Expose
    private List<GeneralTaste> generalTaste = null;

    @Ignore
    @SerializedName("suitedFor")
    @Expose
    private List<SuitedFor> suitedFor = null;

    @SerializedName("priceRangeMin")
    @Expose
    private Integer priceRangeMin;

    @SerializedName("priceRangeMax")
    @Expose
    private Integer priceRangeMax;

    @SerializedName("matchWarDeeList")
    @Expose
    private List<MatchWarDeeList> matchWarDeeList = null;

    @Ignore
    @SerializedName("shopByDistance")
    @Expose
    private List<ShopByDistance> shopByDistance = null;

    @Ignore
    @SerializedName("shopByPopularity")
    @Expose
    private List<ShopByPopularity> shopByPopularity = null;


    @Ignore
    private List<AstlWarDee> matchWarDee;

    public String getWarDeeId() {
        return warDeeId;
    }

    public void setWarDeeId(String warDeeId) {
        this.warDeeId = warDeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getImages() {
        return images;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public List<GeneralTaste> getGeneralTaste() {
        return generalTaste;
    }

    public void setGeneralTaste(List<GeneralTaste> generalTaste) {
        this.generalTaste = generalTaste;
    }

    public List<SuitedFor> getSuitedFor() {
        return suitedFor;
    }

    public void setSuitedFor(List<SuitedFor> suitedFor) {
        this.suitedFor = suitedFor;
    }

    public Integer getPriceRangeMin() {
        return priceRangeMin;
    }

    public void setPriceRangeMin(Integer priceRangeMin) {
        this.priceRangeMin = priceRangeMin;
    }

    public Integer getPriceRangeMax() {
        return priceRangeMax;
    }

    public void setPriceRangeMax(Integer priceRangeMax) {
        this.priceRangeMax = priceRangeMax;
    }

    public List<MatchWarDeeList> getMatchWarDeeList() {
        return matchWarDeeList;
    }

    public void setMatchWarDeeList(List<MatchWarDeeList> matchWarDeeList) {
        this.matchWarDeeList = matchWarDeeList;
    }

    public List<ShopByDistance> getShopByDistance() {
        return shopByDistance;
    }

    public void setShopByDistance(List<ShopByDistance> shopByDistance) {
        this.shopByDistance = shopByDistance;
    }

    public List<ShopByPopularity> getShopByPopularity() {
        return shopByPopularity;
    }

    public void setShopByPopularity(List<ShopByPopularity> shopByPopularity) {
        this.shopByPopularity = shopByPopularity;
    }

    public List<AstlWarDee> getMatchWarDee() {
        return matchWarDee;
    }

    public void setMatchWarDee(List<AstlWarDee> matchWarDee) {
        this.matchWarDee = matchWarDee;
    }
}