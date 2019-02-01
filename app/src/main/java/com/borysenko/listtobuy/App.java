package com.borysenko.listtobuy;

import android.app.Application;
import android.arch.persistence.room.Room;
import android.content.Context;

import com.borysenko.listtobuy.dagger.AppComponent;
import com.borysenko.listtobuy.dagger.DaggerAppComponent;
import com.borysenko.listtobuy.db.AppDatabase;

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 31/01/19
 * Time: 21:59
 */
public class App extends Application {

    public static App instance;

    private AppDatabase database;

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        database = Room.databaseBuilder(this, AppDatabase.class, "purchaseDb")
                .build();

        AppComponent mAppComponent = DaggerAppComponent.builder()
                .build();
        mAppComponent.inject(this);
    }

    public static App getInstance() {
        return instance;
    }

    public AppDatabase getDatabase() {
        return database;
    }

}
