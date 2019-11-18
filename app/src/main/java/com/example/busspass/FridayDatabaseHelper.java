package com.example.busspass;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class FridayDatabaseHelper extends SQLiteOpenHelper {

    public static final String DATABASE_NAME="Friday.db";
    public static final String TABLE_NAME= "FridayList_table";
    public static final String Col_1="ID";
    public static final String Col_2="TIME";
    public static final String Col_3="START";
    public static final String Col_4="DESTINATION";
    public static final String Col_5="BUS";
    public static final String Col_6="ALARMSWITCH";
    public static final String Col_7="NOTIFYSWITCH";


    public FridayDatabaseHelper(Context context) {
        super(context, DATABASE_NAME,null,1);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTable="create table "+TABLE_NAME+ " ("+Col_1+" INTEGER PRIMARY KEY AUTOINCREMENT,TIME TEXT,START TEXT,DESTINATION TEXT,BUS TEXT,ALARMSWITCH BOOLEAN,NOTIFYSWITCH BOOLEAN)";
        db.execSQL(createTable);


    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String id,String Time,String Start,String Destination,String Bus,Boolean Alarm,Boolean Notify)
    {
        SQLiteDatabase db=this.getWritableDatabase();
        ContentValues contentValues=new ContentValues();
        contentValues.put(Col_1,id);
        contentValues.put(Col_2,Time);
        contentValues.put(Col_3,Start);
        contentValues.put(Col_4,Destination);
        contentValues.put(Col_5,Bus);
        contentValues.put(Col_6,Alarm);
        contentValues.put(Col_7,Notify);

        db.insertWithOnConflict(TABLE_NAME,null,contentValues,SQLiteDatabase.CONFLICT_IGNORE);
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

