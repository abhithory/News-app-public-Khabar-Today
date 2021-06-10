package com.sanapps.publickhabartoday;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    Toolbar pkt_appbar;
    TabLayout pkt_tabs;
    ViewPager2 pkt_viewpager;
    pagerAdapter pkt_pagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pkt_appbar = findViewById(R.id.pkt_appbar);

        // add navigation bar
        setSupportActionBar(pkt_appbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);


        pkt_tabs = findViewById(R.id.pkt_tabs);
        pkt_viewpager = findViewById(R.id.pkt_viewpager);



        pkt_pagerAdapter = new pagerAdapter(getSupportFragmentManager(),getLifecycle());

        pkt_viewpager.setAdapter(pkt_pagerAdapter);

        pkt_tabs.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pkt_viewpager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        pkt_viewpager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                pkt_tabs.selectTab(pkt_tabs.getTabAt(position));
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id==R.id.profile){

            //Toast.makeText(this, "Profile", Toast.LENGTH_SHORT).show();
        }

        return true;
    }
}