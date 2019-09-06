package com.example.loginandregistration;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;

import androidx.appcompat.app.AppCompatActivity;

public class GridMainActivity extends AppCompatActivity {
    GridView simpleGrid;
    int logos[] = {R.drawable.logo1, R.drawable.logo2, R.drawable.logo3, R.drawable.logo4,
            R.drawable.logo5, R.drawable.logo6, R.drawable.logo7, R.drawable.logo8, R.drawable.logo9,
            R.drawable.logo10, R.drawable.logo11, R.drawable.logo12, R.drawable.logo13};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gridmain);

        simpleGrid = (GridView) findViewById(R.id.simpleGridView);
        GridCustomAdapter customAdapter = new GridCustomAdapter(getApplicationContext(), logos);
        simpleGrid.setAdapter(customAdapter);
        simpleGrid.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(GridMainActivity.this, GridSecondActivity.class);
                intent.putExtra("image", logos[position]);
                startActivity(intent);
            }
        });
    }
}



