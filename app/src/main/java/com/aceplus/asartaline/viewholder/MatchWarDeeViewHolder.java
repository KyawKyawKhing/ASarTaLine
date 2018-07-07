package com.aceplus.asartaline.viewholder;

import android.util.Log;
import android.view.View;

import com.aceplus.asartaline.data.vo.MatchWarDeeList;
import com.google.gson.Gson;

/**
 * Created by kkk on 7/7/2018.
 */

public class MatchWarDeeViewHolder extends BaseViewHolder<MatchWarDeeList> {

    public MatchWarDeeViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(MatchWarDeeList data) {
        Log.e("matchwardeelist", new Gson().toJson(data));
    }
}
