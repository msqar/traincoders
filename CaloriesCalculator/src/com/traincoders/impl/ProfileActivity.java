package com.traincoders.impl;

import android.app.Activity;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.widget.TextView;

public class ProfileActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);
        setContentView(R.layout.foodlist_layout);
        displayVersionName();   
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

