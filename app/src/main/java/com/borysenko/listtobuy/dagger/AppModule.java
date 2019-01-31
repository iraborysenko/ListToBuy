package com.borysenko.listtobuy.dagger;

import android.app.Application;

import com.borysenko.listtobuy.App;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 31/01/19
 * Time: 22:02
 */
@Module
public class AppModule {

    private final App mApp;

    public AppModule(App mApp) {
        this.mApp = mApp;
    }

    @Provides
    @Singleton
    public App app() {
        return mApp;
    }

    @Provides
    Application provideApplication() {
        return mApp;
    }
}
