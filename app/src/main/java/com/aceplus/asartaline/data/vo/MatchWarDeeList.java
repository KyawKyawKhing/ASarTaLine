package com.aceplus.asartaline.data.vo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class MatchWarDeeList implements DetailVO {

    @SerializedName("warDeeId")
    @Expose
    private String warDeeId;

    public String getWarDeeId() {
        return warDeeId;
    }

    public void setWarDeeId(String warDeeId) {
        this.warDeeId = warDeeId;
    }

}