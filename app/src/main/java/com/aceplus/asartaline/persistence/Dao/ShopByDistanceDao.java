package com.aceplus.asartaline.persistence.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.aceplus.asartaline.data.vo.ShopByDistance;

import java.util.List;

/**
 * Created by kkk on 7/2/2018.
 */

@Dao
public interface ShopByDistanceDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<ShopByDistance> shopByDistanceList);

    @Query("select * from shop_by_distance")
    LiveData<List<ShopByDistance>> getAllDataLD();

    @Query("select * from shop_by_distance where shopByDistanceId = :id")
    ShopByDistance getDataById(String id);

    @Query("select * from shop_by_distance")
    List<ShopByDistance> getAllData();

    @Query("select * from shop_by_distance where warDeeId=:id")
    List<ShopByDistance> getDataByWarDeeId(String id);

    @Query("Delete from shop_by_distance")
    void deleteAll();

    @Query("SELECT COUNT(id) from shop_by_distance")
    int getCount();
}
