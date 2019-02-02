package com.borysenko.listtobuy.ui.main.purchasetab;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.borysenko.listtobuy.R;
import com.borysenko.listtobuy.db.Purchase;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Android Studio.
 * User: Iryna
 * Date: 02/02/19
 * Time: 00:11
 */
public class PurchaseRecyclerAdapter extends RecyclerView.Adapter<PurchaseRecyclerAdapter.ViewHolder> {

    private static ClickListener clickListener;
    private static List<Purchase> mPurchases;
    private Context mContext;

    static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        @BindView(R.id.purchase_photo)
        ImageView mPhoto;
        @BindView(R.id.purchase_title)
        TextView mTitle;
        @BindView(R.id.purchase_price) TextView mPrice;
        @BindView(R.id.purchase_quantity) TextView mQuantity;


        ViewHolder(View v) {
            super(v);
            v.setOnClickListener(this);
            v.setOnLongClickListener(this);
            ButterKnife.bind(this, v);
        }

        @Override
        public void onClick(View v) {
            clickListener.onItemClick(v);
        }

        @Override
        public boolean onLongClick(View v) {
            clickListener.onItemLongClick(v);
            return true;
        }
    }

    PurchaseRecyclerAdapter(List<Purchase> purchases, Context context) {
        mPurchases = purchases;
        mContext = context;
    }

    @NonNull
    @Override
    public PurchaseRecyclerAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent,
                                                                 int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.purchase_recycler_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder movieViewHolder, int i) {

        Purchase purchase = mPurchases.get(i);
        assert purchase != null;

        RequestOptions options = new RequestOptions()
                .skipMemoryCache(false)
                .diskCacheStrategy(DiskCacheStrategy.ALL);
        Glide.with(mContext)
                .asBitmap()
                .load(Purchase.stringToBitmap(purchase.getPhotoBitmap()))
                .apply(options)
                .into(movieViewHolder.mPhoto);

        movieViewHolder.mTitle.setText(purchase.getTitle());
        movieViewHolder.mPrice.setText(String.format("Цена: %s", purchase.getPrice()));
        movieViewHolder.mQuantity.setText(String.format("Количество: %s", purchase.getQuantity()));
        movieViewHolder.itemView.setBackgroundColor(mContext.getResources()
                .getColor(R.color.colorLightGrey));

    }

    @Override
    public int getItemCount() {
        return mPurchases.size();
    }

    void setOnItemClickListener(ClickListener clickListener) {
        PurchaseRecyclerAdapter.clickListener = clickListener;
    }

    public interface ClickListener {
        void onItemClick(View v);
        void onItemLongClick(View v);
    }


}
