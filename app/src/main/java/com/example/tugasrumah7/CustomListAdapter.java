package com.example.tugasrumah7;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class CustomListAdapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<PetShop> PetShop;
    public CustomListAdapter(Activity activity, List<PetShop>
            PetShop) {
        this.activity = activity;
        this.PetShop = PetShop;
    }
    @Override
    public int getCount() {
        return PetShop.size();
    }
    @Override
    public Object getItem(int location) {
        return PetShop.get(location);
    }
    @Override
    public long getItemId(int position) {
        return position;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup
            parent) {
        if (inflater == null)
            inflater = (LayoutInflater) activity

                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (convertView == null)
            convertView = inflater.inflate(R.layout.custom_list,
                    null);
        TextView nama = (TextView)
                convertView.findViewById(R.id.text_nama);
        TextView jenis = (TextView)
                convertView.findViewById(R.id.text_jenis);
        TextView asal = (TextView)
                convertView.findViewById(R.id.text_asal);
        ImageView imageView = (ImageView)
                convertView.findViewById(R.id.iconid);
        PetShop p = PetShop.get(position);
        nama.setText("Nama : "+ p.get_nama());
        jenis.setText("Jenis : "+ p.get_jenis());
        asal.setText("Asal Hwan : "+ p.get_asal());
        return convertView;
    }
}

