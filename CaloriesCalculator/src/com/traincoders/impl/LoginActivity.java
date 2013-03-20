package com.traincoders.impl;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

public class LoginActivity extends Activity {
	
	private Button btnLogin;
	private Button btnCreate;
	private Button btnConfirmCreate;
	
	private LinearLayout createUserForm;
	private LinearLayout accessUserForm;
	
	private int createVisible = View.GONE;
	private int accessVisible = View.GONE;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {		
		super.onCreate(savedInstanceState);        
		setContentView(R.layout.login_layout);  	
		initializeElements();
		
		btnLogin.setOnClickListener(new Button
			    .OnClickListener(){

					public void onClick(View v)
					{
						if(accessVisible == View.GONE)
				        {
							accessVisible = View.VISIBLE;
				        }			     
						
						if(createVisible == View.VISIBLE){
							createVisible = View.GONE;
						}
						accessUserForm.setVisibility(accessVisible);
						createUserForm.setVisibility(createVisible);
					}
					
		});
		
		btnCreate.setOnClickListener(new Button
			    .OnClickListener(){

					public void onClick(View v)
					{
						if(createVisible == View.GONE)
				        {
							createVisible = View.VISIBLE;
				        }			     
						
						if(accessVisible == View.VISIBLE){
							accessVisible = View.GONE;
						}
						accessUserForm.setVisibility(accessVisible);
						createUserForm.setVisibility(createVisible);
					}
					
		});
		
		btnConfirmCreate.setOnClickListener(new Button
			    .OnClickListener(){

					public void onClick(View v)
					{
						
					}
					
		});	
		
	}

	private void initializeElements() {
		btnLogin = (Button) findViewById(R.id.btnAccessUser);
		btnCreate = (Button) findViewById(R.id.btnCreateNewUser);
		btnConfirmCreate = (Button) findViewById(R.id.btnConfirmCreateUser);
		
		createUserForm = (LinearLayout) findViewById(R.id.create_user_form);
		accessUserForm = (LinearLayout) findViewById(R.id.access_user_form);
	}

	@Override
	public void onBackPressed() {
		super.onBackPressed();
		this.finish();
	}
	
	

}
