package com.aceplus.asartaline.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.aceplus.asartaline.R;
import com.aceplus.asartaline.data.vo.ShopByPopularity;
import com.aceplus.asartaline.viewholder.SBPViewHolder;

/**
 * Created by kkk on 7/2/2018.
 */

public class ShopByPopularityAdapter extends BaseRecyclerAdapter<SBPViewHolder, ShopByPopularity> {
    public ShopByPopularityAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public SBPViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.detail_sbp, parent, false);
        return new SBPViewHolder(view);
    }
}
