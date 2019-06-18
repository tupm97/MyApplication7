package com.example.myapplication;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.view.accessibility.AccessibilityManager;
import android.widget.Toast;

import java.util.ArrayList;

public class DatabaseManager extends SQLiteOpenHelper {
    private Context context;
    public DatabaseManager(Context context) {
        super(context,"DBDemo",null,1);
        this.context=context;
        Toast.makeText(context,"Create database", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String q="Create table SinhVien (id integer primary key autoincrement, hoTen TEXT, tuoi integer)";
        db.execSQL(q);
        Toast.makeText(context,"OnCreate table Sinh Vien",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String q="drop table if exist SinhVien";
        onCreate(db);
        Toast.makeText(context,"OnUpgrade table Sinh Vien",Toast.LENGTH_SHORT).show();
    }

    public void addSV(SinhVien sinhVien){
        try {
            SQLiteDatabase database=getWritableDatabase();
            ContentValues contentValues = new ContentValues();
            contentValues.put("hoTen",sinhVien.getHoTen());
            contentValues.put("tuoi",sinhVien.getTuoi());

            database.insert("SinhVien",null,contentValues);
        }
        catch (SQLException e){
            e.getMessage();
            e.printStackTrace();
        }
    }

    public ArrayList<SinhVien> getAll(){
        SQLiteDatabase database=getReadableDatabase();
        ArrayList<SinhVien> list= new ArrayList<>();
        String q="SELECT * FROM SinhVien";
        Cursor cursor= database.rawQuery(q,null);
        if(cursor.moveToFirst()){
            do{
                SinhVien sv= new SinhVien();
                sv.setHoTen(cursor.getString(cursor.getColumnIndex("hoTen")));
                sv.setTuoi(cursor.getInt(cursor.getColumnIndex("tuoi")));
                list.add(sv);
            }
            while(cursor.moveToNext());
        }
        return list;
    }
}
