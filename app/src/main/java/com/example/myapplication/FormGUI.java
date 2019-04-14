package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

public class FormGUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_gui);

        final EditText emailOne= (EditText)findViewById(R.id.txtemail);
        final EditText emailTwo= (EditText)findViewById(R.id.txtemail2);
        final Button buttonSubmit= (Button)findViewById(R.id.btnsubmit);
        final EditText nameInput = (EditText)findViewById(R.id.txtname);
        final EditText surnnameInput = (EditText)findViewById(R.id.txtsurname);
        final EditText phoneInput = (EditText)findViewById(R.id.txtphone);
        final EditText add1Input = (EditText)findViewById(R.id.txtaddress1);
        final EditText add2Input = (EditText)findViewById(R.id.txtaddress2);
        final EditText add3Input = (EditText)findViewById(R.id.txtaddress3);
        final EditText msgInput = (EditText)findViewById(R.id.txtmessage);
        final String password = "userrequest2019";
        final String sendemail1 = "NewTaxRiteRequest@gmail.com";
        final String recemail = "TaxRiteIreland@gmail.com";
        final boolean conn2int;
        //method for checking active internet connection
        //final boolean conn2int = false;
        ConnectivityManager connectivityManager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        if(connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_MOBILE).getState() == NetworkInfo.State.CONNECTED ||
                connectivityManager.getNetworkInfo(ConnectivityManager.TYPE_WIFI).getState() == NetworkInfo.State.CONNECTED) {
            //we are connected to a network
            conn2int = true;
        }
        else {
            conn2int = false;
            Toast.makeText(getApplicationContext(), (getString(R.string.fInternet1)),
                    Toast.LENGTH_LONG).show();
        }
        buttonSubmit.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View arg0)
                    {//method for checking are all field populated
                        if(nameInput.getText().toString().equals("")||surnnameInput.getText().toString().equals("")||phoneInput.getText().toString().equals("")||add1Input.getText().toString().equals("")||add2Input.getText().toString().equals("")||add3Input.getText().toString().equals("")||msgInput.getText().toString().equals("")){
                             Toast.makeText(getApplicationContext(), getString(R.string.fCheck),
                             Toast.LENGTH_LONG).show();
                        }
                        else if(conn2int!=true){//method for checking internet connection
                            Toast.makeText(getApplicationContext(), getString(R.string.fINet),
                                    Toast.LENGTH_LONG).show();
                        }
                        else{//method for forwarding details to email
                            if(emailOne.getText().toString().equals(emailTwo.getText().toString())){
                                Log.i("SendMailActivity", "Send Button Clicked.");
                                //declaration of sending, receiving email and password
                                String fromEmail = sendemail1;
                                String fromPassword = password;
                                String toEmails = recemail;
                                List<String> toEmailList = Arrays.asList(toEmails.split("\\s*,\\s*")); //list of recipients
                                Log.i("SendMailActivity", "To List: " + toEmailList);
                                String emailSubject = ((TextView) findViewById(R.id.txtname)).getText().toString()+" "+((EditText) findViewById(R.id.txtsurname)).getText().toString();
                                String emailPhone = ((EditText) findViewById(R.id.txtphone)).getText().toString();
                                String emailEmail = ((EditText) findViewById(R.id.txtemail)).getText().toString();
                                String emailAddress1 = ((EditText) findViewById(R.id.txtaddress1)).getText().toString();
                                String emailAddress2 = ((EditText) findViewById(R.id.txtaddress2)).getText().toString();
                                String emailAddress3 = ((EditText) findViewById(R.id.txtaddress3)).getText().toString();
                                String emailBody = "Customer's phone number: "+((EditText) findViewById(R.id.txtphone)).getText().toString()+"\n"+
                                        "Customer's email address: "+((EditText) findViewById(R.id.txtemail)).getText().toString()+"\n"+
                                        "Customer's address: "+((EditText) findViewById(R.id.txtaddress1)).getText().toString()+"\n"+((EditText) findViewById(R.id.txtaddress2)).getText().toString()+"\n"+
                                        ((EditText) findViewById(R.id.txtaddress3)).getText().toString()+"\n"+
                                        "Customer's message: "+((TextView) findViewById(R.id.txtmessage)).getText().toString();
                                new SendMailTask(FormGUI.this).execute(fromEmail, fromPassword, toEmailList, emailSubject, emailBody, emailPhone, emailEmail, emailAddress1, emailAddress2, emailAddress3); //sends the email with entered details
                                startActivity(new Intent(getApplicationContext(),EndGUI.class)); //opens next activity
                            }
                            else{//method for checking the email inputs
                                Toast.makeText(getApplicationContext(), getString(R.string.fNotMatch),
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });
    }
}
