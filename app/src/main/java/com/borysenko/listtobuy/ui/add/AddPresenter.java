package com.borysenko.listtobuy.ui.add;

import com.borysenko.listtobuy.db.DbManager;
import com.borysenko.listtobuy.db.Purchase;

import javax.inject.Inject;

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 31/01/19
 * Time: 23:00
 */
public class AddPresenter implements AddScreen.Presenter {
    private AddScreen.View mView;

    @Inject
    DbManager dbManager;

    @Inject
    AddPresenter(AddScreen.View mView) {
        this.mView = mView;
    }

    @Override
    public void addPurchaseToDb(Purchase purchase) {
        dbManager.insertPurchase(purchase);
    }
}
