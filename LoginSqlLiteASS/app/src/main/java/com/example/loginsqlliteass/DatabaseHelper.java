package com.example.loginsqlliteass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper{

    public static final String databaseName = "Signup.db";
    public static final String TABLE_USERS = "allusers";
    public static final String TABLE_MAHASISWA = "mahasiswa";

    public DatabaseHelper(@Nullable Context context) {
        super(context, "Signup.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase MyDatabase) {
        // Membuat tabel pengguna
        MyDatabase.execSQL("create table " + TABLE_USERS + " (email TEXT PRIMARY KEY, password TEXT)");
        String sql = "create table mahasiswa(nama text null,kampus text null);";
        Log.d("Data","onCreate"+ sql);
        MyDatabase.execSQL(sql);
        Log.d("DatabaseHelper", "Tabel mahasiswa telah dibuat");

    }



    @Override
    public void onUpgrade(SQLiteDatabase MyDatabase, int i, int i1) {

    }

    public Boolean insertData(String email, String password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("email", email);
        contentValues.put("password", password);
        long result = MyDatabase.insert("allusers", null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    public Boolean checkEmail(String email){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from allusers where email = ?", new String[]{email});
        if(cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }

    public Boolean checkEmailPassword(String email, String password){
        SQLiteDatabase MyDatabase = this.getWritableDatabase();
        Cursor cursor = MyDatabase.rawQuery("Select * from allusers where email = ? and password = ?", new String[]{email, password});
        if (cursor.getCount() > 0) {
            return true;
        }else {
            return false;
        }
    }
}
