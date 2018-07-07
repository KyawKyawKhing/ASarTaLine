package com.aceplus.asartaline.activity;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.aceplus.asartaline.R;
import com.aceplus.asartaline.adapter.GeneralTasteAdapter;
import com.aceplus.asartaline.adapter.ShopByDistanceAdapter;
import com.aceplus.asartaline.adapter.ShopByPopularityAdapter;
import com.aceplus.asartaline.adapter.SuitedForAdapter;
import com.aceplus.asartaline.adapter.WarDeeListAdapter;
import com.aceplus.asartaline.data.vo.AstlWarDee;
import com.aceplus.asartaline.delegate.DetailWarDeeDelegate;
import com.aceplus.asartaline.delegate.HomeDelegate;
import com.aceplus.asartaline.mvp.presenter.DetailPresenter;
import com.aceplus.asartaline.mvp.view.DetailView;
import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WarDeeDetailActivity extends AppCompatActivity implements DetailView, DetailWarDeeDelegate, HomeDelegate {

    public static String IE_ID = "id";

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    @BindView(R.id.iv_wardee_detail)
    ImageView ivWarDeeDetail;
    @BindView(R.id.tv_minprice)
    TextView tvMinPrice;
    @BindView(R.id.tv_maxprice)
    TextView tvMaxPrice;
    @BindView(R.id.rv_general_taste)
    RecyclerView rvGeneralTaste;
    @BindView(R.id.rv_suited_for)
    RecyclerView rvSuitedFor;
    @BindView(R.id.rv_matchWarDee)
    RecyclerView rvMatchWarDee;
    @BindView(R.id.rv_sbd)
    RecyclerView rvSBD;
    @BindView(R.id.rv_sbp)
    RecyclerView rvSBP;

    @BindView(R.id.rl_taste_label)
    RelativeLayout rlTaste;
    @BindView(R.id.rl_suitedFor_label)
    RelativeLayout rlSuitedFor;
    @BindView(R.id.rl_sbd_label)
    RelativeLayout rlSBD;
    @BindView(R.id.rl_sbp_label)
    RelativeLayout rlSBP;
    @BindView(R.id.rl_matchWarDee_label)
    RelativeLayout rlMatchWarDee;


    GeneralTasteAdapter mTasteAdapter;
    SuitedForAdapter mSuitedForAdapter;
    WarDeeListAdapter mMatchWarDeeListAdapter;
    ShopByDistanceAdapter mShopByDistanceAdapter;
    ShopByPopularityAdapter mShopByPopularityAdapter;

    private DetailPresenter mPresenter;


    public static Intent newIntent(Context context, String id) {
        Intent intent = new Intent(context, WarDeeDetailActivity.class);
        intent.putExtra(IE_ID, id);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_war_dee_detail);
        ButterKnife.bind(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String id = getIntent().getStringExtra(IE_ID);
//        AstlModel astlModel = AstlModel.getInstance(getApplicationContext());
////        AstlWarDee astlWarDee = astlModel.getWarDeeById(id);
//
//        Gson gson = new Gson();
////        Log.e("wardee", gson.toJson(astlWarDee));
//        Log.e("taste", gson.toJson(astlModel.getGeneralTasteListByWarDeeId(id)));
//        Log.e("suitedfor", gson.toJson(astlModel.getSuitedForListByWarDeeId(id)));
//        Log.e("distance", gson.toJson(astlModel.getShopByDistanceListByWarDeeId(id)));
//        Log.e("popularity", gson.toJson(astlModel.getShopByPopularityListByWarDeeId(id)));
//        String shopId = astlModel.getShopByDistanceListByWarDeeId(id).get(0).getMealShop().getMealShopId();
//        Log.e("shop", gson.toJson(astlModel.getShopListById(shopId)));
//        Log.e("review", gson.toJson(astlModel.getReviewListByShopId(shopId)));

        initUI();
        mPresenter = ViewModelProviders.of(this).get(DetailPresenter.class);
        mPresenter.initPresenter(this);
        mPresenter.getWarDeeLDDetailById(id).observe(this, new Observer<AstlWarDee>() {
            @Override
            public void onChanged(@Nullable AstlWarDee astlWarDee) {
                setData(astlWarDee);
            }
        });

    }

    private void initUI() {
        mTasteAdapter = new GeneralTasteAdapter(this);
        mSuitedForAdapter = new SuitedForAdapter(this);
        mMatchWarDeeListAdapter = new WarDeeListAdapter(this, this);
        mShopByDistanceAdapter = new ShopByDistanceAdapter(this);
        mShopByPopularityAdapter = new ShopByPopularityAdapter(this);

        rvGeneralTaste.setAdapter(mTasteAdapter);
        rvGeneralTaste.setLayoutManager(new LinearLayoutManager(this));
        rvSuitedFor.setAdapter(mSuitedForAdapter);
        rvSuitedFor.setLayoutManager(new LinearLayoutManager(this));
        rvMatchWarDee.setAdapter(mMatchWarDeeListAdapter);
        rvMatchWarDee.setLayoutManager(new LinearLayoutManager(this));
        rvSBD.setAdapter(mShopByDistanceAdapter);
        rvSBD.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        rvSBP.setAdapter(mShopByPopularityAdapter);
        rvSBP.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));

    }

    private void setData(AstlWarDee astlWarDee) {
        getSupportActionBar().setTitle(astlWarDee.getName());
        Glide.with(this)
                .load(astlWarDee.getImages().get(0))
                .into(ivWarDeeDetail);
        tvMinPrice.setText(String.valueOf(astlWarDee.getPriceRangeMin()));
        tvMaxPrice.setText(String.valueOf(astlWarDee.getPriceRangeMax()));

        if (astlWarDee.getGeneralTaste().size() == 0) {
            rlTaste.setVisibility(View.GONE);
        } else
            mTasteAdapter.setNewList(astlWarDee.getGeneralTaste());

        if (astlWarDee.getSuitedFor().size() == 0) {
            rlSuitedFor.setVisibility(View.GONE);
        } else {
            mSuitedForAdapter.setNewList(astlWarDee.getSuitedFor());
        }
        if (astlWarDee.getMatchWarDeeList().size() == 0) {
            rlMatchWarDee.setVisibility(View.GONE);
        } else
            mMatchWarDeeListAdapter.setNewList(astlWarDee.getMatchWarDee());

        if (astlWarDee.getShopByDistance().size() == 0) {
            rlSBD.setVisibility(View.GONE);
        } else
            mShopByDistanceAdapter.setNewList(astlWarDee.getShopByDistance());

        if (astlWarDee.getShopByPopularity().size() == 0) {
            rlSBP.setVisibility(View.GONE);
        } else
            mShopByPopularityAdapter.setNewList(astlWarDee.getShopByPopularity());
    }


    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void onTapItemList(String id) {

    }
}
