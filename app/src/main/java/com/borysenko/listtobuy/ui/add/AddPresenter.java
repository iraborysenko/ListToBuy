package com.borysenko.listtobuy.ui.add;

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
    AddPresenter(AddScreen.View mView) {
        this.mView = mView;
    }

}
