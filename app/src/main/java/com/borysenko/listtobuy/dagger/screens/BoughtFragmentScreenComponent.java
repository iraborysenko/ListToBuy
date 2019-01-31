package com.borysenko.listtobuy.dagger.screens;

import com.borysenko.listtobuy.ui.main.boughttab.BoughtFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 31/01/19
 * Time: 22:17
 */
@Singleton
@Component(modules = BoughtFragmentScreenModule.class)
public interface BoughtFragmentScreenComponent {
    void inject(BoughtFragment fragment);
}
