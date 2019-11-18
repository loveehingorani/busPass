package com.example.busspass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="";
    public static final String TABLE_NAME= "";
    public static final String Col_1="ID";
    public static final String Col_2="TIME";
    public static final String Col_3="START";
    public static final String Col_4="DESTINATION";
    public static final String Col_5="BUS";
    public static final String Col_6="ALARMSWITCH";
    public static final String Col_7="NOTIFYSWITCH";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME,null,1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable="create table "+TABLE_NAME+ " ("+Col_1+" INTEGER PRIMARY KEY AUTOINCREMENT,TIME TEXT,START TEXT,DESTINATION TEXT,BUS TEXT,ALARMSWITCH BOOLEAN,NOTIFYSWITCH BOOLEAN)";
        db.execSQL(createTable);
        insertData("7:00 AM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        insertData("8:00 AM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        insertData("1:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        insertData("5:00 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String Time,String Start,String Destination,String Bus,Boolean Alarm,Boolean Notify)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Col_2,Time);
        contentValues.put(Col_3,Start);
        contentValues.put(Col_4,Destination);
        contentValues.put(Col_5,Bus);
        contentValues.put(Col_6,Alarm);
        contentValues.put(Col_7,Notify);

        db.insert(TABLE_NAME,null,contentValues);
        return true;

    }

    public Cursor getAllData()
    {   SQLiteDatabase db=this.getWritableDatabase();
        Cursor res=db.rawQuery("select * from "+TABLE_NAME,null);
        return res;
    }

    public boolean updatedata(String Id,Boolean Alarm,Boolean Notify)
    {
        SQLiteDatabase db=this.getWritableDatabase();
            ContentValues contentValues=new ContentValues();
            contentValues.put(Col_1,Id);

            contentValues.put(Col_6,Alarm);
            contentValues.put(Col_7,Notify);
            db.update(TABLE_NAME,contentValues,"ID=?",new String[]{ (Id)});
            return true;
    }

}
