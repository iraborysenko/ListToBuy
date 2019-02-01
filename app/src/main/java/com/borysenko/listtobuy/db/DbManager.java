package com.borysenko.listtobuy.db;


import android.support.annotation.NonNull;
import android.util.Log;

import com.borysenko.listtobuy.App;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 01/02/19
 * Time: 18:20
 */
public class DbManager {

    private AppDatabase db = App.getInstance().getDatabase();
    private PurchaseDao purchaseDao = db.purchaseDao();

    public void getAllPurchases(final DataBaseCallBack databaseCallback) {

        final Disposable db = this.db.purchaseDao().getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Purchase>>() {
                    @Override
                    public void accept(@NonNull List<Purchase> purchases) throws Exception {
                        databaseCallback.onUsersLoaded(purchases);
                    }
                });
    }

    public void insertPurchase(final Purchase purchase) {

        Completable.fromAction(new Action() {
            @Override
            public void run() throws Exception {
                purchaseDao.insert(purchase);
            }
        }).observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io()).subscribe(new CompletableObserver() {
            @Override
            public void onSubscribe(Disposable d) {
            }

            @Override
            public void onComplete() {
            }

            @Override
            public void onError(Throwable e) {
            }
        });
    }


}
