package com.aceplus.asartaline.persistence.typeconvertor;

import android.arch.persistence.room.TypeConverter;

import com.aceplus.asartaline.data.vo.MealShop;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * Created by kkk on 7/3/2018.
 */

public class MealShopTypeConvertor {

    @TypeConverter
    public static MealShop toVO(String data) {
        Gson gson = new Gson();
        return gson.fromJson(data, new TypeToken<MealShop>() {
        }.getType());
    }

    @TypeConverter
    public static String toString(MealShop data) {
        Gson gson = new Gson();
        return gson.toJson(data);
    }
}
