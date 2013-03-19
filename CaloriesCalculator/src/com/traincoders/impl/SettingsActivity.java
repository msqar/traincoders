package com.traincoders.impl;

import com.traincoders.impl.R;

import android.os.*;
import android.preference.*;
import android.preference.Preference.OnPreferenceClickListener;


public class SettingsActivity extends PreferenceActivity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState){
		super.onCreate(savedInstanceState);
		getFragmentManager().beginTransaction().replace(android.R.id.content, new MyPreferenceFragment()).commit();
	}
	
	 public static class MyPreferenceFragment extends PreferenceFragment
    {
        @Override
        public void onCreate(final Bundle savedInstanceState){
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.prefs);
            
            Preference myPref = (Preference) findPreference("ABOUT_KEY");
            myPref.setOnPreferenceClickListener(new OnPreferenceClickListener() {
                 public boolean onPreferenceClick(Preference preference) {
                	 	AboutDialog newFragment = new AboutDialog();
                	    newFragment.show(getFragmentManager(), "About");
						return false;
                 }
            });

        }
    }	 
}
