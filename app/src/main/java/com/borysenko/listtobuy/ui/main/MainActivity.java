package com.borysenko.listtobuy.ui.main;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
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


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

//        Toolbar toolbar = findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);

        ViewPager viewPager = findViewById(R.id.viewpager);
        purchaseFragment = setupViewPager(viewPager);

        TabLayout tabLayout = findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
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
