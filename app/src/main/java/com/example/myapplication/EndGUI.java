package com.example.myapplication;

import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EndGUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_gui);
        //method to close the application
        Button btnF = (Button)findViewById(R.id.btnfinished);
        btnF.setOnClickListener(
                new View.OnClickListener() {
                    public void onClick(View arg0) {
                        ActivityCompat.finishAffinity(EndGUI.this);
                    }
                });}
};
