package com.traincoders.impl;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

public class FoodCalculatorActivity extends Activity {
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.percentile_layout);
        displayVersionName();        
    }
    
    public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.menu, menu);
		return true;
	}
	
	public boolean onOptionsItemSelected(MenuItem item){
		switch(item.getItemId()){
			case R.id.settings_title:
			   startActivity(new Intent(this, SettingsActivity.class));
			   return true;
			case R.id.exit_title:
				finish();
			   return true;
		}
		return false;
	}
	
	private void displayVersionName() {
	    String versionName = "";
	    PackageInfo packageInfo;
	    try {
	        packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
	        versionName = "v " + packageInfo.versionName;
	    } catch (NameNotFoundException e) {
	        e.printStackTrace();
	    }
	    TextView tv = (TextView) findViewById(R.id.app_version);
	    tv.setText(versionName);
	}
}