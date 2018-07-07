package com.aceplus.asartaline.mvp.presenter;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.aceplus.asartaline.data.model.AstlModel;
import com.aceplus.asartaline.data.vo.AstlWarDee;
import com.aceplus.asartaline.data.vo.DetailVO;
import com.aceplus.asartaline.mvp.view.DetailView;

import java.util.List;

/**
 * Created by kkk on 7/2/2018.
 */

public class DetailPresenter extends BasePresenter<DetailView> {
    private AstlModel mAstlModel;
    private MutableLiveData<List<DetailVO>> mDetailVO;

    @Override
    public void initPresenter(DetailView view) {
        super.initPresenter(view);
        mAstlModel = AstlModel.getInstance(mView.getContext());
        mDetailVO = new MutableLiveData<>();
    }

    public LiveData<AstlWarDee> getWarDeeLDDetailById(String id) {
        return mAstlModel.getWarDeeLDDetailById(id);
    }

    public MutableLiveData<List<DetailVO>> getmDetailVO() {
        return mDetailVO;
    }
}
