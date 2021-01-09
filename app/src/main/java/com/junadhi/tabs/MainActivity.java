package com.junadhi.tabs;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.os.Handler;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tabLayout = findViewById(R.id.tab_layout);
        viewPager = findViewById(R.id.view_pager);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getTabs();
    }

    public void getTabs(){
        final ViewPagerAdapter viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        new Handler().post(new Runnable() {
            @Override
            public void run() {
                viewPagerAdapter.addFragment(ExploreFragment.getInstance(), "Explore");
                viewPagerAdapter.addFragment(FlightFragment.getInstance(), "Flight");
                viewPagerAdapter.addFragment(TripFragment.getInstance(), "Trip");

                viewPager.setAdapter(viewPagerAdapter);
                tabLayout.setupWithViewPager(viewPager);

                tabLayout.getTabAt(0).setIcon(R.drawable.ic_baseline_explore_24);
                tabLayout.getTabAt(1).setIcon(R.drawable.ic_baseline_flight_24);
                tabLayout.getTabAt(2).setIcon(R.drawable.ic_baseline_card_travel_24);

                BadgeDrawable badgeDrawable = tabLayout.getTabAt(0).getOrCreateBadge();
                badgeDrawable.setVisible(true);
                badgeDrawable.setNumber(10);
            }
        });

        }
    }
