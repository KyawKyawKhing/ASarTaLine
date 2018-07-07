package com.aceplus.asartaline.persistence.Dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.aceplus.asartaline.data.vo.GeneralTaste;

import java.util.List;

/**
 * Created by kkk on 7/2/2018.
 */

@Dao
public interface GeneralTasteDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<GeneralTaste> warDeeList);

    @Query("select * from general_taste")
    LiveData<List<GeneralTaste>> getAllDataLD();

    @Query("select * from general_taste where tasteId = :id")
    GeneralTaste getDataById(String  id);

    @Query("select * from general_taste")
    List<GeneralTaste> getAllData();

    @Query("select * from general_taste where warDeeId=:id")
    List<GeneralTaste> getDataByWarDeeId(String id);
}
