package com.aceplus.asartaline.persistence.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.aceplus.asartaline.data.vo.SuitedFor;

import java.util.List;

/**
 * Created by kkk on 7/2/2018.
 */

@Dao
public interface SuitedForDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<SuitedFor> suitedForList);

    @Query("select * from suited_for")
    LiveData<List<SuitedFor>> getAllDataLD();

    @Query("select * from suited_for where suitedForId = :id")
    SuitedFor getDataById(String id);

    @Query("select * from suited_for")
    List<SuitedFor> getAllData();

    @Query("select * from suited_for where warDeeId=:id")
    List<SuitedFor> getDataByWarDeeId(String id);
}
