package com.traincoders.impl;

import com.traincoders.impl.R;

import android.os.*;
import android.preference.*;

public class SettingsActivity extends PreferenceActivity
	{
		@Override
		protected void onCreate(Bundle savedInstanceState)
			{
				super.onCreate(savedInstanceState);
				addPreferencesFromResource(R.xml.prefs);
			}
	}
