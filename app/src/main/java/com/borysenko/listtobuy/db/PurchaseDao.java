package com.borysenko.listtobuy.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

import io.reactivex.Single;

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 01/02/19
 * Time: 13:42
 */
@Dao
public interface PurchaseDao {

    @Query("SELECT * FROM purchase WHERE isBought = 0")
    Single<List<Purchase>> getAllPurchases();

    @Query("SELECT * FROM purchase WHERE isBought = 1")
    Single<List<Purchase>> getAllBoughts();

    @Insert
    void insert(Purchase employee);

    @Update
    void update(Purchase employee);

    @Delete
    void delete(Purchase employee);
}
