package com.borysenko.listtobuy.dagger.screens;

import com.borysenko.listtobuy.dagger.DbManagerModule;
import com.borysenko.listtobuy.ui.add.AddScreen;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 31/01/19
 * Time: 23:03
 */
@Module(includes = DbManagerModule.class)
public class AddScreenModule {
    private final AddScreen.View mView;

    public AddScreenModule(AddScreen.View mView) {
        this.mView = mView;
    }

    @Provides
    AddScreen.View providesAddScreenView() {
        return mView;
    }
}
