package com.example.customadaptershowlistview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {
    Button btnThem, btnSua, btnXoa, btnSearch;
    EditText edtTenBH, edtTenCasi, edtThoiLuong,edtSearch;
    ListView lsvBH;
    int index;

    ArrayList<Baihat> arrayList = new ArrayList<>();
    BaiHatAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Map();

        adapter = new BaiHatAdapter(this, R.layout.item_listview, arrayList);
        lsvBH.setAdapter(adapter);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Baihat bh = new Baihat(edtTenBH.getText().toString(), edtTenCasi.getText().toString(), Float.parseFloat(edtThoiLuong.getText().toString()));
                arrayList.add(bh);
                adapter.notifyDataSetChanged();
                edtTenBH.setText("");
                edtTenCasi.setText("");
                edtThoiLuong.setText("");
            }
        });
        lsvBH.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edtTenBH.setText(arrayList.get(i).getTenBH());
                edtTenCasi.setText(arrayList.get(i).getTenCaSi());
                edtThoiLuong.setText(arrayList.get(i).getThoiLuong()+"");
                index = i;
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Baihat bh = new Baihat(edtTenBH.getText().toString(), edtTenCasi.getText().toString(), Float.parseFloat(edtThoiLuong.getText().toString()));
                arrayList.set(index,bh);
                adapter.notifyDataSetChanged();
            }
        });
        btnXoa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Baihat bh = new Baihat(edtTenBH.getText().toString(), edtTenCasi.getText().toString(), Float.parseFloat(edtThoiLuong.getText().toString()));
                arrayList.remove(index);
                adapter.notifyDataSetChanged();
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String s = edtSearch.getText().toString();
            }
        });
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for(int i=0; i<arrayList.size();i++){
                    String search = edtSearch.getText().toString().trim().toLowerCase(Locale.ROOT);
                    if(arrayList.get(i).getTenBH().toLowerCase(Locale.ROOT).contains(search)){
                        edtTenBH.setText(arrayList.get(i).getTenBH());
                        edtTenCasi.setText(arrayList.get(i).getTenCaSi());
                        edtThoiLuong.setText(arrayList.get(i).getThoiLuong()+"");
                        break;
                    }
                }
            }
        });
    }

    private  void Map(){
        btnThem = findViewById(R.id.btnThem);
        btnSua = findViewById(R.id.btnSua);
        btnXoa = findViewById(R.id.btnXoa);
        btnSearch = findViewById(R.id.btnSearch);
        edtTenBH = findViewById(R.id.edtTenBaiHat);
        edtTenCasi = findViewById(R.id.edtTenCaSi);
        edtThoiLuong = findViewById(R.id.edtThoiLuong);
        edtSearch = findViewById(R.id.edtSearch);
        lsvBH = findViewById(R.id.lsvBaiHat);
    }
}