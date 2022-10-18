package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    EditText eUser, ePassword;
    Button bDangnhap, bDangKy;
    BottomNavigationView btNav;
    SharedPreferences luuuser;
    CheckBox cbluutk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        luuuser = getSharedPreferences("TaiKhoan",MODE_PRIVATE);
        eUser.setText(luuuser.getString("taikhoan",""));
        ePassword.setText(luuuser.getString("matkhau",""));
        cbluutk.setChecked(luuuser.getBoolean("checked",false));

        BottomNavigationView btnav = findViewById(R.id.btnavigation);
        btnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:{
                        Intent intent = new Intent(MainActivity.this,MainActivity.class);
                        startActivity(intent);}
                    break;
                    case R.id.nav_profile: {
                        Intent intent = new Intent(MainActivity.this, Profile.class);
                        startActivity(intent);
                    }
                    break;
                    case R.id.nav_list:{
                        Intent intent = new Intent(MainActivity.this,DSKhachSan.class);
                        startActivity(intent);
                    }
                    break;

                }
                return true;
            }
        });
        bDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (eUser.getText().toString().length() != 0 && ePassword.getText().toString().length() != 0) {
                    if (eUser.getText().toString().equals("quoc") && ePassword.getText().toString().equals("12345")) {
                        Toast.makeText(MainActivity.this, "Dang Nhap Thanh Cong", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,DSKhachSan.class);
                        startActivity(intent);
                        if(cbluutk.isChecked()){
                            SharedPreferences.Editor editor = luuuser.edit();
                            editor.putString("taikhoan", String.valueOf(eUser.getText().toString()));
                            editor.putString("matkhau", String.valueOf(ePassword.getText().toString()));
                            editor.putBoolean("checked",true);
                            editor.commit();
                        }else {
                            SharedPreferences.Editor editor=luuuser.edit();
                            editor.remove("taikhoan");
                            editor.remove("matkhau");
                            editor.remove("checked");
                            editor.commit();
                        }

                    } else {
                        Toast.makeText(MainActivity.this, "Sai Mat Khau", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(MainActivity.this, "Vui Long Nhap Day Du Thong Tin", Toast.LENGTH_SHORT).show();
                }
            }
        });
        bDangKy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DangKi.class);
                startActivity(intent);
            }
        });

    }

    private void Anhxa() {
        eUser = (EditText) findViewById(R.id.EditTextUserName);
        ePassword = (EditText) findViewById(R.id.editTextPassword);
        bDangnhap = (Button) findViewById(R.id.ButtonSignIn);
        bDangKy = (Button) findViewById(R.id.ButtonSignUp);
        cbluutk = (CheckBox) findViewById(R.id.checkBox3);
    }
}