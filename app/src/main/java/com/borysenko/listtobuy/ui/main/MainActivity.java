package com.borysenko.listtobuy.ui.main;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

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
            return true;
        }

        return super.onOptionsItemSelected(item);
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
