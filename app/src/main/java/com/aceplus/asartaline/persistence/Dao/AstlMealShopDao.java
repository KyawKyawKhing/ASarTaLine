package com.aceplus.asartaline.persistence.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.aceplus.asartaline.data.vo.AstlMealShop;

import java.util.List;

/**
 * Created by kkk on 7/2/2018.
 */

@Dao
public interface AstlMealShopDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<AstlMealShop> astlMealShopList);

    @Query("select * from astl_meal_shop")
    LiveData<List<AstlMealShop>> getAllDataLD();

    @Query("select * from astl_meal_shop where astlMealShopId = :id")
    AstlMealShop getDataById(String id);

    @Query("select * from astl_meal_shop")
    List<AstlMealShop> getAllData();
}
