package com.traincoders.tasks;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

public class CreateUserAsyncTask extends AsyncTask<Void, Void, Integer>{

	private ProgressDialog _dialog;
	
	public CreateUserAsyncTask(Context ctx) {
		_dialog = new ProgressDialog(ctx);
	}

    @Override
    protected void onPreExecute()
    {
    	_dialog.setMessage("Doing something...");
    	_dialog.show();
    }

    @Override
    protected Integer doInBackground(Void... params) 
    {
        //Task for doing something 

        return 0;
    }

    protected void onPostExecute(Integer result)
    {

        if(result==0)
        {
             //do some thing
        }
        // after completed finished the progressbar
        _dialog.dismiss();
    }
}
