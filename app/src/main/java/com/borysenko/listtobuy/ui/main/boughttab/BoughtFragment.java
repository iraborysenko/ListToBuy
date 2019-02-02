package com.borysenko.listtobuy.ui.main.boughttab;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.borysenko.listtobuy.R;
import com.borysenko.listtobuy.dagger.screens.BoughtFragmentScreenModule;
import com.borysenko.listtobuy.dagger.screens.DaggerBoughtFragmentScreenComponent;
import com.borysenko.listtobuy.db.Purchase;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 31/01/19
 * Time: 20:49
 */
public class BoughtFragment extends Fragment implements BoughtFragmentScreen.View{

    @Inject
    BoughtPresenter mPresenter;

    LinearLayoutManager linearLayoutManager;

    @BindView(R.id.bought_recycler)
    RecyclerView mRecyclerView;

    public BoughtFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerBoughtFragmentScreenComponent.builder()
                .boughtFragmentScreenModule(new BoughtFragmentScreenModule(this))
                .build().inject(this);
        mPresenter.loadBoughtsFromDb();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.loadBoughtsFromDb();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.bought_fragment, container, false);
        ButterKnife.bind(this, view);
        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        return view;
    }

    @Override
    public void displayData(List<Purchase> boughts) {
        mPresenter.displayBoughtsOnRecyclerView(boughts);
    }

    @Override
    public BoughtRecyclerAdapter initRecyclerView(List<Purchase> boughts) {
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        final BoughtRecyclerAdapter mAdapter = new BoughtRecyclerAdapter(boughts, getContext());
        mRecyclerView.setAdapter(mAdapter);
        return mAdapter;
    }
}