package com.aceplus.asartaline.data.vo;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "suited_for")
public class SuitedFor implements DetailVO {

    @NonNull
    @PrimaryKey
    @SerializedName("suitedForId")
    @Expose
    private String suitedForId;

    @SerializedName("suitedFor")
    @Expose
    private String suitedFor;

    @SerializedName("suitedForDesc")
    @Expose
    private String suitedForDesc;

    @ColumnInfo(name = "warDeeId")
    private String warDeeId;

    public String getSuitedForId() {
        return suitedForId;
    }

    public void setSuitedForId(String suitedForId) {
        this.suitedForId = suitedForId;
    }

    public String getSuitedFor() {
        return suitedFor;
    }

    public void setSuitedFor(String suitedFor) {
        this.suitedFor = suitedFor;
    }

    public String getSuitedForDesc() {
        return suitedForDesc;
    }

    public void setSuitedForDesc(String suitedForDesc) {
        this.suitedForDesc = suitedForDesc;
    }

    public String getWarDeeId() {
        return warDeeId;
    }

    public void setWarDeeId(String warDeeId) {
        this.warDeeId = warDeeId;
    }
}