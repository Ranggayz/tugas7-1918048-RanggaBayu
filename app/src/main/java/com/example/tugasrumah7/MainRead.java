package com.example.tugasrumah7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainRead extends AppCompatActivity implements AdapterView.OnItemClickListener{
    private ListView mListView;
    private CustomListAdapter adapter_off;
    private MyDatabase db;
    private List<PetShop> listPetShop = new
            ArrayList<PetShop>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_read);
        db = new MyDatabase(this);
        adapter_off = new CustomListAdapter(this, listPetShop);
        mListView = (ListView) findViewById(R.id.list_jenis);
        mListView.setAdapter(adapter_off);
        mListView.setOnItemClickListener(this);
        mListView.setClickable(true);
        listPetShop.clear();
        List<PetShop> PetShop = db.ReadPetShop();
        for (PetShop pet :PetShop) {
            PetShop pets = new PetShop();
            pets.set_id(pet.get_id());
            pets.set_nama(pet.get_nama());
            pets.set_jenis(pet.get_jenis());
            pets.set_asal(pet.get_asal());
            listPetShop.add(pets);
            if ((listPetShop.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int
            i, long l) {
        Object o = mListView.getItemAtPosition(i);
        PetShop detailPet = (PetShop) o;
        String Sid = detailPet.get_id();
        String Snama = detailPet.get_nama();
        String Sjenis = detailPet.get_jenis();
        String Sasal = detailPet.get_asal();
        Intent goUpdel = new Intent(MainRead.this,
                com.example.tugasrumah7.MainUpdel.class);
        goUpdel.putExtra("Iid", Sid);
        goUpdel.putExtra("Inama", Snama);
        goUpdel.putExtra("Ijenis", Sjenis);
        goUpdel.putExtra("Iasal", Sasal
        );
        startActivity(goUpdel);
    }
    @Override
    protected void onResume() {
        super.onResume();
        listPetShop.clear();
        mListView.setAdapter(adapter_off);
        List<PetShop> petshop = db.ReadPetShop();
        for (PetShop pts : petshop) {
            PetShop ptsp = new PetShop();
            ptsp.set_id(pts.get_id());
            ptsp.set_nama(pts.get_nama());
            ptsp.set_jenis(pts.get_jenis());
            ptsp.set_asal(pts.get_asal());
            listPetShop.add(ptsp);
            if ((listPetShop.isEmpty()))
                Toast.makeText(MainRead.this, "Tidak ada data",
                        Toast.LENGTH_SHORT).show();
            else {
            }
        }
    }
}

