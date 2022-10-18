package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class Profile extends AppCompatActivity {
    ImageView imgback,imglogout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        BottomNavigationView btnav = findViewById(R.id.btnavigation1);
        btnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:{
                        Intent intent = new Intent(Profile.this,MainActivity.class);
                        startActivity(intent);}
                    break;
                    case R.id.nav_profile: {
                        Intent intent = new Intent(Profile.this, Profile.class);
                        startActivity(intent);
                    }
                    break;
                    case R.id.nav_list:{
                        Intent intent = new Intent(Profile.this,DSKhachSan.class);
                        startActivity(intent);
                    }
                    break;

                }
                return true;
            }
        });
        imglogout = (ImageView) findViewById(R.id.imgout);
        imglogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Profile.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }
}