package com.borysenko.listtobuy.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 01/02/19
 * Time: 13:45
 */
@Database(entities = {Purchase.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PurchaseDao purchaseDao();
}
