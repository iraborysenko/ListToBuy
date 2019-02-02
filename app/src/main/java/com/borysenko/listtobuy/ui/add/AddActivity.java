package com.borysenko.listtobuy.ui.add;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.borysenko.listtobuy.R;
import com.borysenko.listtobuy.dagger.screens.AddScreenModule;
import com.borysenko.listtobuy.dagger.screens.DaggerAddScreenComponent;
import com.borysenko.listtobuy.db.Purchase;

import java.io.IOException;
import java.util.Objects;

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

    static final int GALLERY = 0;
    static final int CAMERA = 1;

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
        String price = "";
        if (mPrice.getText()!=null) {
            price = mPrice.getText().toString();
        }

        String quantity = "";
        if (mQuantity.getText()!=null) {
            quantity = mQuantity.getText().toString();
        }
        String title = "";
        if (mTitle.getText()!=null) {
            title = mTitle.getText().toString();
        }

        String pictureBitmap="";
        if (imageBitmap!=null) {
            pictureBitmap = Purchase.bitmapToString(imageBitmap);
        }
        return new Purchase(title,price,quantity,pictureBitmap);
    }

    @OnClick(R.id.your_image)
    void showPictureDialog(){
        AlertDialog.Builder pictureDialog = new AlertDialog.Builder(this);
        pictureDialog.setTitle("Выберите действие");
        String[] pictureDialogItems = {
                "GALLERY",
                "CAMERA" };
        pictureDialog.setItems(pictureDialogItems,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        switch (which) {
                            case 0:
                                choosePhotoFromGallery();
                                break;
                            case 1:
                                takePhotoFromCamera();
                                break;
                        }
                    }
                });
        pictureDialog.show();
    }

    private void choosePhotoFromGallery() {
        Intent galleryIntent = new Intent(Intent.ACTION_PICK,
                android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        if (galleryIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(galleryIntent, GALLERY);
        }
    }

    private void takePhotoFromCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, CAMERA);
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_CANCELED) {
            return;
        }
        if (requestCode == GALLERY) {
            if (data != null) {
                Uri contentURI = data.getData();
                try {
                    imageBitmap = MediaStore.Images.Media.getBitmap(this.getContentResolver(), contentURI);
                    mPhoto.setImageBitmap(Bitmap.createScaledBitmap(imageBitmap, 300, 360, false));

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

        } else if (requestCode == CAMERA) {
            imageBitmap = (Bitmap) Objects.requireNonNull(data.getExtras()).get("data");
            assert imageBitmap != null;
            mPhoto.setImageBitmap(Bitmap.createScaledBitmap(imageBitmap, 300, 360, false));
        }
    }
}
