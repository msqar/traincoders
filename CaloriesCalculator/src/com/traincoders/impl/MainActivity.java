package com.traincoders.impl;

import android.app.*;
import android.os.*;
import android.preference.PreferenceManager;
import android.widget.*;
import android.widget.TabHost.TabSpec;
import android.content.*;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity
{
	
	private SharedPreferences getPrefs;
	private String selectedLanguage;
	
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	        
	        getPrefs = PreferenceManager.getDefaultSharedPreferences(this);
			selectedLanguage = getPrefs.getString("LANGUAGE_KEY", "English");
	        String calorieName = "English".equals(selectedLanguage) ? "Calories" : "Calorías";
	        String foodName = "English".equals(selectedLanguage) ? "Food Calc" : "Alimentos";
	        String calendarName = "English".equals(selectedLanguage) ? "Calendar" : "Calendario";
	        String profileName = "English".equals(selectedLanguage) ? "Profile" : "Perfíl";
	       
	        TabHost tabHost = getTabHost();
	     
	        Resources res = getResources();
	     
	        TabSpec calspec = tabHost.newTabSpec(calorieName);       
	        calspec.setIndicator("", res.getDrawable((R.drawable.calories_tab_conf)));
	        Intent caloriesIntent = new Intent(this, CaloriesActivity.class);
	        calspec.setContent(caloriesIntent);

	        TabSpec foodspec = tabHost.newTabSpec(foodName);
	        foodspec.setIndicator("", res.getDrawable((R.drawable.foodlist_tab_conf)));
	        Intent foodIntent = new Intent(this, FoodCalculatorActivity.class);
	        foodspec.setContent(foodIntent);
	        
	        TabSpec calendarspec = tabHost.newTabSpec(calendarName);       
	        calendarspec.setIndicator("", res.getDrawable((R.drawable.calendar_tab_conf)));
	        Intent calendarIntent = new Intent(this, CalendarActivity.class);
	        calendarspec.setContent(calendarIntent);
	        
	        TabSpec profilespec = tabHost.newTabSpec(profileName);       
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