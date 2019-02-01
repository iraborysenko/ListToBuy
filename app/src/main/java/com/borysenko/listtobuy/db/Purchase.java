package com.borysenko.listtobuy.db;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

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

    public Purchase(String title, String price, String quantity, String photoBitmap, Boolean isBought) {
        this.title = title;
        this.price = price;
        this.quantity = quantity;
        this.photoBitmap = photoBitmap;
        this.isBought = isBought;
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

    public Boolean getBought() {
        return isBought;
    }

    public void setBought(Boolean bought) {
        isBought = bought;
    }
}
