package com.borysenko.listtobuy.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Base64;

import java.io.ByteArrayOutputStream;

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 01/02/19
 * Time: 13:27
 */
@Entity
public class Purchase {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private String title;
    private String price;
    private String quantity;
    private String photoBitmap;
    private Boolean isBought;
    private Boolean isSelected;

    public Purchase(String title, String price, String quantity, String photoBitmap) {
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.photoBitmap = photoBitmap;
        this.isBought = false;
        this.isSelected = false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getPhotoBitmap() {
        return photoBitmap;
    }

    public void setPhotoBitmap(String photoBitmap) {
        this.photoBitmap = photoBitmap;
    }

    public Boolean getSelected() {
        return isSelected;
    }

    public void setSelected(Boolean selected) {
        isSelected = selected;
    }

    public Boolean getBought() {
        return isBought;
    }

    public void setBought(Boolean bought) {
        isBought = bought;
    }

    public static String bitmapToString(Bitmap in){
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        in.compress(Bitmap.CompressFormat.PNG, 100, bytes);
        return Base64.encodeToString(bytes.toByteArray(),Base64.DEFAULT);
    }

    public static Bitmap stringToBitmap(String in){
        byte[] bytes = Base64.decode(in, Base64.DEFAULT);
        return BitmapFactory.decodeByteArray(bytes, 0, bytes.length);
    }
}
