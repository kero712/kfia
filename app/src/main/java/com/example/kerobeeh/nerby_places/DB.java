package com.example.kerobeeh.nerby_places;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DB extends SQLiteOpenHelper {
    public static final String DBNAME = "data.db";

    public DB(Context context) {
        super(context, DBNAME , null, 1);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table sign (id INTEGER PRIMARY KEY AUTOINCREMENT , image TEXT,name TEXT, birthday TEXT, email TEXT ,password TEXT )");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("DROP TABLE IF EXISTS sign ");
        onCreate(db);

    }

    public boolean insertdata(String email, String birthday , String name, String pass) {

        SQLiteDatabase dp = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("password", pass);
        contentValues.put("email", email);
        contentValues.put("birthday", birthday);
        long result = dp.insert("sign", null, contentValues);

        if (result == -1) {
            return false;
        } else
            return true;
    }



    boolean ch(String EmailId, String txtpass2) {

        SQLiteDatabase db = this.getReadableDatabase();
        String select = "select * from sign where email =? and password =?";

        Cursor res = db.rawQuery(select,new String[]{EmailId,txtpass2});
        if(res.moveToFirst())
            return true;
        else
            return false;


    }


}
