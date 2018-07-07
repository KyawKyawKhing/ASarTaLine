package com.aceplus.asartaline.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.aceplus.asartaline.R;
import com.aceplus.asartaline.data.vo.SuitedFor;
import com.aceplus.asartaline.viewholder.SuitedForViewHolder;

/**
 * Created by kkk on 7/2/2018.
 */

public class SuitedForAdapter extends BaseRecyclerAdapter<SuitedForViewHolder, SuitedFor> {
    public SuitedForAdapter(Context context) {
        super(context);
    }

    @NonNull
    @Override
    public SuitedForViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.detail_suited_for, parent, false);
        return new SuitedForViewHolder(view);
    }
}
