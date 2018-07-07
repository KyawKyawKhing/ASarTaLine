package com.aceplus.asartaline.data.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetMealShopResponse {

    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("apiVersion")
    @Expose
    private String apiVersion;
    @SerializedName("astlMealShop")
    @Expose
    private List<AstlMealShop> astlMealShop = null;

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

    public List<AstlMealShop> getAstlMealShop() {
        return astlMealShop;
    }

    public void setAstlMealShop(List<AstlMealShop> astlMealShop) {
        this.astlMealShop = astlMealShop;
    }

}