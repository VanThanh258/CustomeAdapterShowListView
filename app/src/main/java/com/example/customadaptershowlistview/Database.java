package com.example.customadaptershowlistview;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    public static final String DB_NAME = "db_BH";
    private static final String TABLE_NAME = "table_baihat";
    private static final String MA = "MA";
    private static final String TENBH = "TenBH";
    private static final String TENCS = "TenCS";
    private static final String THOILUONG = "ThoiLuong";

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, DB_NAME, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String query = "Create table " + TABLE_NAME + "(" + MA + " integer primary key AUTOINCREMENT, " +
            TENBH + " TEXT, " + TENCS + " TEXT, " + THOILUONG + " float )";
        sqLiteDatabase.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("delete from " + TABLE_NAME);
        sqLiteDatabase.close();
    }

    public void DeleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();

    }

    public void AddBaiHat(Baihat bh){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(TENBH, bh.getTenBH());
        contentValues.put(TENCS, bh.getTenCaSi());
        contentValues.put(THOILUONG, bh.getThoiLuong());
        db.insert(TABLE_NAME, null, contentValues);
        db.close();
    }

    public List<Baihat> GetAll(){
        List<Baihat> list = new ArrayList<>();
        String query = "Select * from " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                Baihat bh = new Baihat();
                bh.setMaBH(cursor.getInt(0));
                bh.setTenBH(cursor.getString(1));
                bh.setTenBH(cursor.getString(2));
                bh.setThoiLuong(cursor.getFloat(3));
                list.add(bh);
            }while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return list;
    }

}
