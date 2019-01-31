package com.borysenko.listtobuy;

import android.app.Application;
import android.content.Context;

import com.borysenko.listtobuy.dagger.AppComponent;
import com.borysenko.listtobuy.dagger.DaggerAppComponent;

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 31/01/19
 * Time: 21:59
 */
public class App extends Application {

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();

        AppComponent mAppComponent = DaggerAppComponent.builder()
                .build();
        mAppComponent.inject(this);
    }

}