package com.borysenko.listtobuy.dagger.screens;

import com.borysenko.listtobuy.ui.add.AddActivity;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 31/01/19
 * Time: 23:02
 */
@Singleton
@Component(modules = AddScreenModule.class)
public interface AddScreenComponent {
    void inject(AddActivity mainActivity);
}
