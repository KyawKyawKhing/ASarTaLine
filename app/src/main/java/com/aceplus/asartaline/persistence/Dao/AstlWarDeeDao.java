package com.aceplus.asartaline.persistence.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.aceplus.asartaline.data.vo.AstlWarDee;

import java.util.List;

/**
 * Created by kkk on 7/2/2018.
 */

@Dao
public interface AstlWarDeeDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<AstlWarDee> warDeeList);

    @Query("select * from astl_wardee")
    LiveData<List<AstlWarDee>> getAllDataLD();

    @Query("select * from astl_wardee where warDeeId = :id")
    LiveData<AstlWarDee> getDataLDById(String id);

    @Query("select * from astl_wardee where warDeeId = :id")
    AstlWarDee getDataById(String id);

    @Query("select * from astl_wardee")
    List<AstlWarDee> getAllData();
}
