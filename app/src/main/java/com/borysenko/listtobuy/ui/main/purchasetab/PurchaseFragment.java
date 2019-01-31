package com.borysenko.listtobuy.ui.main.purchasetab;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.borysenko.listtobuy.R;
import com.borysenko.listtobuy.dagger.screens.DaggerPurchaseFragmentScreenComponent;
import com.borysenko.listtobuy.dagger.screens.PurchaseFragmentScreenModule;
import com.borysenko.listtobuy.ui.add.AddActivity;

import javax.inject.Inject;

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

    public PurchaseFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerPurchaseFragmentScreenComponent.builder()
                .purchaseFragmentScreenModule(new PurchaseFragmentScreenModule(this))
                .build().inject(this);

    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.purchase_fragment, container, false);

        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        FloatingActionButton fab = view.findViewById(R.id.fab_add_purchase);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openAddActivity();
            }
        });

        return view;
    }

    private void openAddActivity() {
        Intent intent = new Intent(getContext(), AddActivity.class);
        startActivity(intent);
    }

}