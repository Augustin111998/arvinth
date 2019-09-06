package com.example.loginandregistration;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class FragmentMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_fragment);
        if( savedInstanceState == null ) {
            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container, MyFragment.getInstance(), MyFragment.TAG).commit();
        }
    }
}