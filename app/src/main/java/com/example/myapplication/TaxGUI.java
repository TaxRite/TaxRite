package com.example.myapplication;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.Toast;
import android.app.Activity;
import android.util.Log;
import android.widget.TextView;
import java.util.ArrayList;
import java.util.List;

public class TaxGUI extends AppCompatActivity {

ArrayList<Tax> aList = new ArrayList<Tax>();
ListView show;
Double hour,rate,overtime,taxcredit,healthinsurance,unionsubs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tax_gui);

//show= (ListView)findViewById(R.id.listView);

        final CheckBox c1 = (CheckBox)findViewById(R.id.weekly);
        final CheckBox c2 = (CheckBox)findViewById(R.id.monthly);
        final CheckBox c3 = (CheckBox)findViewById(R.id.annually);
        final Button calculate= (Button)findViewById(R.id.Calculate);
        final EditText hours1= (EditText)findViewById(R.id.TFhours);
        final EditText rate1= (EditText)findViewById(R.id.TFrate);
        final EditText health1= (EditText)findViewById(R.id.TFhealth);
        final EditText union1= (EditText)findViewById(R.id.TFunion);
        final EditText taxcredit1= (EditText)findViewById(R.id.TFtaxcredit);
        final EditText overtime1= (EditText)findViewById(R.id.TFovertime);


        calculate.setOnClickListener(new View.OnClickListener()
        {
            Tax p= new Tax();

            TextView result;

            @Override

            public void onClick(View view)
                    {
                        Double  hour = Double.parseDouble(hours1.getText().toString());
                        Double rate = Double.parseDouble(rate1.getText().toString());
                        Double health = Double.parseDouble(health1.getText().toString());
                        Double union = Double.parseDouble(union1.getText().toString());
                        Double taxcredit = Double.parseDouble(taxcredit1.getText().toString());
                        Double overtime = Double.parseDouble(overtime1.getText().toString());

                        p.setHours(hour);
                        p.setRate(rate);
                        p.setTaxCredit(taxcredit);
                        p.setOverTime(overtime);
                        aList.add(p);

                        Toast.makeText(getApplicationContext(), "the information you added are :  hours"+hour+"\n"+"rate"+rate+"\n"+"Health Insurance"+health+"\n"+"Union Subs"+union+"\n"+"Tax Credit"+taxcredit+"\n"+"Overtime"+overtime,



                            Toast.LENGTH_LONG).show();

                        if(c1.isChecked()){

                        Toast.makeText(getApplicationContext(), "weekly"+p.weekly(),
                                Toast.LENGTH_LONG).show();
                    }
                        if(c2.isChecked()){
                            p.weekly();
                            Toast.makeText(getApplicationContext(), "monthly"+p.monthly(),
                                    Toast.LENGTH_LONG).show();
                        }
                        if(c3.isChecked()){
                            p.weekly();
                            p.monthly();
                            Toast.makeText(getApplicationContext(), "annually"+p.annual(),
                                    Toast.LENGTH_LONG).show();
                        }
                        //String hours = hours1.getText().toString();
                        //result.setText("Name:\t" + hours );
                        startActivity(new Intent(getApplicationContext(),RebateGUI.class));
                    }
                }


                );







    }
}
