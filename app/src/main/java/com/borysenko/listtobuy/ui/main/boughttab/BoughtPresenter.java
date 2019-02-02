package com.borysenko.listtobuy.ui.main.boughttab;

import android.view.View;

import com.borysenko.listtobuy.db.DataBaseCallBack;
import com.borysenko.listtobuy.db.DbManager;
import com.borysenko.listtobuy.db.Purchase;

import java.util.List;

import javax.inject.Inject;

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 31/01/19
 * Time: 22:10
 */
public class BoughtPresenter implements BoughtFragmentScreen.Presenter, DataBaseCallBack {
    private BoughtFragmentScreen.View mView;

    @Inject
    DbManager dbManager;

    @Inject
    BoughtPresenter(BoughtFragmentScreen.View mView) {
        this.mView = mView;
    }

    @Override
    public void loadBoughtsFromDb() {
        dbManager.getAllBoughts(this);
    }

    @Override
    public void onUsersLoaded(List<Purchase> boughts) {
        mView.displayData(boughts);
    }

    void displayBoughtsOnRecyclerView(List<Purchase> boughts) {

        BoughtRecyclerAdapter mAdapter = mView.initRecyclerView(boughts);

        mAdapter.setOnItemClickListener(new BoughtRecyclerAdapter.ClickListener() {
            @Override
            public void onItemClick(View v) {

            }

            @Override
            public void onItemLongClick(View v) {

            }
        });
    }
}
