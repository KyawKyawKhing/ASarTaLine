package com.aceplus.asartaline.viewholder;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aceplus.asartaline.R;
import com.aceplus.asartaline.data.vo.ShopByDistance;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import butterknife.BindView;

/**
 * Created by kkk on 7/7/2018.
 */

public class SBDViewHolder extends BaseViewHolder<ShopByDistance> {
    @BindView(R.id.iv_sbd_mealshop)
    ImageView ivShop;
    @BindView(R.id.tv_sbd_feet)
    TextView tvSBDFeet;
    @BindView(R.id.tv_sbd_mealshop)
    TextView tvSBDMealShop;

    public SBDViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(ShopByDistance data) {
        Log.e("sbd", new Gson().toJson(data));
        Glide.with(itemView.getContext())
                .load(data.getAstlMealShop().getShopImages().get(0))
                .into(ivShop);
        tvSBDFeet.setText(String.valueOf(data.getDistanceInFeet()) + " feet");
        tvSBDMealShop.setText(data.getAstlMealShop().getName());
    }
}
