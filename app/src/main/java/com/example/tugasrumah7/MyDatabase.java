package com.example.tugasrumah7;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static int DATABASE_VERSION = 1;
    private static String DATABASE_NAME = "db_PetShop";
    private static final String tb_petshop = "tb_petshop";
    private static final String tb_petshop_id = "id";
    private static final String tb_petshop_nama = "nama";
    private static final String tb_petshop_jenis = "jenis";
    private static final String tb_petshop_asal = "asal";
    private static final String CREATE_TABLE_PETSHOP = "CREATE TABLE " + tb_petshop +"("
            + tb_petshop_id + " INTEGER PRIMARY KEY ,"
            + tb_petshop_nama + " TEXT ,"
            + tb_petshop_jenis + " TEXT ,"
            + tb_petshop_asal +" TEXT " + ")";
    public MyDatabase (Context context){
        super(context, DATABASE_NAME, null , DATABASE_VERSION);
    }
    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE_PETSHOP);
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int
            newVersion) {
    }
    public void CreatePetShop(PetShop data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_petshop_id, data.get_id());
        values.put(tb_petshop_nama, data.get_nama());
        values.put(tb_petshop_jenis, data.get_jenis());
        values.put(tb_petshop_asal, data.get_asal());
        db.insert(tb_petshop, null, values);
        db.close();
    }
    public List<PetShop> ReadPetShop() {
        List<PetShop> listMhs = new ArrayList<PetShop>();
        String selectQuery = "SELECT * FROM " + tb_petshop;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                PetShop data = new PetShop();
                data.set_id(cursor.getString(0));
                data.set_nama(cursor.getString(1));
                data.set_jenis(cursor.getString(2));
                data.set_asal(cursor.getString(3));
                listMhs.add(data);
            } while (cursor.moveToNext());
        }
        db.close();
        return listMhs;
    }
    public int UpdatePetShop (PetShop data){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(tb_petshop_nama, data.get_nama());
        values.put(tb_petshop_jenis, data.get_jenis());
        values.put(tb_petshop_asal, data.get_asal());
        return db.update(tb_petshop, values, tb_petshop_id +
                        " = ?",
                new String[]{String.valueOf((data.get_id()))});
    }
    public void DeletePetShop(PetShop data){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(tb_petshop,tb_petshop_id+ " = ?",
                new String[]{String.valueOf(data.get_id())});
        db.close();
    }
}

