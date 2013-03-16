package com.traincoders.impl;

import android.app.*;
import android.os.*;
import android.preference.PreferenceManager;
import android.view.*;
import android.widget.*;
import android.content.*;

public class MainActivity extends Activity
{
	private EditText tWeight, tHeight, tAge;
	private TextView measureWeight, measureHeight;
	private Spinner tGender;
	private Button btnCalc;
	private TextView loss, gain, maintain;
	private SharedPreferences getPrefs;
	private String selectedMeasure;
	
    @Override
    public void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
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
						if("Centimeters-Kilograms".equals(selectedMeasure)) {
							newHeight = CalcUtils.convertCentimeterToInches(tHeight.getText().toString());
							newWeight = CalcUtils.convertKilogramsToPounds(tWeight.getText().toString());
						}else{
							newHeight = tHeight.getText().toString();
							newWeight = tWeight.getText().toString();
						}
						
						if(CalcUtils.MALE.equals(gender)){
							total = 66f + (6.23f * Float.valueOf(newWeight)
							        + (12.7f * Float.valueOf(newHeight)
									- (6.8f * Float.valueOf(tAge.getText().toString()))));
						}else if(CalcUtils.FEMALE.equals(gender)){
								total = 655f + (4.35f * Float.valueOf(newWeight)
							        + (4.7f * Float.valueOf(newHeight))
									- (4.7f * Float.valueOf(tAge.getText().toString())));
						}
						
						printResults(total);
					}
				}

			private void printResults(float total)
				{
					float calcGainFrom = total + 250f;
					float calcGainTo = total + 300f;

					gain.setText("From " + String.format("%.0f", calcGainFrom) + " to " + 
								 String.format("%.0f", calcGainTo) + " calories per day."); 
				
					float calcLoss = total - 500f;
					loss.setText("About " + String.format("%.0f", calcLoss) + " calories per day."); 
					
					maintain.setText("Around " + String.format("%.0f", total) + " calories per day.");
				}

				private boolean validateInputs()
				{
					boolean success = true;
					if(tWeight.getText() == null || tWeight.getText().toString().length() == 0){
						tWeight.setError("Weight is required");
						success=false;
					}

					if(tHeight.getText() == null || tHeight.getText().toString().length() == 0){
						tHeight.setError("Height is required");
						success=false;
					}
					if(tAge.getText() == null || tAge.getText().toString().length() == 0){
						tAge.setError("Age is required");
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
		selectedMeasure = getPrefs.getString("MEASURE_KEY", "Inches-Pounds");
		
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
}
