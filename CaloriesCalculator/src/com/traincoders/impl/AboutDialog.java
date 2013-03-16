package com.traincoders.impl;


import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;


public class AboutDialog extends DialogFragment {
	
	@Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        
        builder.setTitle(R.string.title_about);
        builder.setMessage(R.string.about_message)
               .setPositiveButton(R.string.btn_accept, new DialogInterface.OnClickListener() {
                   public void onClick(DialogInterface dialog, int id) {
                	   dialog.dismiss();
                   }
               });
//               .setNegativeButton(R.string.btn_cancel, new DialogInterface.OnClickListener() {
//                   public void onClick(DialogInterface dialog, int id) {
//                	   dialog.dismiss();
//                   }
//               });
        // Create the AlertDialog object and return it
        return builder.create();
    }

}
