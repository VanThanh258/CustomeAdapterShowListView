package com.example.customadaptershowlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Filterable;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class BaiHatAdapter extends ArrayAdapter<Baihat> {
    private Context context;
    private int resource;
    private List<Baihat> baihatList;
    public BaiHatAdapter(@NonNull Context context, int resource, @NonNull List<Baihat> objects) {
        super(context, resource, objects);
        this.context = context;
        this.resource = resource;
        this.baihatList = objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.item_listview, null);

        TextView tvBH = convertView.findViewById(R.id.item_txtTenBaiHat);
        TextView tvCS = convertView.findViewById(R.id.item_txtTenCaSi);
        TextView tvTL = convertView.findViewById(R.id.item_txtThoiLuong);

        Baihat bh = baihatList.get(position);
        tvBH.setText(bh.getTenBH());
        tvCS.setText(bh.getTenCaSi());
        tvTL.setText( bh.getThoiLuong() + "");

        return convertView;
    }
}
