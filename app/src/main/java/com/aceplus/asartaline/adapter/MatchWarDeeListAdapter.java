package com.aceplus.asartaline.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.View;
import android.view.ViewGroup;

import com.aceplus.asartaline.R;
import com.aceplus.asartaline.data.vo.AstlWarDee;
import com.aceplus.asartaline.delegate.HomeDelegate;
import com.aceplus.asartaline.viewholder.WarDeeListViewHolder;

/**
 * Created by kkk on 7/2/2018.
 */

public class MatchWarDeeListAdapter extends BaseRecyclerAdapter<WarDeeListViewHolder, AstlWarDee> {
    private HomeDelegate homeDelegate;

    public MatchWarDeeListAdapter(Context context, HomeDelegate homeDelegate) {
        super(context);
        this.homeDelegate = homeDelegate;
    }

    @NonNull
    @Override
    public WarDeeListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.match_wardee_list_item, parent, false);
        return new WarDeeListViewHolder(view, homeDelegate);
    }
}
