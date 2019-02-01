package com.borysenko.listtobuy.ui.add;

import com.borysenko.listtobuy.db.Purchase;

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 31/01/19
 * Time: 23:01
 */
public interface AddScreen {
    interface View {

    }

    interface Presenter {

        void addPurchaseToDb(Purchase purchase);
    }
}
