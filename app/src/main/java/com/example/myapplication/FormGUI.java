package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class FormGUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_gui);

        //method to verify are all of the fields populated
        //method to verify if the emails are the same
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

        buttonSubmit.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View arg0)
                    {
                        if(nameInput.getText().toString().equals("")||surnnameInput.getText().toString().equals("")||phoneInput.getText().toString().equals("")||add1Input.getText().toString().equals("")||add2Input.getText().toString().equals("")||add3Input.getText().toString().equals("")||msgInput.getText().toString().equals("")){
                             Toast.makeText(getApplicationContext(), "Please check all fields",
                             Toast.LENGTH_LONG).show();
                        }
                        else{
                            if(emailOne.getText().toString().equals(emailTwo.getText().toString())){
                                Toast.makeText(getApplicationContext(), "Thank you. Your info has been submitted. One of our team members will be in touch with you shortly.",
                                Toast.LENGTH_LONG).show();
                            }
                            else{
                                Toast.makeText(getApplicationContext(), "Email does not match!",
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    }
                });

    }
}
