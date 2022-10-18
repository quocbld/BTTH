package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class DS2KhachSan extends AppCompatActivity {
    Button btnBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ds2_khach_san);
        BottomNavigationView btnav = findViewById(R.id.btnavigation3);
        btnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:{
                        Intent intent = new Intent(DS2KhachSan.this,MainActivity.class);
                        startActivity(intent);}
                    break;
                    case R.id.nav_profile: {
                        Intent intent = new Intent(DS2KhachSan.this, Profile.class);
                        startActivity(intent);
                    }
                    break;
                    case R.id.nav_list:{
                        Intent intent = new Intent(DS2KhachSan.this,DSKhachSan.class);
                        startActivity(intent);
                    }
                    break;

                }
                return true;
            }
        });
        btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(DS2KhachSan.this, DSKhachSan.class);
                startActivity(intent);
            }
        });
        Intent intent = getIntent();
        TextView txtdatphong = (TextView) findViewById(R.id.tenks);
        txtdatphong.setText(""+intent.getStringExtra("phong"));
    }
}