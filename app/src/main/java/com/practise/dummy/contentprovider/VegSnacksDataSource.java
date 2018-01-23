package com.practise.dummy.contentprovider;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.practise.dummy.Constants.DatabaseConstants;
import com.practise.dummy.model.VegSnacksList;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by win 8 pc on 1/6/2018.
 */

public class VegSnacksDataSource {

    private static SQLiteDatabase sqLiteDatabase = null;

    public VegSnacksDataSource() {
    }

    public void open(Context context) {
        sqLiteDatabase = context.openOrCreateDatabase(DatabaseConstants.VEG_SNACKS_TABLE, Context.MODE_PRIVATE, null);
        sqLiteDatabase.execSQL(DatabaseConstants.VEG_SNACKS_TABLE_CREATE_SCRIPT);
    }

    public void close(Context context) {
        open(context);
        sqLiteDatabase.close();
    }


    public String storeVegSnacksData(String response,Context context) throws JSONException {
        JSONArray jsonArray = new JSONArray(response);
        for (int i = 0; i < jsonArray.length(); i++) {
            insertIntoVegSnacks(context,jsonArray.getJSONObject(i));
        }
        return "Success";
    }

    private void insertIntoVegSnacks(Context context,JSONObject jsonObject) throws JSONException{
        Log.e("Method","insertIntoVegSnacks()");
        VegSnacksList vegSnacksID=getItemByID(jsonObject.getString("itemid"));
        ContentValues values = new ContentValues();
        if(vegSnacksID==null){
            values.put(DatabaseConstants.VEG_SNACKS_ID,jsonObject.getString("itemid"));
            values.put(DatabaseConstants.VEG_SNACKS_Name,jsonObject.getString("itemname"));
            values.put(DatabaseConstants.VEG_SNACKS_PRICE,jsonObject.getString("price"));
            Long res = sqLiteDatabase.insert(DatabaseConstants.VEG_SNACKS_TABLE, null, values);
            System.out.println(res + "veg snacks inserted");
        }
        else {
            values.put(DatabaseConstants.VEG_SNACKS_ID,jsonObject.getString("itemid"));
            values.put(DatabaseConstants.VEG_SNACKS_Name,jsonObject.getString("itemname"));
            values.put(DatabaseConstants.VEG_SNACKS_PRICE,jsonObject.getString("price"));
            int res = sqLiteDatabase.update(DatabaseConstants.VEG_SNACKS_TABLE, values, DatabaseConstants.VEG_SNACKS_ID + " = ?",
                    new String[]{String.valueOf(jsonObject.getString("itemid"))});
            System.out.println(res + "veg snacks Updated");
        }
    }

    private VegSnacksList getItemByID(String ID){
        Log.e("Method","getItemByID()");
        VegSnacksList vegSnacks=null;
        Log.e("veg snacks query","select * from " + DatabaseConstants.VEG_SNACKS_TABLE + " where "+DatabaseConstants.VEG_SNACKS_ID+"='"+ID+"'");
        Cursor cursor=sqLiteDatabase.rawQuery("select * from " + DatabaseConstants.VEG_SNACKS_TABLE + " where "+DatabaseConstants.VEG_SNACKS_ID+"='"+ID+"'",null);
        Log.e("veg snacks cursor",cursor.toString());
        if(cursor.moveToFirst()){
            Log.i("1st Snacks Cursor",cursor.toString());
            String itemid=cursor.getString(cursor.getColumnIndex(DatabaseConstants.VEG_SNACKS_ID));
            String itemname=cursor.getString(cursor.getColumnIndex(DatabaseConstants.VEG_SNACKS_Name));
            String price=cursor.getString(cursor.getColumnIndex(DatabaseConstants.VEG_SNACKS_PRICE));
            Log.e("itemname",itemname);
            vegSnacks.setItemid(itemid);
            vegSnacks.setItemname(itemname);
            vegSnacks.setPrice(price);
            Log.i("Snacks Cursor",vegSnacks.toString());
            cursor.moveToNext();
        }
        if (cursor.isAfterLast()){
            cursor.close();
        }
        return  vegSnacks;
    }


}
