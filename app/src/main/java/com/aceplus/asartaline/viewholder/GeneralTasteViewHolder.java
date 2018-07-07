package com.aceplus.asartaline.viewholder;

import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.aceplus.asartaline.R;
import com.aceplus.asartaline.data.vo.GeneralTaste;
import com.google.gson.Gson;

import butterknife.BindView;

/**
 * Created by kkk on 7/7/2018.
 */

public class GeneralTasteViewHolder extends BaseViewHolder<GeneralTaste> {
    @BindView(R.id.tv_taste_title)
    TextView tvTasteTitle;
    @BindView(R.id.tv_taste_desp)
    TextView tvTasteDesp;

    public GeneralTasteViewHolder(View itemView) {
        super(itemView);
    }

    @Override
    public void setData(GeneralTaste data) {
        Log.e("generaltaste", new Gson().toJson(data));
        tvTasteTitle.setText(data.getTaste());
        tvTasteDesp.setText(data.getTasteDesc());
    }
}
