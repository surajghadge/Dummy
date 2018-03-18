package com.practise.dummy;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by win 8 pc on 1/24/2018.
 */
//no comment
public class TestHelper extends SQLiteOpenHelper {
    public TestHelper(Context context) {
        super(context, "db_name", null, 2);
        Log.e("TestHelper","Constructor");
        SQLiteDatabase db=this.getWritableDatabase();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("TestHelper","onCreate()");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e("TestHelper","onUpgrade");
    }
}
