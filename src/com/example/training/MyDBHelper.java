package com.example.training;

import android.R.integer;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDBHelper extends SQLiteOpenHelper {
    final private static int _DB_VERSION = 1;
    final private static String _DB_DATABASE_NAME = "MyDatabases.db";
    final private static String _DB_TABLE_NAME = "acInforDB";
    private Cursor cursor = null;
    
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
                "create table "+_DB_TABLE_NAME+"(id INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL, account VARCHAR, password VARCHAR)";              
        db.execSQL(DATABASE_CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {
        // TODO Auto-generated method stub
        
    }

    public void InsertDatabase(String account, String password) { 
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("id", 1);
        cv.put("account", account);
        cv.put("password", password);
        db.insert("acInforDB", null, cv);
    }
    public void UpdateDatabase(String account, String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put("account", account);
        cv.put("password", password);
        db.update(_DB_TABLE_NAME, cv, "id==1", null);
    }
    public String[] GetDatabase() {
        loadCursor();
        cursor.moveToLast();
        String[] data = {cursor.getString(1), cursor.getString(2)};
        return data;
    }
    public int getCursorCount() {
        loadCursor();
        return cursor.getCount();
    }
    private void loadCursor() {
        if (cursor == null) {
            SQLiteDatabase db = this.getWritableDatabase();
            cursor = db.query("acInforDB", new String[] {"id", "account", "password"}, null, null, null, null, null);
        }
    }
}
