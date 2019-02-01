package com.borysenko.listtobuy.dagger.screens;

import com.borysenko.listtobuy.dagger.DbManagerModule;
import com.borysenko.listtobuy.ui.main.purchasetab.PurchaseFragmentScreen;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 31/01/19
 * Time: 22:21
 */
@Module(includes = DbManagerModule.class)
public class PurchaseFragmentScreenModule {
    private final PurchaseFragmentScreen.View mView;

    public PurchaseFragmentScreenModule(PurchaseFragmentScreen.View mView) {
        this.mView = mView;
    }

    @Provides
    PurchaseFragmentScreen.View providesPurchaseFragmentScreenView() {
        return mView;
    }
}
