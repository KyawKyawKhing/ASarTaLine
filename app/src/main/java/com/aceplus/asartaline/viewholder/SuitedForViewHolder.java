package com.aceplus.asartaline.viewholder;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.aceplus.asartaline.R;
import com.aceplus.asartaline.data.vo.SuitedFor;
import com.google.gson.Gson;

import butterknife.BindView;

/**
 * Created by kkk on 7/7/2018.
 */

public class SuitedForViewHolder extends BaseViewHolder<SuitedFor> {
    @BindView(R.id.tv_suitedfor_title)
    TextView tvSuitedforTitle;
    @BindView(R.id.tv_suitedfor_desp)
    TextView tvSuitedforDesp;

    public SuitedForViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(SuitedFor data) {
        Log.e("suitefor", new Gson().toJson(data));
        tvSuitedforTitle.setText(data.getSuitedFor());
        tvSuitedforDesp.setText(data.getSuitedForDesc());
    }
}
