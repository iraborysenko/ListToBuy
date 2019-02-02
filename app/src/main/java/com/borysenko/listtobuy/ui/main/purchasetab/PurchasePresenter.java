package com.borysenko.listtobuy.ui.main.purchasetab;

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
 * Time: 22:04
 */
public class PurchasePresenter implements PurchaseFragmentScreen.Presenter, DataBaseCallBack {

    private PurchaseFragmentScreen.View mView;

    @Inject
    DbManager dbManager;

    @Inject
    PurchasePresenter(PurchaseFragmentScreen.View mView) {
        this.mView = mView;
    }

    @Override
    public void loadPurchasesFromDb() {

        dbManager.getAllPurchases(this);
    }

    @Override
    public void onUsersLoaded(List<Purchase> purchases) {
        mView.displayData(purchases);
    }

    void displayPurchasesOnRecyclerView(List<Purchase> purchases) {

        PurchaseRecyclerAdapter mAdapter = mView.initRecyclerView(purchases);

        mAdapter.setOnItemClickListener(new PurchaseRecyclerAdapter.ClickListener() {
            @Override
            public void onItemClick(View v) {

            }

            @Override
            public void onItemLongClick(View v) {

            }
        });
    }

    @Override
    public void moveAllPurchases() {
        dbManager.updateAllPurchases();
    }

    @Override
    public void moveSomePurchases(List<Purchase> listOfPurchases) {
        dbManager.updateSomePurchases(listOfPurchases);
    }

    @Override
    public void deleteSomePurchases(List<Purchase> purchasesToDelete) {
        dbManager.deleteSomePurchases(purchasesToDelete);
    }
}
