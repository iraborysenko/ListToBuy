package com.borysenko.listtobuy.ui.main.purchasetab;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.borysenko.listtobuy.R;
import com.borysenko.listtobuy.dagger.screens.DaggerPurchaseFragmentScreenComponent;
import com.borysenko.listtobuy.dagger.screens.PurchaseFragmentScreenModule;
import com.borysenko.listtobuy.db.Purchase;
import com.borysenko.listtobuy.ui.add.AddActivity;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 31/01/19
 * Time: 20:49
 */
public class PurchaseFragment extends Fragment implements PurchaseFragmentScreen.View {

    @Inject
    PurchasePresenter mPresenter;

    LinearLayoutManager linearLayoutManager;
    List<Purchase> purchasesToDelete = new ArrayList<>();
    List<Purchase> listOfPurchases;

    @BindView(R.id.purchase_recycler)
    RecyclerView mRecyclerView;

    @BindView(R.id.fab_add_purchase)
    FloatingActionButton fabAdd;
    @BindView(R.id.fab_move_purchase)
    FloatingActionButton fabMove;
    @BindView(R.id.fab_move_all_purchases)
    FloatingActionButton fabMoveAll;
    @BindView(R.id.fab_to_trash)
    FloatingActionButton fabToTrash;

    public PurchaseFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerPurchaseFragmentScreenComponent.builder()
                .purchaseFragmentScreenModule(new PurchaseFragmentScreenModule(this))
                .build().inject(this);
        mPresenter.loadPurchasesFromDb();
    }

    @Override
    public void onResume() {
        super.onResume();
        mPresenter.loadPurchasesFromDb();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.purchase_fragment, container, false);
        ButterKnife.bind(this, view);

        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        fabAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddActivity();
            }
        });

        fabMove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.moveSomePurchases(listOfPurchases);
                mPresenter.loadPurchasesFromDb();
            }
        });

        fabMoveAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPresenter.moveAllPurchases();
                mPresenter.loadPurchasesFromDb();
            }
        });

        fabToTrash.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                purchasesToDelete.clear();
                for (Purchase purchase:listOfPurchases ) {
                    if (purchase.getSelected()) {
                        purchasesToDelete.add(purchase);
                    }
                }
                mPresenter.deleteSomePurchases(purchasesToDelete);
                mPresenter.loadPurchasesFromDb();
            }
        });
        return view;
    }

    private void openAddActivity() {
        Intent intent = new Intent(getContext(), AddActivity.class);
        startActivity(intent);
    }

    @Override
    public void displayData(List<Purchase> purchases) {
        mPresenter.displayPurchasesOnRecyclerView(purchases);
    }

    @Override
    public PurchaseRecyclerAdapter initRecyclerView(List<Purchase> purchases) {
        listOfPurchases = purchases;
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        final PurchaseRecyclerAdapter mAdapter = new PurchaseRecyclerAdapter(listOfPurchases ,
                getContext(), fabMove, fabMoveAll, fabToTrash);
        mRecyclerView.setAdapter(mAdapter);
        return mAdapter;
    }
}