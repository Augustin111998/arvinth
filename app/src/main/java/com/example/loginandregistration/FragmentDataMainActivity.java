package com.example.loginandregistration;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;


public class FragmentDataMainActivity extends AppCompatActivity implements FragmentDataOne.SendMessage{

    TabLayout tabLayout;
    ViewPager viewPager;
    ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragmentdata_main_activity);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar1);
        setSupportActionBar(toolbar);

        viewPager = (ViewPager) findViewById(R.id.viewPager1);
        viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }

    @Override
    public void sendData(String message) {
        String tag = "android:switcher:" + R.id.viewPager1 + ":" + 1;
        FragmentDataTwo f = (FragmentDataTwo) getSupportFragmentManager().findFragmentByTag(tag);
        f.displayReceivedData(message);
    }
}
