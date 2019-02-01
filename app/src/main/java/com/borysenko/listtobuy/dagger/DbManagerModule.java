package com.borysenko.listtobuy.dagger;

import com.borysenko.listtobuy.db.DbManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 01/02/19
 * Time: 18:46
 */
@Module
public class DbManagerModule {

    @Provides
    @Singleton
    DbManager provideDbManager() {return new DbManager();}

}
