package com.borysenko.listtobuy.ui.main.purchasetab;

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
}

