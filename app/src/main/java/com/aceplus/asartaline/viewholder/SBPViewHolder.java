package com.aceplus.asartaline.viewholder;

import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aceplus.asartaline.R;
import com.aceplus.asartaline.data.vo.ShopByPopularity;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import butterknife.BindView;

/**
 * Created by kkk on 7/7/2018.
 */

public class SBPViewHolder extends BaseViewHolder<ShopByPopularity> {
    @BindView(R.id.iv_sbp_mealshop)
    ImageView ivShop;
    @BindView(R.id.tv_sbp_mealshop)
    TextView tvSBPMealShop;

    public SBPViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(ShopByPopularity data) {
        Log.e("sbp", new Gson().toJson(data));
        if (data.getAstlMealShop() != null) {
            if (data.getAstlMealShop().getShopImages().size() > 0) {
                Glide.with(itemView.getContext())
                        .load(data.getAstlMealShop().getShopImages().get(0))
                        .into(ivShop);
            }
            tvSBPMealShop.setText(data.getAstlMealShop().getName());
        }

    }
}
