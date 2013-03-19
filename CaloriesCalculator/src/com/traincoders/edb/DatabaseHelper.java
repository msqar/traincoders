package com.traincoders.edb;

import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

public class DatabaseHelper extends SQLiteOpenHelper {

    static final String dbName = "edb";
    static final String userTable = "user_table";
    static final String productTable = "prod_table";
    
    /* --- user_table columns --- */
    static final String colID = "user_id";
    static final String colNickname = "nickname";
    static final String colName = "user_name";
    static final String colLastName = "user_lastname";
    static final String colAge = "user_age";
    static final String colWeight = "user_weight";
    static final String colHeight = "user_height";
    static final String colGender = "user_gender";
    static final String colProdID = "prod_id";
    static final String colDate = "consumed_date";
    static final String colAmountConsumed = "amount_consumed";
    
    /* --- prod_table columns --- */
    
    static final String colProdName = "prod_name";
    static final String colProdCompany = "prod_company";
    static final String colProdType = "prod_type";
    static final String colProdSubType = "prod_subtype";
    static final String colProdCalories = "prod_calories";
    static final String colProdKJoules = "prod_kjoules"; // 1 kcal =  4184 joules
    static final String colProdCaloriesFromFat = "prod_cal_from_fat";
    
    public DatabaseHelper(Context context) {
    	super(context, dbName, null, 33);
    }
    
    public void onCreate(SQLiteDatabase db) {
    	// Create user_table and prod_table
    	db.execSQL("CREATE TABLE " + userTable + "("+ colID + " INTEGER PRIMARY KEY, " +
    			colNickname + " TEXT NOT NULL, " + colName + " TEXT, " + colLastName + " TEXT, " +
    			colAge + " INTEGER NOT NULL, " + colWeight + " REAL NOT NULL, " + colHeight + " REAL NOT NULL, " +
    			colGender +	" TEXT NOT NULL, " + colProdID + " INTEGER NOT NULL, " + colDate + " TEXT NOT NULL, " +
    			colAmountConsumed + " INTEGER )");
    	
    	db.execSQL("CREATE TABLE " + productTable + "(" + colProdID + " INTEGER PRIMARY KEY, " + 
    			colProdName + " TEXT NOT NULL, " + colProdCompany + " TEXT, " + colProdType + " TEXT NOT NULL, " +
    			colProdSubType + " TEXT, " + colProdCalories + " INTEGER NOT NULL, " + colProdKJoules + " INTEGER, " +
    			colProdCaloriesFromFat + " INTEGER)");
    }    
    
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    	db.execSQL("DROP TABLE IF EXISTS " + userTable);
    	db.execSQL("DROP TABLE IF EXISTS " + productTable);
    	onCreate(db);
    }
    
    public void insertUser(SQLiteDatabase db, EdbUser user) {
    	ContentValues cv = new ContentValues();
    	cv.put("nickname", user.getNickname());
    	cv.put("user_name", user.getName());
    	cv.put("user_lastname", user.getLastName());
    	cv.put("user_age", user.getUserAge());
    	cv.put("user_weight", user.getWeight());
    	cv.put("user_height", user.getHeight());
    	cv.put("user_gender", StringNotNull(user.getGender()));
    	cv.put("prod_id", user.getProdId());
    	cv.put("consumed_date", DateToString(user.getConsumedDate()));
    	cv.put("amount_consumed", LongToString(user.getAmountConsumed()));
    	db.insert(userTable, colID, cv);
    }
    
    public void populateProductTable(SQLiteDatabase db) {

    }

	private String LongToString(Integer value) {		
		return value != null ? String.valueOf(value) : null;
	}

	private String DateToString(Date date) {		
		java.util.Date today = new java.util.Date();		
		return date != null ? String.valueOf(date) : String.valueOf(today.getTime());
	}

	private String StringNotNull(char value) {
		return String.valueOf(value);
	}
}