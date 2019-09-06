package com.example.loginandregistration;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SharedMainActivity extends AppCompatActivity {
    Intent login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shared_activity_main);
        final SharedPreferences sharedPreferences=getSharedPreferences("USER_CREDENTIALS",MODE_PRIVATE);
        final String name=sharedPreferences.getString("NAME","DEFAULT_NAME");
        Button logout=(Button)findViewById(R.id.logout_button);
        TextView welcometext=(TextView)findViewById(R.id.welcome_text);
        welcometext.setText("Welcome"+name);
        login=new Intent(this, SharedLoginActivity.class);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences.edit().putBoolean("ISLOGGEDIN",false).commit();
                startActivity(login);
                finish();

            }
        });

    }
}
