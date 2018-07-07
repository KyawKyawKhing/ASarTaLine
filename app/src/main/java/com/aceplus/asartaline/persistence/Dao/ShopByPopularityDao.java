package com.aceplus.asartaline.persistence.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.aceplus.asartaline.data.vo.ShopByPopularity;

import java.util.List;

/**
 * Created by kkk on 7/2/2018.
 */

@Dao
public interface ShopByPopularityDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<ShopByPopularity> popularityList);

    @Query("select * from shop_by_popularity")
    LiveData<List<ShopByPopularity>> getAllDataLD();

    @Query("select * from shop_by_popularity where shopByPopularityId = :id")
    ShopByPopularity getDataById(String id);

    @Query("select * from shop_by_popularity")
    List<ShopByPopularity> getAllData();

    @Query("select * from shop_by_popularity where warDeeId=:id")
    List<ShopByPopularity> getAllDataByWarDeeId(String id);

    @Query("Delete from shop_by_popularity")
    void deleteAll();

    @Query("SELECT COUNT(id) from shop_by_popularity")
    int getCount();
}
