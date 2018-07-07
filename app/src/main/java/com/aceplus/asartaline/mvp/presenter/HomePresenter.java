package com.aceplus.asartaline.mvp.presenter;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.aceplus.asartaline.data.model.AstlModel;
import com.aceplus.asartaline.data.vo.AstlWarDee;
import com.aceplus.asartaline.mvp.view.HomeView;

import java.util.List;

/**
 * Created by kkk on 7/2/2018.
 */

public class HomePresenter extends BasePresenter<HomeView> {
    private AstlModel mAstlModel;
    private MutableLiveData<List<AstlWarDee>> mAstlWarDeeLD;

    @Override
    public void initPresenter(HomeView view) {
        super.initPresenter(view);
        mAstlModel = AstlModel.getInstance(mView.getContext());
        mAstlWarDeeLD = new MutableLiveData<>();
        loadData();
    }

    public void loadData() {
        mAstlModel.loadData(mAstlWarDeeLD, mMessageLD);
    }

    public LiveData<List<AstlWarDee>> getAllWarDeeLD() {
        return mAstlModel.getAllWarDee();
    }

    public LiveData<List<AstlWarDee>> getmAstlWarDeeLD() {
        return mAstlWarDeeLD;
    }
}
