package com.traincoders.impl;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;

public class SplashActivity extends Activity{
	
		private Thread mSplashThread;
		
		@Override
		public void onCreate(Bundle savedInstanceState){
				super.onCreate(savedInstanceState);  
				setContentView(R.layout.splash);
		}
}
