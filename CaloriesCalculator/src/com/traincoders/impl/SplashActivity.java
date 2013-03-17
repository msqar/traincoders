package com.traincoders.impl;

import java.util.Locale;

import android.app.*;
import android.content.*;
import android.content.res.Configuration;
import android.graphics.PixelFormat;
import android.os.*;
import android.preference.PreferenceManager;
import android.view.*;

public class SplashActivity extends Activity{
	
	// used to know if the back button was pressed in the splash screen activity and avoid opening the next activity
    private boolean mIsBackButtonPressed;
    private static final int SPLASH_DURATION = 2000; // 2 seconds
	private SharedPreferences getPrefs;
	private String selectedLanguage;
 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getPrefs = PreferenceManager.getDefaultSharedPreferences(this);
		selectedLanguage = getPrefs.getString("LANGUAGE_KEY", "English");
        String locale = "English".equals(selectedLanguage) ?  "en" : "es";
               
        Locale appLoc = new Locale(locale);
        Locale.setDefault(appLoc);
        Configuration appConfig = new Configuration();
        
        appConfig.locale = appLoc;
        getBaseContext().getResources().updateConfiguration(appConfig,
            getBaseContext().getResources().getDisplayMetrics());
        
        setContentView(R.layout.splash);       
        
        
        
        Handler handler = new Handler();
 
        // run a thread after 2 seconds to start the home screen
        handler.postDelayed(new Runnable() {
 
            @Override
            public void run() {
 
                // make sure we close the splash screen so the user won't come back when it presses back key
 
                finish();
                 
                if (!mIsBackButtonPressed) {
                    // start the home screen if the back button wasn't pressed already 
                	
                    Intent intent = new Intent(SplashActivity.this, MainActivity.class);
                    SplashActivity.this.startActivity(intent);
               }
                 
            }
 
        }, SPLASH_DURATION); // time in milliseconds (1 second = 1000 milliseconds) until the run() method will be called
 
    }
 
    @Override
   public void onBackPressed() {
 
        // set the flag to true so the next activity won't start up
        mIsBackButtonPressed = true;
        super.onBackPressed();
 
    }
    
    @Override
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Window window = getWindow();
        window.setFormat(PixelFormat.RGBA_8888);
    }
}
