package com.aceplus.asartaline.mvp.presenter;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.aceplus.asartaline.mvp.view.BaseView;

/**
 * Created by kkk on 7/02/2018.
 */

public abstract class BasePresenter<V extends BaseView> extends ViewModel {
    protected V mView;
    protected MutableLiveData<String> mMessageLD;

    public void initPresenter(V view) {
        mView = view;
        mMessageLD = new MutableLiveData<>();
    }

    public MutableLiveData<String> getmErrorLiveData() {
        return mMessageLD;
    }
}
