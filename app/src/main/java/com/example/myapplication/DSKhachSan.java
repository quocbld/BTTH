package com.example.myapplication;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class DSKhachSan extends AppCompatActivity {
    ListView lvKhachSan;
    ArrayList<KhachSan> arrayKhachSan;
    KhachSanAdapter adapter;
    int vitri=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dskhach_san);
        Anhxa();
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
                startActivity(intent);
            }
        });
        lvKhachSan.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder b = new AlertDialog.Builder(DSKhachSan.this);
                b.setTitle("Lê Bá Quốc");
                b.setMessage("Bạn có đồng ý xóa Khách sạn này không ?");
                b.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        arrayKhachSan.remove(vitri);
                        adapter.notifyDataSetChanged();
                    }
                });
                b.setNegativeButton("Không đồng ý", new DialogInterface.OnClickListener() {
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
        arrayKhachSan.add(new KhachSan("Khách sạn Dạ Hương","Khách sạn 3 sao",R.drawable.khachsan1));
        arrayKhachSan.add(new KhachSan("Khách sạn Mường Thanh","Khách sạn 5 sao",R.drawable.khachsan2));
        arrayKhachSan.add(new KhachSan("Khách sạn LARA","Dịch vụ tận tình chu đáo",R.drawable.khachsan3));
        arrayKhachSan.add(new KhachSan("Khách sạn Paciler","Khách sạn hàng đầu Đà Lạt",R.drawable.khachsan4));
        arrayKhachSan.add(new KhachSan("Khách sạn TODAY","Giá rẻ bất ngờ",R.drawable.khachsan5));
    }
}