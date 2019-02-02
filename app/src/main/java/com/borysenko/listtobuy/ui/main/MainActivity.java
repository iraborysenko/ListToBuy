package com.borysenko.listtobuy.ui.main;

import android.annotation.SuppressLint;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

import com.borysenko.listtobuy.R;
import com.borysenko.listtobuy.ui.main.boughttab.BoughtFragment;
import com.borysenko.listtobuy.ui.main.purchasetab.PurchaseFragment;

public class MainActivity extends AppCompatActivity {

    Fragment purchaseFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ViewPager viewPager = findViewById(R.id.viewpager);
        purchaseFragment = setupViewPager(viewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            showTipMessage();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressLint("SetTextI18n")
    private void showTipMessage() {
        TextView title = new TextView(this);
        title.setText("Подсказка");
        title.setPadding(10, 15, 10, 5);
        title.setGravity(Gravity.CENTER);
        title.setTextSize(22);

        TextView message = new TextView(this);
        message.setText("Long click на любой пункт списка 'Покупки' открывает/закрывает"
                + " дополнительные кнопки\n(Перенос всего списка,\nПеренос выбранных"
                + " пунктов,\nУдаление выбранных пунктов) ");
        message.setPadding(10, 10, 10, 0);
        message.setGravity(Gravity.CENTER);
        message.setTextSize(18);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setCustomTitle(title)
                .setView(message)
                .setCancelable(false)
                .setNegativeButton("ОК",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                dialog.cancel();
                            }
                        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    public Fragment setupViewPager(ViewPager viewPager) {
        TabsViewPagerAdapter adapter = new TabsViewPagerAdapter(getSupportFragmentManager());
        Fragment purchaseFragment = new PurchaseFragment();
        adapter.addFragment(purchaseFragment, "Покупки");
        adapter.addFragment(new BoughtFragment(), "Купленное");
        adapter.notifyDataSetChanged();
        viewPager.setAdapter(adapter);
        return purchaseFragment;
    }
}
