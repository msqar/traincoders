package com.traincoders.edb;

import java.util.Date;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class UserEdbHelper extends SQLiteOpenHelper {

    static final String dbName = "edb.db";
    static final String userTable = "user_table";
    private static UserEdbHelper mInstance = null;
    
    /* --- user_table columns --- */
    static final String colID = "user_id";
    static final String colNickname = "nickname";
    static final String colName = "user_name";
    static final String colLastName = "user_lastname";
    static final String colAge = "user_age";
    static final String colWeight = "user_weight";
    static final String colHeight = "user_height";
    static final String colGender = "user_gender";

    public UserEdbHelper(Context context) {
    	super(context, dbName, null, 33);
    }
    
    public static UserEdbHelper getInstance(Context ctx) {
    	if (mInstance == null) {
            mInstance = new UserEdbHelper(ctx.getApplicationContext());
        }
        return mInstance;
    }
    
    @Override
    public void onCreate(SQLiteDatabase db) {
    	// Create user_table
    	db.execSQL("CREATE TABLE " + userTable + "("+ colID + " INTEGER PRIMARY KEY, " +
    			colNickname + " TEXT NOT NULL, " + colName + " TEXT, " + colLastName + " TEXT, " +
    			colAge + " INTEGER NOT NULL, " + colWeight + " REAL NOT NULL, " + colHeight + " REAL NOT NULL, " +
    			colGender +	" TEXT NOT NULL)");
    }    
    
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) { 
    	db.execSQL("DROP TABLE IF EXISTS " + userTable);
    	onCreate(db);
    }    
    
    public void insertUserRow(SQLiteDatabase db, EdbUser user) {
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
    	cv.put("amount_consumed", user.getAmountConsumed());
    	db.insert(userTable, colID, cv);
    }
    
    public void queryUser(SQLiteDatabase db, EdbUser user) {
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
    	cv.put("amount_consumed", user.getAmountConsumed());

    	Cursor r1 = db.rawQuery("", null);
    	
    }
    
	private String DateToString(Date date) {		
		java.util.Date today = new java.util.Date();		
		return date != null ? String.valueOf(date) : String.valueOf(today.getTime());
	}

	private String StringNotNull(char value) {
		return String.valueOf(value);
	}
}