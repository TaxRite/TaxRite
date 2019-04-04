package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

public class LanguageGUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_gui);

        ImageButton btneng = (ImageButton)findViewById(R.id.btnenglish);
        ImageButton btnspa = (ImageButton)findViewById(R.id.btnspanish);
        ImageButton btnfre = (ImageButton)findViewById(R.id.btnfrench);

        btneng.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View arg0)
                    {startActivity(new Intent(getApplicationContext(),TestTaxGUI.class));

                    }});

        btnspa.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View arg0)
                    {
                        startActivity(new Intent(getApplicationContext(),TestTaxGUI.class));
                    }});

        btnfre.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View arg0)
                    {
                        startActivity(new Intent(getApplicationContext(),TestTaxGUI.class));
                    }});
    }
}
