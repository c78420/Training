package com.example.training;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {
    final private static int _DB_VERSION = 1;
    final private static String _DB_DATABASE_NAME = "MyDatabases.db";
    
    public MyDBHelper(Context context) {
        super(context, _DB_DATABASE_NAME, null, _DB_VERSION);
        // TODO Auto-generated constructor stub
    }
    public MyDBHelper(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // TODO Auto-generated method stub
        String DATABASE_CREATE_TABLE =
                "create table acInforDB(id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL, account VARCHAR, password VARCHAR)";              
        db.execSQL(DATABASE_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
        
    }

}
