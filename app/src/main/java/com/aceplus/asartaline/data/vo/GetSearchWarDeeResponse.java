package com.aceplus.asartaline.data.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetSearchWarDeeResponse {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("apiVersion")
    @Expose
    private String apiVersion;
    @SerializedName("tasteType")
    @Expose
    private String tasteType;
    @SerializedName("suited")
    @Expose
    private String suited;
    @SerializedName("minPrice")
    @Expose
    private String minPrice;
    @SerializedName("maxPrice")
    @Expose
    private String maxPrice;
    @SerializedName("isNearBy")
    @Expose
    private String isNearBy;
    @SerializedName("currentTownship")
    @Expose
    private String currentTownship;
    @SerializedName("currentTLat")
    @Expose
    private String currentTLat;
    @SerializedName("currentLng")
    @Expose
    private String currentLng;
    @SerializedName("searchResults")
    @Expose
    private List<AstlWarDee> searchResults = null;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public void setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
    }

    public String getTasteType() {
        return tasteType;
    }

    public void setTasteType(String tasteType) {
        this.tasteType = tasteType;
    }

    public String getSuited() {
        return suited;
    }

    public void setSuited(String suited) {
        this.suited = suited;
    }

    public String getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(String minPrice) {
        this.minPrice = minPrice;
    }

    public String getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(String maxPrice) {
        this.maxPrice = maxPrice;
    }

    public String getIsNearBy() {
        return isNearBy;
    }

    public void setIsNearBy(String isNearBy) {
        this.isNearBy = isNearBy;
    }

    public String getCurrentTownship() {
        return currentTownship;
    }

    public void setCurrentTownship(String currentTownship) {
        this.currentTownship = currentTownship;
    }

    public String getCurrentTLat() {
        return currentTLat;
    }

    public void setCurrentTLat(String currentTLat) {
        this.currentTLat = currentTLat;
    }

    public String getCurrentLng() {
        return currentLng;
    }

    public void setCurrentLng(String currentLng) {
        this.currentLng = currentLng;
    }

    public List<AstlWarDee> getSearchResults() {
        return searchResults;
    }

    public void setSearchResults(List<AstlWarDee> searchResults) {
        this.searchResults = searchResults;
    }

}