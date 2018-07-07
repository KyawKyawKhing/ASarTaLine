package com.aceplus.asartaline.viewholder;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.aceplus.asartaline.R;
import com.aceplus.asartaline.data.vo.AstlWarDee;
import com.google.gson.Gson;

import butterknife.BindView;

/**
 * Created by kkk on 7/7/2018.
 */

public class DetailStartInfoViewHolder extends BaseViewHolder<AstlWarDee> {
    @BindView(R.id.tv_minprice)
    TextView tvMinPrice;
    @BindView(R.id.tv_maxprice)
    TextView tvMaxPrice;

    public DetailStartInfoViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(AstlWarDee data) {
        tvMinPrice.setText(String.valueOf(data.getPriceRangeMax()));
        tvMaxPrice.setText(String.valueOf(data.getPriceRangeMax()));
        Log.e("startinfo", new Gson().toJson(data));
    }
}
