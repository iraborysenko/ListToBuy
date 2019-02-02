package com.borysenko.listtobuy.ui.main.purchasetab;

import com.borysenko.listtobuy.db.Purchase;

import java.util.List;

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 31/01/19
 * Time: 22:06
 */
public interface PurchaseFragmentScreen {
    interface View {

        void displayData(List<Purchase> purchases);

        PurchaseRecyclerAdapter initRecyclerView(List<Purchase> movies);
    }

    interface Presenter {

        void loadPurchasesFromDb();

        void moveAllPurchases();

        void moveSomePurchases(List<Purchase> listOfPurchases);

        void deleteSomePurchases(List<Purchase> listOfPurchases);
    }
}
