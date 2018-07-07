package com.aceplus.asartaline.persistence.typeconvertor;

import android.arch.persistence.room.TypeConverter;

import com.aceplus.asartaline.data.vo.MatchWarDeeList;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

/**
 * Created by kkk on 7/3/2018.
 */

public class MatchWarDeeListTypeConvertor {
    @TypeConverter
    public static List<MatchWarDeeList> toList(String data) {
        Gson gson = new Gson();
        return gson.fromJson(data, new TypeToken<List<MatchWarDeeList>>() {
        }.getType());
    }

    @TypeConverter
    public static String toString(List<MatchWarDeeList> list) {
        Gson gson = new Gson();
        return gson.toJson(list);
    }
}
