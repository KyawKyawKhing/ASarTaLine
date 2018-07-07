package com.aceplus.asartaline.persistence;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.aceplus.asartaline.data.vo.AstlMealShop;
import com.aceplus.asartaline.data.vo.AstlWarDee;
import com.aceplus.asartaline.data.vo.GeneralTaste;
import com.aceplus.asartaline.data.vo.Review;
import com.aceplus.asartaline.data.vo.ShopByDistance;
import com.aceplus.asartaline.data.vo.ShopByPopularity;
import com.aceplus.asartaline.data.vo.SuitedFor;
import com.aceplus.asartaline.persistence.Dao.AstlMealShopDao;
import com.aceplus.asartaline.persistence.Dao.AstlWarDeeDao;
import com.aceplus.asartaline.persistence.Dao.GeneralTasteDao;
import com.aceplus.asartaline.persistence.Dao.ReviewDao;
import com.aceplus.asartaline.persistence.Dao.ShopByDistanceDao;
import com.aceplus.asartaline.persistence.Dao.ShopByPopularityDao;
import com.aceplus.asartaline.persistence.Dao.SuitedForDao;

/**
 * Created by kkk on 7/02/2018.
 */

@Database(entities = {AstlWarDee.class, GeneralTaste.class, ShopByDistance.class, ShopByPopularity.class, SuitedFor.class, AstlMealShop.class, Review.class}, version = 1, exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    private static AppDatabase INSTANCE;
    private static String DB_NAME = "astl.db";

    public abstract AstlWarDeeDao astlWarDeeDao();

    public abstract GeneralTasteDao generalTasteDao();

    public abstract ShopByDistanceDao shopByDistanceDao();

    public abstract ShopByPopularityDao shopByPopularityDao();

    public abstract SuitedForDao suitedForDao();

    public abstract AstlMealShopDao astlMealShopDao();

    public abstract ReviewDao reviewDao();

    public static AppDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context, AppDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return INSTANCE;
    }
}
