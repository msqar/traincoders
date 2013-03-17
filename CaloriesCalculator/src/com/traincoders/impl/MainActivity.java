package com.traincoders.impl;

import android.app.*;
import android.os.*;
import android.preference.PreferenceManager;
import android.widget.*;
import android.widget.TabHost.TabSpec;
import android.content.*;

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
	        String percentileName = "English".equals(selectedLanguage) ? "Percentile" : "Percentilo";
	       
	        TabHost tabHost = getTabHost();

	        TabSpec calspec = tabHost.newTabSpec(calorieName);       
	        calspec.setIndicator(calorieName);
	        Intent caloriesIntent = new Intent(this, CaloriesActivity.class);
	        calspec.setContent(caloriesIntent);

	        TabSpec percspec = tabHost.newTabSpec(percentileName);
	        percspec.setIndicator(percentileName);
	        Intent percentileIntent = new Intent(this, PercentileActivity.class);
	        percspec.setContent(percentileIntent);
	 
	        // Adding all TabSpec to TabHost
	        tabHost.addTab(calspec); // Adding calories tab
	        tabHost.addTab(percspec); // Adding percentiles tab
	    }
}