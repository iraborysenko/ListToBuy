package com.borysenko.listtobuy.ui.main.boughttab;

import javax.inject.Inject;

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 31/01/19
 * Time: 22:10
 */
public class BoughtPresenter implements BoughtFragmentScreen.Presenter{
    private BoughtFragmentScreen.View mView;

    @Inject
    BoughtPresenter(BoughtFragmentScreen.View mView) {
        this.mView = mView;
    }

}
