package com.traincoders.edb;

import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ConsumeEdbHelper extends SQLiteOpenHelper {

    static final String dbName = "edb.db";
    static final String consumeTable = "consume_table";
    private static ConsumeEdbHelper mInstance = null;
    
    /* --- user_table columns --- */
    static final String colID = "consume_id";
    static final String colNickname = "nickname";
    static final String colProdID = "prod_id";
    static final String colDate = "consumed_date";
    static final String colAmountConsumed = "amount_consumed";
    
    public ConsumeEdbHelper(Context context) {
    	super(context, dbName, null, 33);
    }
    
    public static ConsumeEdbHelper getInstance(Context ctx) {
    	if (mInstance == null) {
            mInstance = new ConsumeEdbHelper(ctx.getApplicationContext());
        }
        return mInstance;
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
    	// Create consume_table
    	db.execSQL("CREATE TABLE " + consumeTable + "("+ colID + " INTEGER PRIMARY KEY, " +
    			colNickname + " TEXT NOT NULL, " + colProdID + " INTEGER NOT NULL, " + colDate + " TEXT NOT NULL, " +
    			colAmountConsumed + " INTEGER )");
    }    
    
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { 
    	db.execSQL("DROP TABLE IF EXISTS " + consumeTable);
    	onCreate(db);
    }    
    
    public void insertConsumeRow(SQLiteDatabase db, EdbConsumable consume) {
    	ContentValues cv = new ContentValues();
    	cv.put("nickname", consume.getNickname());
    	cv.put("prod_id", consume.getProdId());
    	cv.put("consumed_date", DateToString(consume.getConsumedDate()));
    	cv.put("amount_consumed", consume.getAmountConsumed());
    	db.insert(consumeTable, colID, cv);
    }
    
	private String DateToString(Date date) {		
		java.util.Date today = new java.util.Date();		
		return date != null ? String.valueOf(date) : String.valueOf(today.getTime());
	}
	
}