package com.borysenko.listtobuy.dagger;

import com.borysenko.listtobuy.App;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 31/01/19
 * Time: 22:02
 */
@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    void inject(App app);
}
