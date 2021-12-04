package com.example.tugasrumah7;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainCreate extends AppCompatActivity {
    private com.example.tugasrumah7.MyDatabase db;
    private EditText Enama, Ejenis, Easal;
    private String Snama, Sjenis, Sasal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_create);
        db = new com.example.tugasrumah7.MyDatabase(this);
        Enama = (EditText) findViewById(R.id.create_nama);
        Ejenis = (EditText) findViewById(R.id.create_jenis);
        Easal = (EditText) findViewById(R.id.create_asal);
        Button btnCreate = (Button)
                findViewById(R.id.create_btn);
        btnCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snama = String.valueOf(Enama.getText());
                Sjenis = String.valueOf(Ejenis.getText());
                Sasal = String.valueOf(Easal.getText());
                if (Snama.equals("")){
                    Enama.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi nama",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Sjenis.equals("")) {
                    Ejenis.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi jenis",
                            Toast.LENGTH_SHORT).show();
                }
                else if (Sasal.equals("")) {
                    Easal.requestFocus();
                    Toast.makeText(MainCreate.this, "Silahkan isi Asal Hewan",
                            Toast.LENGTH_SHORT).show();
                }
                else {
                    Enama.setText("");
                    Ejenis.setText("");
                    Toast.makeText(MainCreate.this, "Data telah ditambah",
                            Toast.LENGTH_SHORT).show();
                    db.CreatePetShop(new PetShop(null, Snama, Sjenis, Sasal));
                    Intent a = new Intent(MainCreate.this,
                            MainActivity.class);
                    startActivity(a);
                }
            }
        });
    }
}

