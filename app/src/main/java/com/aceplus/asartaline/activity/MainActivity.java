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

import com.aceplus.asartaline.R;
import com.aceplus.asartaline.adapter.WarDeeListAdapter;
import com.aceplus.asartaline.data.vo.AstlWarDee;
import com.aceplus.asartaline.delegate.HomeDelegate;
import com.aceplus.asartaline.mvp.presenter.HomePresenter;
import com.aceplus.asartaline.mvp.view.HomeView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements HomeView, HomeDelegate {
    @BindView(R.id.rv_wardee)
    RecyclerView rvWarDee;
    WarDeeListAdapter mAdapter;
    HomePresenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mAdapter = new WarDeeListAdapter(getApplicationContext(),this);
        rvWarDee.setAdapter(mAdapter);
        rvWarDee.setLayoutManager(new LinearLayoutManager(this));
        mPresenter = ViewModelProviders.of(this).get(HomePresenter.class);
        mPresenter.initPresenter(this);
        mPresenter.getAllWarDeeLD().observe(this, new Observer<List<AstlWarDee>>() {
            @Override
            public void onChanged(@Nullable List<AstlWarDee> warDeeList) {
                mAdapter.setNewList(warDeeList);
            }
        });
    }

    @Override
    public Context getContext() {
        return getApplicationContext();
    }

    @Override
    public void onTapItemList(String id) {
        Intent intent = WarDeeDetailActivity.newIntent(getApplicationContext(), id);
        startActivity(intent);
    }
}
