package com.example.myapplication;
import android.app.Activity;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.util.Log;

import java.util.List;

public class SendMailTask extends AsyncTask{
    private ProgressDialog statusDialog;
    private Activity sendMailActivity;

    public SendMailTask(Activity activity) {
        sendMailActivity = activity;
    }
    //method for progress in dialog box
    protected void onPreExecute() {
        statusDialog = new ProgressDialog(sendMailActivity);
        statusDialog.setMessage("Getting ready...");
        statusDialog.setIndeterminate(false);
        statusDialog.setCancelable(false);
        statusDialog.show();
    }
    //method for creating and sending email
    @Override
    protected Object doInBackground(Object... args) {
        try {
            Log.i("SendMailTask", "Getting your email ready...");
            publishProgress("Processing information....");
            GMail androidEmail = new GMail(args[0].toString(),
                    args[1].toString(), (List) args[2], args[3].toString(),
                    args[4].toString());
            publishProgress("Preparing your details....");
            androidEmail.createEmailMessage();
            publishProgress("Sending details....");
            androidEmail.sendEmail();
            publishProgress("Details Sent.");
            Log.i("SendMailTask", "Details Sent.");
        } catch (Exception e) {
            publishProgress(e.getMessage());
            Log.e("SendMailTask", e.getMessage(), e);
        }
        return null;
    }
    //method for setting dialog messages
    @Override
    public void onProgressUpdate(Object... values) {
        statusDialog.setMessage(values[0].toString());
    }
    //method for closing the dialog box for progress
    @Override
    public void onPostExecute(Object result) {
        statusDialog.dismiss();
    }
}
