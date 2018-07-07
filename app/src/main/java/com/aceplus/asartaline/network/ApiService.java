package com.aceplus.asartaline.network;

import com.aceplus.asartaline.data.vo.GetMealShopResponse;
import com.aceplus.asartaline.data.vo.GetSearchWarDeeResponse;
import com.aceplus.asartaline.data.vo.GetWarDeeResponse;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by kkk on 7/02/2018.
 */

public interface ApiService {

    @FormUrlEncoded
    @POST("GetWarDee.php")
    Observable<GetWarDeeResponse> getWarDee(@Field("access_token") String accessToken);

    @FormUrlEncoded
    @POST("SearchWarDee.php")
    Observable<GetSearchWarDeeResponse> getSearchWarDee(@Field("access_token") String accessToken,
                                                        @Field("taste_type") String tasteType,
                                                        @Field("suited") String suited,
                                                        @Field("min_price") String minPrice,
                                                        @Field("max_price") String maxPrice,
                                                        @Field("is_nearby") String isNearby,
                                                        @Field("current_township") String currentTownship,
                                                        @Field("current_lat") String currentLat,
                                                        @Field("current_lng") String currentLng);

    @FormUrlEncoded
    @POST("GetMealShop.php")
    Observable<GetMealShopResponse> getMealShop(@Field("access_token") String accessToken);
}
