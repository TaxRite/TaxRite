package com.example.myapplication;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        loadLocale();
        setContentView(R.layout.activity_main);

        //Change language of Action Bar
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle(getResources().getString(R.string.app_name));

        //open form activity
        Button btn1=(Button)findViewById(R.id.btn_start);
        btn1.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                startActivity(new Intent(getApplicationContext(),TestTaxGUI.class));
           /* if you want to finish the first activity then just call
            finish(); */
            }
        });

        // button to change the language
        Button changeLang = findViewById(R.id.changeMyLang);
        changeLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //show the alert dialog
                showChangeLanguageDialog();
            }
        });
    }

    private void showChangeLanguageDialog() {
        //Array to show languages
        final String[] listItems = {"English" , "Français", "Español"};
        AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
        mBuilder.setTitle("Choose Language ...");
        mBuilder.setSingleChoiceItems(listItems, -1, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialoginterface, int i) {
                if (i == 0){
                    // English
                    setLocale("en");
                    recreate();
                }
                else if (i == 1){
                    // French
                    setLocale("fr");
                    recreate();
                }
                else if (i == 2){
                    // Spanish
                    setLocale("es");
                    recreate();
                }
                
                //Dismiss alert box when language is selected
                dialoginterface.dismiss();
            }
        });

        AlertDialog mDialog = mBuilder.create();
        //Show the alert dialog
        mDialog.show();
    }

    private void setLocale(String lang) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
        //save data to shared preferences
        SharedPreferences.Editor editor = getSharedPreferences("Settings", MODE_PRIVATE).edit();
        editor.putString("My Lang", lang);
        editor.apply();
    }

    //  Load language saved in shared preferences
    public void loadLocale(){
        SharedPreferences prefs = getSharedPreferences("Settings", Activity.MODE_PRIVATE);
        String language = prefs.getString("My Lang", "");
        setLocale(language);
    }

}
