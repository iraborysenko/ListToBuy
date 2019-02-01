package com.borysenko.listtobuy.db;

import java.util.List;

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 01/02/19
 * Time: 19:18
 */
public interface DataBaseCallBack {

    void onUsersLoaded(List<Purchase> users);

}
