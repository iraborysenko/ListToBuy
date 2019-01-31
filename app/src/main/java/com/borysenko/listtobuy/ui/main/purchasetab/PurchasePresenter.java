package com.borysenko.listtobuy.ui.main.purchasetab;

import javax.inject.Inject;

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 31/01/19
 * Time: 22:04
 */
public class PurchasePresenter implements PurchaseFragmentScreen.Presenter {

    private PurchaseFragmentScreen.View mView;

    @Inject
    PurchasePresenter(PurchaseFragmentScreen.View mView) {
        this.mView = mView;
    }

}

