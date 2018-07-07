package com.aceplus.asartaline.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.aceplus.asartaline.R;
import com.aceplus.asartaline.data.vo.AstlWarDee;
import com.aceplus.asartaline.delegate.HomeDelegate;
import com.bumptech.glide.Glide;

import butterknife.BindView;

/**
 * Created by kkk on 7/2/2018.
 */

public class WarDeeListViewHolder extends BaseViewHolder<AstlWarDee> {
    @BindView(R.id.iv_wardee)
    ImageView ivWarDee;
    @BindView(R.id.tv_wardee_title)
    TextView tvWarDeeTitle;
    @BindView(R.id.tv_wardee_desp)
    TextView tvWarDeeDesp;

    HomeDelegate homeDelegate;

    public WarDeeListViewHolder(View itemView, HomeDelegate homeDelegate) {
        super(itemView);
        this.homeDelegate = homeDelegate;
    }

    @Override
    public void setData(final AstlWarDee data) {
        Glide.with(itemView.getContext())
                .load(data.getImages().get(0))
                .into(ivWarDee);
        tvWarDeeTitle.setText(data.getName());
        tvWarDeeDesp.setText(data.getMatchWarDeeList().get(0).getWarDeeId());
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                homeDelegate.onTapItemList(data.getWarDeeId());
            }
        });
    }
}
