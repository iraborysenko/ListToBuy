package com.borysenko.listtobuy.ui.main.boughttab;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.borysenko.listtobuy.R;
import com.borysenko.listtobuy.dagger.screens.BoughtFragmentScreenModule;
import com.borysenko.listtobuy.dagger.screens.DaggerBoughtFragmentScreenComponent;

import javax.inject.Inject;

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 31/01/19
 * Time: 20:49
 */
public class BoughtFragment extends Fragment implements BoughtFragmentScreen.View{

    @Inject
    BoughtPresenter mPresenter;

    LinearLayoutManager linearLayoutManager;

    public BoughtFragment() {

    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerBoughtFragmentScreenComponent.builder()
                .boughtFragmentScreenModule(new BoughtFragmentScreenModule(this))
                .build().inject(this);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.bought_fragment, container, false);

        linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);

        return view;
    }

}