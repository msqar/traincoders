package com.traincoders.impl;

import com.traincoders.utils.CalcUtils;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

public class CaloriesActivity extends Activity {
	
	private EditText tWeight, tHeight, tAge;
	private TextView measureWeight, measureHeight;
	private Spinner tGender;
	private Button btnCalc;
	private TextView loss, gain, maintain;
	private SharedPreferences getPrefs;
	private String selectedMeasure;
	private String selectedLanguage;
	
	private LinearLayout resultLayout;
	private int resultVisible = View.INVISIBLE;
	
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calories_layout);
		initializeAttributes();		
		
		btnCalc.setOnClickListener(new Button
		    .OnClickListener(){

				public void onClick(View v)
				{
					if(validateInputs()){
						String gender = (String) 
						        tGender.getSelectedItem();
						float total = 0.0f;
						String newHeight = "";
						String newWeight = "";
						if(CalcUtils.CMKG_MEASURE_EN.equals(selectedMeasure) || CalcUtils.CMKG_MEASURE_ES.equals(selectedMeasure)) {
							newHeight = CalcUtils.convertCentimeterToInches(tHeight.getText().toString());
							newWeight = CalcUtils.convertKilogramsToPounds(tWeight.getText().toString());
						}else{
							newHeight = tHeight.getText().toString();
							newWeight = tWeight.getText().toString();
						}
						
						if(CalcUtils.MALE_EN.equals(gender) || CalcUtils.MALE_ES.equals(gender)){
							total = 66f + (6.23f * Float.valueOf(newWeight)
							        + (12.7f * Float.valueOf(newHeight)
									- (6.8f * Float.valueOf(tAge.getText().toString()))));
						}else if(CalcUtils.FEMALE_EN.equals(gender) || CalcUtils.FEMALE_ES.equals(gender)){
								total = 655f + (4.35f * Float.valueOf(newWeight)
							        + (4.7f * Float.valueOf(newHeight))
									- (4.7f * Float.valueOf(tAge.getText().toString())));
						}											
						printResults(total);
						v.invalidate();						
					}
				}

			private void printResults(float total)
				{					
				
					float calcGainFrom = total + 250f;
					float calcGainTo = total + 300f;
					float calcLoss = total - 500f;
					
					if("English".equals(selectedLanguage)) {
						gain.setText("From " + String.format("%.0f", calcGainFrom) + " to " + 
								String.format("%.0f", calcGainTo) + " calories per day."); 
						loss.setText("About " + String.format("%.0f", calcLoss) + " calories per day."); 
						maintain.setText("Around " + String.format("%.0f", total) + " calories per day.");						
					}else{
						gain.setText("Desde " + String.format("%.0f", calcGainFrom) + " a " + 
								String.format("%.0f", calcGainTo) + " calor�as por d�a."); 
						loss.setText("Desde " + String.format("%.0f", calcLoss) + " calor�as por d�a."); 
						maintain.setText("Alrededor de " + String.format("%.0f", total) + " calor�as por d�a.");	
					}
					
					if(resultVisible == View.INVISIBLE)
			        {
						resultVisible = View.VISIBLE;
			        }			     
					resultLayout.setVisibility(resultVisible);
					
				}

				private boolean validateInputs()
				{
					boolean success = true;
					if(tWeight.getText() == null || tWeight.getText().toString().length() == 0){
						if("English".equals(selectedLanguage)) {
							tWeight.setError(CalcUtils.WEIGHT_REQ_ERROR_EN);
						}else{
							tWeight.setError(CalcUtils.WEIGHT_REQ_ERROR_ES);
						}						
						success=false;
					}

					if(tHeight.getText() == null || tHeight.getText().toString().length() == 0){
						if("English".equals(selectedLanguage)) {
							tWeight.setError(CalcUtils.HEIGHT_REQ_ERROR_EN);
						}else{
							tWeight.setError(CalcUtils.HEIGHT_REQ_ERROR_ES);
						}		
						success=false;
					}
					if(tAge.getText() == null || tAge.getText().toString().length() == 0){
						if("English".equals(selectedLanguage)) {
							tAge.setError(CalcUtils.AGE_REQ_ERROR_EN);
						}else{
							tAge.setError(CalcUtils.AGE_REQ_ERROR_ES);
						}	
						success=false;
					}
					return success;
				}
        });
	}
    
    
	@Override
	protected void onResume() {
		super.onResume();
		getPrefs = PreferenceManager.getDefaultSharedPreferences(this);
		selectedLanguage = getPrefs.getString("LANGUAGE_KEY", "English");
		if("English".equals(selectedLanguage)) {
			selectedMeasure = getPrefs.getString("MEASURE_KEY", "Inches-Pounds");
		}else{
			selectedMeasure = getPrefs.getString("MEASURE_KEY", "Pulgadas-Libras");
		}	
		
	    String[] splitMeasure = selectedMeasure.split("\\-");
	    measureWeight.setText(splitMeasure[1]);
	    measureHeight.setText(splitMeasure[0]);		
	    measureWeight.setTextAppearance(getApplicationContext(), R.style.boldText);
	    measureHeight.setTextAppearance(getApplicationContext(), R.style.boldText);
	}

	protected void initializeAttributes()
	{
	    tWeight = (EditText) findViewById(R.id.tWeight);
	    tHeight = (EditText)  findViewById(R.id.tHeight);
		tAge = (EditText)  findViewById(R.id.tAge);
		tGender = (Spinner)  findViewById(R.id.tGender);
		btnCalc = (Button) findViewById(R.id.btnCalculate);
		loss = (TextView) findViewById(R.id.loss_title);
		gain = (TextView) findViewById(R.id.gain_title);
		maintain = (TextView) findViewById(R.id.maintain_title);
		measureWeight = (TextView) findViewById(R.id.measureWeight);
		measureHeight = (TextView) findViewById(R.id.measureHeight);
		resultLayout = (LinearLayout) findViewById(R.id.results_layout);
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
	
//	private void displayVersionName() {
//	    String versionName = "";
//	    PackageInfo packageInfo;
//	    try {
//	        packageInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
//	        versionName = "v " + packageInfo.versionName;
//	    } catch (NameNotFoundException e) {
//	        e.printStackTrace();
//	    }
//	    TextView tv = (TextView) findViewById(R.id.app_version);
//	    tv.setText(versionName);
//	}
}
