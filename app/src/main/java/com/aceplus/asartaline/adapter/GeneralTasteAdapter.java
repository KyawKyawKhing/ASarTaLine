package com.aceplus.asartaline.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.aceplus.asartaline.R;
import com.aceplus.asartaline.data.vo.GeneralTaste;
import com.aceplus.asartaline.viewholder.GeneralTasteViewHolder;

/**
 * Created by kkk on 7/2/2018.
 */

public class GeneralTasteAdapter extends BaseRecyclerAdapter<GeneralTasteViewHolder, GeneralTaste> {
    public GeneralTasteAdapter(Context context) {
        super(context);
    }
    @NonNull
    @Override
    public GeneralTasteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.detail_general_taste, parent, false);
        return new GeneralTasteViewHolder(view);
    }
}
