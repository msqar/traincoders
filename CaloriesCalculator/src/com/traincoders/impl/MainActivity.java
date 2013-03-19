package com.traincoders.impl;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.widget.TabHost.TabSpec;
import android.content.*;
import android.content.res.Resources;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity
{	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	       
	        TabHost tabHost = getTabHost();	     
	        Resources res = getResources();	     
	        TabSpec calspec = tabHost.newTabSpec("Calories");       
	        calspec.setIndicator("", res.getDrawable((R.drawable.calories_tab_conf)));
	        Intent caloriesIntent = new Intent(this, CaloriesActivity.class);
	        calspec.setContent(caloriesIntent);

	        TabSpec foodspec = tabHost.newTabSpec("Food Calc");
	        foodspec.setIndicator("", res.getDrawable((R.drawable.foodlist_tab_conf)));
	        Intent foodIntent = new Intent(this, FoodCalculatorActivity.class);
	        foodspec.setContent(foodIntent);
	        
	        TabSpec calendarspec = tabHost.newTabSpec("Calendar");       
	        calendarspec.setIndicator("", res.getDrawable((R.drawable.calendar_tab_conf)));
	        Intent calendarIntent = new Intent(this, CalendarActivity.class);
	        calendarspec.setContent(calendarIntent);
	        
	        TabSpec profilespec = tabHost.newTabSpec("Profile");       
	        profilespec.setIndicator("", res.getDrawable((R.drawable.profile_tab_conf)));
	        Intent profileIntent = new Intent(this, ProfileActivity.class);
	        profilespec.setContent(profileIntent);
	 
	        // Adding all TabSpec to TabHost
	        tabHost.addTab(profilespec); // Adding profile tab
	        tabHost.addTab(calspec); // Adding calories tab
	        tabHost.addTab(foodspec); // Adding food calc tab
	        tabHost.addTab(calendarspec); // Adding calendar tab	        
	    }
}