package com.aceplus.asartaline.data.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.support.annotation.Nullable;

import com.aceplus.asartaline.data.vo.AstlMealShop;
import com.aceplus.asartaline.data.vo.AstlWarDee;
import com.aceplus.asartaline.data.vo.GeneralTaste;
import com.aceplus.asartaline.data.vo.GetMealShopResponse;
import com.aceplus.asartaline.data.vo.GetWarDeeResponse;
import com.aceplus.asartaline.data.vo.MatchWarDeeList;
import com.aceplus.asartaline.data.vo.Review;
import com.aceplus.asartaline.data.vo.ShopByDistance;
import com.aceplus.asartaline.data.vo.ShopByPopularity;
import com.aceplus.asartaline.data.vo.SuitedFor;
import com.aceplus.asartaline.utils.AppConstants;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by kkk on 7/02/2018.
 */

public class AstlModel extends BaseModel {
    private static AstlModel INSTANCE;

    private AstlModel(Context context) {
        super(context);
    }

    public static AstlModel getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new AstlModel(context);
        }
        return INSTANCE;
    }

    public void loadData(final MutableLiveData<List<AstlWarDee>> mAstlWarDeeLD, final MutableLiveData<String> mMessageLD) {
        mApiService.getMealShop(AppConstants.access_token)
                .subscribeOn(Schedulers.io())
                .flatMap(new Function<GetMealShopResponse, ObservableSource<GetWarDeeResponse>>() {
                    @Override
                    public ObservableSource<GetWarDeeResponse> apply(GetMealShopResponse getMealShopResponse) throws Exception {
                        if (getMealShopResponse != null) {
                            saveMealShopIntoDB(getMealShopResponse.getAstlMealShop());
                            return mApiService.getWarDee(AppConstants.access_token);
                        } else mMessageLD.setValue("Cannot load data");
                        return null;
                    }
                })
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<GetWarDeeResponse>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(GetWarDeeResponse getWarDeeResponse) {
                        if (getWarDeeResponse != null) {
                            saveWarDeeIntoDB(getWarDeeResponse.getAstlWarDee());
                            mAstlWarDeeLD.setValue(getWarDeeResponse.getAstlWarDee());
                        } else
                            mMessageLD.setValue("Cannot load data");
                    }

                    @Override
                    public void onError(Throwable e) {
                        mMessageLD.setValue(e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    private void saveMealShopIntoDB(List<AstlMealShop> astlMealShops) {
        List<AstlMealShop> astlMealShopList = new ArrayList<>();
        List<Review> reviewList = new ArrayList<>();
        for (AstlMealShop astlMealShop : astlMealShops) {
            for (Review review : astlMealShop.getReviews()) {
                review.setAstlMealShopId(astlMealShop.getShopId());
                reviewList.add(review);
            }
            astlMealShopList.add(astlMealShop);
        }

        mAppDatabase.astlMealShopDao().insertAll(astlMealShopList);
        mAppDatabase.reviewDao().insertAll(reviewList);
    }

    private void saveWarDeeIntoDB(List<AstlWarDee> dataList) {
        List<AstlWarDee> astlWarDeeList = new ArrayList<>();
        List<GeneralTaste> generalTasteList = new ArrayList<>();
        List<SuitedFor> suitedForList = new ArrayList<>();
        List<ShopByDistance> shopByDistanceList = new ArrayList<>();
        List<ShopByPopularity> shopByPopularityList = new ArrayList<>();

        for (AstlWarDee astlWarDee : dataList) {
            for (GeneralTaste generalTaste : astlWarDee.getGeneralTaste()) {
                generalTaste.setWarDeeId(astlWarDee.getWarDeeId());
                generalTasteList.add(generalTaste);
            }
            for (SuitedFor suitedFor : astlWarDee.getSuitedFor()) {
                suitedFor.setWarDeeId(astlWarDee.getWarDeeId());
                suitedForList.add(suitedFor);
            }
            for (ShopByDistance shopByDistance : astlWarDee.getShopByDistance()) {
                shopByDistance.setWarDeeId(astlWarDee.getWarDeeId());
                shopByDistanceList.add(shopByDistance);
            }
            for (ShopByPopularity shopByPopularity : astlWarDee.getShopByPopularity()) {
                shopByPopularity.setWarDeeId(astlWarDee.getWarDeeId());
                shopByPopularityList.add(shopByPopularity);
            }
            astlWarDeeList.add(astlWarDee);
        }
        mAppDatabase.generalTasteDao().insertAll(generalTasteList);
        mAppDatabase.suitedForDao().insertAll(suitedForList);
        if (mAppDatabase.shopByDistanceDao().getCount() > 0) {
            mAppDatabase.shopByDistanceDao().deleteAll();
        }
        mAppDatabase.shopByDistanceDao().insertAll(shopByDistanceList);
        if (mAppDatabase.shopByPopularityDao().getCount() > 0) {
            mAppDatabase.shopByPopularityDao().deleteAll();
        }
        mAppDatabase.shopByPopularityDao().insertAll(shopByPopularityList);
        mAppDatabase.astlWarDeeDao().insertAll(astlWarDeeList);
    }

    public LiveData<List<AstlWarDee>> getAllWarDee() {
        return mAppDatabase.astlWarDeeDao().getAllDataLD();
    }

//    public AstlWarDee getWarDeeById(String id) {
//        return mAppDatabase.astlWarDeeDao().getDataById(id);
//    }

    public List<GeneralTaste> getGeneralTasteListByWarDeeId(String id) {
        return mAppDatabase.generalTasteDao().getDataByWarDeeId(id);
    }

    public List<SuitedFor> getSuitedForListByWarDeeId(String id) {
        return mAppDatabase.suitedForDao().getDataByWarDeeId(id);
    }

    public List<ShopByDistance> getShopByDistanceListByWarDeeId(String id) {
        return mAppDatabase.shopByDistanceDao().getDataByWarDeeId(id);
    }

    public List<ShopByPopularity> getShopByPopularityListByWarDeeId(String id) {
        return mAppDatabase.shopByPopularityDao().getAllDataByWarDeeId(id);
    }

    public AstlMealShop getShopListById(String id) {
        return mAppDatabase.astlMealShopDao().getDataById(id);
    }

    public List<Review> getReviewListByShopId(String shopId) {
        return mAppDatabase.reviewDao().getDataByShopId(shopId);
    }

    public LiveData<AstlWarDee> getWarDeeLDDetailById(final String id) {
        final MutableLiveData<AstlWarDee> liveData = new MutableLiveData<>();
        mAppDatabase.astlWarDeeDao().getDataLDById(id).observeForever(new android.arch.lifecycle.Observer<AstlWarDee>() {
            @Override
            public void onChanged(@Nullable AstlWarDee astlWarDee) {
                if (astlWarDee != null) {
                    astlWarDee.setGeneralTaste(mAppDatabase.generalTasteDao().getDataByWarDeeId(id));
                    astlWarDee.setSuitedFor(mAppDatabase.suitedForDao().getDataByWarDeeId(id));
                    List<AstlWarDee> matchWarDeeList = new ArrayList<>();
                    for (MatchWarDeeList warDeeList : astlWarDee.getMatchWarDeeList()) {
                        matchWarDeeList.add(mAppDatabase.astlWarDeeDao().getDataById(warDeeList.getWarDeeId()));
                    }
                    astlWarDee.setMatchWarDee(matchWarDeeList);

                    List<ShopByDistance> shopByDistanceList = new ArrayList<>();
                    for (ShopByDistance shopByDistance : mAppDatabase.shopByDistanceDao().getDataByWarDeeId(id)) {
                        shopByDistance.setAstlMealShop(mAppDatabase.astlMealShopDao().getDataById(shopByDistance.getMealShop().getMealShopId()));
                        shopByDistanceList.add(shopByDistance);
                    }
                    astlWarDee.setShopByDistance(shopByDistanceList);

                    List<ShopByPopularity> shopByPopularityList = new ArrayList<>();
                    for (ShopByPopularity shopByPopularity : mAppDatabase.shopByPopularityDao().getAllDataByWarDeeId(id)) {
                        shopByPopularity.setAstlMealShop(mAppDatabase.astlMealShopDao().getDataById(shopByPopularity.getMealShop().getMealShopId()));
                        shopByPopularityList.add(shopByPopularity);
                    }
                    astlWarDee.setShopByPopularity(shopByPopularityList);
                    liveData.setValue(astlWarDee);
                }
            }
        });
        return liveData;
    }
}
