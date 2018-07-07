package com.aceplus.asartaline.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.aceplus.asartaline.R;
import com.aceplus.asartaline.data.vo.ShopByDistance;
import com.aceplus.asartaline.viewholder.SBDViewHolder;

/**
 * Created by kkk on 7/2/2018.
 */

public class ShopByDistanceAdapter extends BaseRecyclerAdapter<SBDViewHolder, ShopByDistance> {
    public ShopByDistanceAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public SBDViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.detail_sbd, parent, false);
        return new SBDViewHolder(view);
    }
}
