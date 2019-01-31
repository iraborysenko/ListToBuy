package com.borysenko.listtobuy.ui.add;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.borysenko.listtobuy.R;
import com.borysenko.listtobuy.dagger.screens.AddScreenModule;
import com.borysenko.listtobuy.dagger.screens.DaggerAddScreenComponent;

import javax.inject.Inject;

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 31/01/19
 * Time: 21:26
 */
public class AddActivity extends AppCompatActivity implements AddScreen.View{

    @Inject
    AddPresenter addPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        DaggerAddScreenComponent.builder()
                .addScreenModule(new AddScreenModule(this))
                .build().inject(this);

        FloatingActionButton fab = findViewById(R.id.fab_commit_purchase);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
