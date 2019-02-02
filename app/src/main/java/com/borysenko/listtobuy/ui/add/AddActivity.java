package com.borysenko.listtobuy.ui.add;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.borysenko.listtobuy.R;
import com.borysenko.listtobuy.dagger.screens.AddScreenModule;
import com.borysenko.listtobuy.dagger.screens.DaggerAddScreenComponent;
import com.borysenko.listtobuy.db.Purchase;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 31/01/19
 * Time: 21:26
 */
public class AddActivity extends AppCompatActivity implements AddScreen.View{

    @Inject
    AddPresenter addPresenter;

    static final int REQUEST_IMAGE_CAPTURE = 1;

    Bitmap imageBitmap = null;

    @BindView(R.id.enter_title)
    EditText mTitle;
    @BindView(R.id.enter_price)
    EditText mPrice;
    @BindView(R.id.enter_quantity)
    EditText mQuantity;
    @BindView(R.id.your_image)
    ImageButton mPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ButterKnife.bind(this);

        DaggerAddScreenComponent.builder()
                .addScreenModule(new AddScreenModule(this))
                .build().inject(this);

        FloatingActionButton fab = findViewById(R.id.fab_commit_purchase);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addPresenter.addPurchaseToDb(collectData());
                finish();
            }
        });

    }

    private Purchase collectData() {
        String price = mPrice.getText().toString();
        String quantity = mQuantity.getText().toString();
        String title = mTitle.getText().toString();
        return new Purchase(title,price,quantity,Purchase.bitmapToString(imageBitmap));
    }

    @OnClick(R.id.your_image)
    void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            assert extras != null;
            imageBitmap = (Bitmap) extras.get("data");
            assert imageBitmap != null;
            mPhoto.setImageBitmap(Bitmap.createScaledBitmap(imageBitmap, 300, 360, false));
        }
    }
}
