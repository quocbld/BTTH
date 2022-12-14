package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class DSKhachSan extends AppCompatActivity {
    ListView lvKhachSan;
    ArrayList<KhachSan> arrayKhachSan;
    KhachSanAdapter adapter;
    ImageView imgback;
    int vitri=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dskhach_san);
        Anhxa();
        BottomNavigationView btnav = findViewById(R.id.btnavigation2);
        btnav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.nav_home:{
                        Intent intent = new Intent(DSKhachSan.this,MainActivity.class);
                        startActivity(intent);}
                    break;
                    case R.id.nav_profile: {
                        Intent intent = new Intent(DSKhachSan.this, Profile.class);
                        startActivity(intent);
                    }
                    break;
                    case R.id.nav_list:{
                        Intent intent = new Intent(DSKhachSan.this,DSKhachSan.class);
                        startActivity(intent);
                    }
                    break;

                }
                return true;
            }
        });
        adapter = new KhachSanAdapter(this,R.layout.hinh_khach_san,arrayKhachSan);
        lvKhachSan.setAdapter(adapter);
        lvKhachSan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                vitri = i;
            }
        });
        lvKhachSan.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
                Intent intent = new Intent(DSKhachSan.this, DS2KhachSan.class);
                    intent.putExtra("phong",arrayKhachSan.get(i).getTen());
                        startActivity(intent);

                }
        });
        lvKhachSan.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder b = new AlertDialog.Builder(DSKhachSan.this);
                b.setTitle("L?? B?? Qu???c");
                b.setMessage("B???n c?? ?????ng ?? x??a Kh??ch s???n n??y kh??ng ?");
                b.setPositiveButton("?????ng ??", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        arrayKhachSan.remove(vitri);
                        adapter.notifyDataSetChanged();
                    }
                });
                b.setNegativeButton("Kh??ng ?????ng ??", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.cancel();
                    }
                });
                AlertDialog al = b.create();
                al.show();
                return false;
            }
        });
    }


    private void Anhxa() {
        lvKhachSan = (ListView) findViewById(R.id.listviewKhachSan);
        arrayKhachSan = new ArrayList<>();
        arrayKhachSan.add(new KhachSan("Kh??ch s???n D??? H????ng","Kh??ch s???n 3 sao",R.drawable.khachsan1));
        arrayKhachSan.add(new KhachSan("Kh??ch s???n M?????ng Thanh","Kh??ch s???n 5 sao",R.drawable.khachsan2));
        arrayKhachSan.add(new KhachSan("Kh??ch s???n LARA","D???ch v??? t???n t??nh chu ????o",R.drawable.khachsan3));
        arrayKhachSan.add(new KhachSan("Kh??ch s???n Paciler","Kh??ch s???n h??ng ?????u ???? L???t",R.drawable.khachsan4));
        arrayKhachSan.add(new KhachSan("Kh??ch s???n TODAY","Gi?? r??? b???t ng???",R.drawable.khachsan5));
    }
}