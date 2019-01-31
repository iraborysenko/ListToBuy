package com.borysenko.listtobuy.dagger.screens;

import com.borysenko.listtobuy.ui.main.purchasetab.PurchaseFragment;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 31/01/19
 * Time: 22:16
 */
@Singleton
@Component(modules = PurchaseFragmentScreenModule.class)
public interface PurchaseFragmentScreenComponent {
    void inject(PurchaseFragment fragment);
}