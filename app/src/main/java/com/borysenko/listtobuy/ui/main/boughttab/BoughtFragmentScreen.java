package com.borysenko.listtobuy.ui.main.boughttab;

import com.borysenko.listtobuy.db.Purchase;

import java.util.List;

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 31/01/19
 * Time: 22:10
 */
public interface BoughtFragmentScreen {
    interface View {

        void displayData(List<Purchase> boughts);

        BoughtRecyclerAdapter initRecyclerView(List<Purchase> purchases);
    }

    interface Presenter {

        void loadBoughtsFromDb();
    }
}
