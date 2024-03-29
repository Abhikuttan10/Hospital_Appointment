package com.example.docapp;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Database extends SQLiteOpenHelper {

    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qry1= "create table users(Name,PhoneNumber,EmailAddress,Password)";
        sqLiteDatabase.execSQL(qry1);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public void register(String Name, String PhoneNumber,String EmailAddress,String Password){
        ContentValues cv=new ContentValues();
        cv.put("Name",Name);
        cv.put("PhoneNumber",PhoneNumber);
        cv.put("EmailAddress",EmailAddress);
        cv.put("Password",Password);
        SQLiteDatabase db =getWritableDatabase();
        db.insert("users",null,cv);
        db.close();

    }
    public int login(String PhoneNumber,String Password){
        int result=0;
        String str[]=new String[2];
        str[0]=PhoneNumber;
        str[1]=Password;
        SQLiteDatabase db=getReadableDatabase();
        Cursor c=db.rawQuery("select * from users where PhoneNumber=? and Password=?",str);
        if (c.moveToFirst()){
            result=1;
        }
        return result;
    }
}
