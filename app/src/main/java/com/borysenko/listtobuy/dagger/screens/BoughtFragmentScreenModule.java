package com.borysenko.listtobuy.dagger.screens;

import com.borysenko.listtobuy.dagger.DbManagerModule;
import com.borysenko.listtobuy.ui.main.boughttab.BoughtFragmentScreen;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 31/01/19
 * Time: 22:20
 */
@Module(includes = DbManagerModule.class)
public class BoughtFragmentScreenModule {
    private final BoughtFragmentScreen.View mView;

    public BoughtFragmentScreenModule(BoughtFragmentScreen.View mView) {
        this.mView = mView;
    }

    @Provides
    BoughtFragmentScreen.View providesBoughtFragmentScreenView() {
        return mView;
    }
}
