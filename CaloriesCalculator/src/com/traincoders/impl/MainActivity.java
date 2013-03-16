package com.traincoders.impl;

import android.app.*;
import android.os.*;
import android.widget.*;
import android.widget.TabHost.TabSpec;
import android.content.*;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity
{
	 @Override
	    public void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        setContentView(R.layout.main);
	 
	        TabHost tabHost = getTabHost();

	        TabSpec calspec = tabHost.newTabSpec("Calories");
	        // setting Title and Icon for the Tab
	        
	        calspec.setIndicator("Calories");
	        Intent caloriesIntent = new Intent(this, CaloriesActivity.class);
	        calspec.setContent(caloriesIntent);

	        TabSpec percspec = tabHost.newTabSpec("Percentile");
	        percspec.setIndicator("Percentile");
	        Intent percentileIntent = new Intent(this, PercentileActivity.class);
	        percspec.setContent(percentileIntent);
	 
	        // Adding all TabSpec to TabHost
	        tabHost.addTab(calspec); // Adding calories tab
	        tabHost.addTab(percspec); // Adding percentiles tab
	    }
}