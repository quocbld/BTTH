package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText eUser, ePassword;
    Button bDangnhap, bDangKy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Anhxa();
        bDangnhap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (eUser.getText().length() != 0 && ePassword.getText().length() != 0) {
                    if (eUser.getText().toString().equals("quoc") && ePassword.getText().toString().equals("12345")) {
                        Toast.makeText(MainActivity.this, "Dang Nhap Thanh Cong", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity.this,MyHome.class);
                        startActivity(intent);

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
    }
}