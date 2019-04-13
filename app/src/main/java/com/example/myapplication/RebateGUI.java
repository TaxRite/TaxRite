package com.example.myapplication;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

public class RebateGUI extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rebate_gui);

        //open form activity
       final CheckBox c1 = (CheckBox)findViewById(R.id.chk1);
       final CheckBox c2 = (CheckBox)findViewById(R.id.chk2);
       final CheckBox c3 = (CheckBox)findViewById(R.id.chk3);
       final CheckBox c4 = (CheckBox)findViewById(R.id.chk4);
       final CheckBox c5 = (CheckBox)findViewById(R.id.chk5);
        Button btnDone = (Button)findViewById(R.id.btndone);
        btnDone.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                if(c1.isChecked()||c2.isChecked()||c3.isChecked()||c4.isChecked()||c5.isChecked()){
                        Toast.makeText(getApplicationContext(), getString(R.string.rMsg1),
                                Toast.LENGTH_LONG).show();
                }
                else{
                    for (int i=0; i < 2; i++) {
                        Toast.makeText(getApplicationContext(), getString(R.string.rMsg2),
                                Toast.LENGTH_LONG).show();
                    }
                }

                startActivity(new Intent(getApplicationContext(),FormGUI.class));
            }
        });
    }
}
