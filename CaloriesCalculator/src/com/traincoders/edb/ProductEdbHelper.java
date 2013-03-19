package com.traincoders.edb;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ProductEdbHelper extends SQLiteOpenHelper {
	
	static final String dbName = "edb";
	static final String productTable = "prod_table";
	
	static final String colProdID = "prod_id";
	static final String colProdName = "prod_name";
    static final String colProdCompany = "prod_company";
    static final String colProdType = "prod_type";
    static final String colProdSubType = "prod_subtype";
    static final String colProdCalories = "prod_calories";
    static final String colProdKJoules = "prod_kjoules"; // 1 kcal =  4184 joules
    static final String colProdCaloriesFromFat = "prod_cal_from_fat";
    
    public ProductEdbHelper(Context context) {
    	super(context, dbName, null, 33);
    }
    
    public void onCreate(SQLiteDatabase db) {
    	// Create prod_table
    	db.execSQL("CREATE TABLE " + productTable + "(" + colProdID + " INTEGER PRIMARY KEY, " + 
    			colProdName + " TEXT NOT NULL, " + colProdCompany + " TEXT, " + colProdType + " TEXT NOT NULL, " +
    			colProdSubType + " TEXT, " + colProdCalories + " INTEGER NOT NULL, " + colProdKJoules + " INTEGER, " +
    			colProdCaloriesFromFat + " INTEGER)");
    }    
    
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    	db.execSQL("DROP TABLE IF EXISTS " + productTable);
    	onCreate(db);
    }
    
    
    public void populateProductTable(SQLiteDatabase db) {

    }

}
