package com.borysenko.listtobuy.db;

import com.borysenko.listtobuy.App;

import java.util.List;

import io.reactivex.Completable;
import io.reactivex.CompletableObserver;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
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

        Single<List<Purchase>> single = db.purchaseDao().getAllPurchases();
        single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Purchase>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(List<Purchase> purchases) {
                        databaseCallback.onUsersLoaded(purchases);
                    }
                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void getAllBoughts(final DataBaseCallBack databaseCallback) {

        Single<List<Purchase>> single = db.purchaseDao().getAllBoughts();
        single.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new SingleObserver<List<Purchase>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onSuccess(List<Purchase> boughts) {
                        databaseCallback.onUsersLoaded(boughts);
                    }
                    @Override
                    public void onError(Throwable e) {

                    }
                });
    }

    public void insertPurchase(final Purchase purchase) {

        Completable.fromAction(new Action() {
            @Override
            public void run() {
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
