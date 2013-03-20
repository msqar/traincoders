package com.traincoders.edb;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class AppCore extends Application{
	
    public static UserEdbHelper userHelper;
    public static ProductEdbHelper productHelper;
    
    public static void init(Context context )
    {
        userHelper = new UserEdbHelper(context);
        productHelper = new ProductEdbHelper(context);
    }

    public static SQLiteDatabase getUserDb(Context ctx) {
        if (null == userHelper) { userHelper = new UserEdbHelper(ctx); }
        return userHelper.getWritableDatabase();
    }

    public static SQLiteDatabase getProductDb(Context ctx) {
        if (null == productHelper) { productHelper = new ProductEdbHelper(ctx); }
        return productHelper.getWritableDatabase();
    }
}
