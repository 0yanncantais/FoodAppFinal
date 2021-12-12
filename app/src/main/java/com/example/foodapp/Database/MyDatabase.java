package com.example.foodapp.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;
import android.util.Log;
import com.example.foodapp.Database.FeedReaderContract;

import java.util.ArrayList;
import java.util.List;

public class MyDatabase extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_FILE_NAME = "mydatabase.db";
    /*private static final String DATABASE_TABLE_NAME = "mydatabase";
    private static final String PKEY = "pkey";
    private static final String COL1 = "col1";*/

    public MyDatabase(Context context) {
        super(context, DATABASE_FILE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        /*String DATABASE_TABLE_CREATE = " CREATE TABLE " + DATABASE_TABLE_NAME + " (" +
                PKEY + "INTEGER PRIMARY KEY," + COL1 + "TEXT);";*/
        String DATABASE_TABLE_CREATE="CREATE TABLE recettesdata ("
                + "pkey INTEGER PRIMARY KEY AUTOINCREMENT,"
                +"recette String not null)";
        db.execSQL(DATABASE_TABLE_CREATE);
        Log.i("DATABASE", "onCreate invoked");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        String DATABASE_TABLE_CREATE = "drop table recette";
        db.execSQL(DATABASE_TABLE_CREATE);
        this.onCreate(db);
        Log.i("DATABASE", "onUpgrade invoked");
    }

    public void insertData(String s) {
        /*Log.i("JFL", "Insert in database");
        SQLiteDatabase db = getWritableDatabase();
        db.beginTransaction();
        ContentValues values = new ContentValues();
        values.put(COL1, s);
        db.insertOrThrow(DATABASE_TABLE_NAME, null, values);
        db.setTransactionSuccessful();
        db.endTransaction();*/
        s=s.replace("'","''");
        String DATABASE_TABLE_INSERT="insert into mydatabase (recette) values ('"+ s+"');";
        this.getWritableDatabase().execSQL(DATABASE_TABLE_INSERT);
        Log.i("DATABASE", "onInsert invoked");
    }


    public List<RecetteData> readData() {
        /*Log.i("JFL", "Reading database");
        String select = new String("SELECT * from " + DATABASE_TABLE_NAME);
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.rawQuery(select, null);
        Log.i("JFL", "Number of entries: " + cursor.getCount());
        if (cursor.getCount() > 0) {
            cursor.moveToFirst();
            do {
                Log.i("JFL", "Reading: " + cursor.getString(cursor.getColumnIndexOrThrow(COL1)));
            } while (cursor.moveToNext());
        }*/
        List<RecetteData> recettes=new ArrayList<>();

        String strSQL = "select * from mydatabase order by recette desc";
        Cursor cursor=this.getReadableDatabase().rawQuery(strSQL,null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            RecetteData recette=new RecetteData(cursor.getInt(0),cursor.getString(1));
            recettes.add(recette);
            cursor.moveToNext();
        }
        cursor.close();
        return recettes;
    }



}
