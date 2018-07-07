package com.aceplus.asartaline.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.aceplus.asartaline.R;
import com.aceplus.asartaline.data.vo.AstlWarDee;
import com.aceplus.asartaline.data.vo.DetailVO;
import com.aceplus.asartaline.data.vo.GeneralTaste;
import com.aceplus.asartaline.data.vo.MatchWarDeeList;
import com.aceplus.asartaline.data.vo.ShopByDistance;
import com.aceplus.asartaline.data.vo.ShopByPopularity;
import com.aceplus.asartaline.data.vo.SuitedFor;
import com.aceplus.asartaline.delegate.DetailWarDeeDelegate;
import com.aceplus.asartaline.viewholder.BaseViewHolder;
import com.aceplus.asartaline.viewholder.DetailStartInfoViewHolder;
import com.aceplus.asartaline.viewholder.GeneralTasteViewHolder;
import com.aceplus.asartaline.viewholder.MatchWarDeeViewHolder;
import com.aceplus.asartaline.viewholder.SBDViewHolder;
import com.aceplus.asartaline.viewholder.SBPViewHolder;
import com.aceplus.asartaline.viewholder.SuitedForViewHolder;

import java.util.List;

/**
 * Created by kkk on 7/7/2018.
 */

public class DetailWarDeeAdapter extends BaseRecyclerAdapter<BaseViewHolder, DetailVO> {

    private final int START_INFO_LAYOUT = 0;
    private final int TASTE_RV_LAYOUT = 1;
    private final int SUITEDFOR_RV_LAYOUT = 2;
    private final int MATCH_WARDEE_RV_LAYOUT = 3;
    private final int SBD_RV_LAYOUT = 4;
    private final int SBP_RV_LAYOUT = 5;

    private DetailWarDeeDelegate detailWarDeeDelegate;

    public DetailWarDeeAdapter(Context context, DetailWarDeeDelegate detailWarDeeDelegate) {
        super(context);
        this.detailWarDeeDelegate = detailWarDeeDelegate;
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == START_INFO_LAYOUT) {
            View start_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_start_info, parent, false);
            return new DetailStartInfoViewHolder(start_view);
        } else if (viewType == TASTE_RV_LAYOUT) {
            View horizontal_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_general_taste, parent, false);
            return new GeneralTasteViewHolder(horizontal_view);
        } else if (viewType == SUITEDFOR_RV_LAYOUT) {
            View single_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_suited_for, parent, false);
            return new SuitedForViewHolder(single_view);
        } else if (viewType == MATCH_WARDEE_RV_LAYOUT) {
            View single_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_match_wardee, parent, false);
            return new MatchWarDeeViewHolder(single_view);
        } else if (viewType == SBD_RV_LAYOUT) {
            View single_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_sbd, parent, false);
            return new SBDViewHolder(single_view);
        } else if (viewType == SBP_RV_LAYOUT) {
            View single_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_sbp, parent, false);
            return new SBPViewHolder(single_view);
        }
        View single_view = LayoutInflater.from(parent.getContext()).inflate(R.layout.detail_sbp, parent, false);
        return new SBPViewHolder(single_view);
    }

    @Override
    public int getItemViewType(int position) {
        if (mDataList.get(position) instanceof AstlWarDee) {
            return START_INFO_LAYOUT;
        } else if (mDataList.get(position) instanceof GeneralTaste) {
            return TASTE_RV_LAYOUT;
        } else if (mDataList.get(position) instanceof SuitedFor) {
            return SUITEDFOR_RV_LAYOUT;
        } else if (mDataList.get(position) instanceof MatchWarDeeList) {
            return MATCH_WARDEE_RV_LAYOUT;
        } else if (mDataList.get(position) instanceof ShopByDistance) {
            return SBD_RV_LAYOUT;
        } else if (mDataList.get(position) instanceof ShopByPopularity) {
            return SBP_RV_LAYOUT;
        }
        return -1;
    }

    public void setNewList(List<DetailVO> objectArrayList) {
        mDataList = objectArrayList;
        notifyDataSetChanged();
    }


}
