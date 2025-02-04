package com.example.dacn_cr424ac_2223_hoangbaoquan_5694;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.nfc.Tag;
import android.provider.ContactsContract;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.dacn_cr424ac_2223_hoangbaoquan_5694.Quiz.Question;

import java.util.ArrayList;

public class Database extends SQLiteOpenHelper {

    public static  String TB_TAIKHOAN = "Account" ;
    public static  String TB_TAIKHOAN_IDCCCD ="IDCCCD" ;
    public static  String TB_TAIKHOAN_PASSWORD ="PASSWORD" ;
    public static  String TB_TAIKHOAN_NAME ="NAME" ;
    public static  String TB_TAIKHOAN_PHONE ="PHONE" ;

    public Database(@Nullable Context context) {

        super(context, "Account2.db", null, 10);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String tbACCOUNT = "CREATE TABLE " + TB_TAIKHOAN + " ( " + TB_TAIKHOAN_IDCCCD + " LONG PRIMARY KEY, "
                + TB_TAIKHOAN_PASSWORD + " TEXT, "+TB_TAIKHOAN_NAME+" TEXT,"+TB_TAIKHOAN_PHONE+" TEXT )" ;
        db.execSQL(tbACCOUNT);

    }
    public Boolean insertData(long idcccd, String pass,String name, String phone){
        ContentValues contentValues = new ContentValues();
        contentValues.put(TB_TAIKHOAN_IDCCCD,idcccd);
        contentValues.put(TB_TAIKHOAN_PASSWORD,pass);
        contentValues.put(TB_TAIKHOAN_NAME,name);
        contentValues.put(TB_TAIKHOAN_PHONE,phone);
        long result = this.getWritableDatabase().insert(TB_TAIKHOAN, null, contentValues);
        if (result == -1) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " +TB_TAIKHOAN);
        onCreate(db);

    }
    public void deleteData(){
        int mytable = open().delete(TB_TAIKHOAN,"IDCCCD= "+1233333,null);
    }
    public boolean CheckSign(long idcccd, String pass){
        String truyvan ="SELECT * FROM " +TB_TAIKHOAN+  " Where " + TB_TAIKHOAN_IDCCCD + " = " +idcccd+" AND "
                +TB_TAIKHOAN_PASSWORD+ " = '"+pass+"'";
        Cursor cursor = this.getReadableDatabase().rawQuery(truyvan,null);
        if(cursor.getCount() != 0){
            return true ;
        }else{
            return false ;
        }
    }
    public boolean CheckUser(long idcccd){
        String truyvan ="SELECT * FROM " +TB_TAIKHOAN+  " Where " + TB_TAIKHOAN_IDCCCD + " = " +idcccd ;
        Cursor cursor = this.getReadableDatabase().rawQuery(truyvan,null);
        if(cursor.getCount() != 0){
            return true ;
        }else{
            return false ;
        }
    }
    public ArrayList<Info> getInfo(long idccd){
        ArrayList<Info> lsData= new ArrayList<Info>();
        String truyvan ="SELECT * FROM " +TB_TAIKHOAN+  " Where " + TB_TAIKHOAN_IDCCCD + " = " +idccd ;
        Cursor cursor = this.getReadableDatabase().rawQuery(truyvan,null);
            cursor.moveToFirst();
            Info item;
            item= new Info(cursor.getLong(0),cursor.getString(2), cursor.getString(3));
            lsData.add(item);
        return lsData;
    }

    public SQLiteDatabase open(){
        return this.getWritableDatabase() ;
    }

}