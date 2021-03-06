package com.aceplus.asartaline.persistence.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.aceplus.asartaline.data.vo.Review;

import java.util.List;

/**
 * Created by kkk on 7/2/2018.
 */

@Dao
public interface ReviewDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Review> reviewList);

    @Query("select * from review")
    LiveData<List<Review>> getAllDataLD();

    @Query("select * from review where astlMealShopId = :shopId")
    List<Review> getDataByShopId(String shopId);

    @Query("select * from review")
    List<Review> getAllData();
}
