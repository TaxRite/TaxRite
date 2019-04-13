package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Locale;


public class TestTaxGUI extends AppCompatActivity {

    public ArrayList<Tax> aList = new ArrayList();
    ListView show;
    Double hour, rate, overtime, taxcredit, healthinsurance, unionsubs;
public static double netTest=0.0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_tax_gui);

        Button butCalc = (Button) findViewById(R.id.btncalculate);



        final RadioButton radWeek = (RadioButton) findViewById(R.id.rbweekly);
        final RadioButton radMonth = (RadioButton) findViewById(R.id.rbmonthly);
        final RadioButton radAnnu = (RadioButton) findViewById(R.id.rbannu);
        final EditText hours1 = (EditText) findViewById(R.id.TFhours);
        final EditText rate1 = (EditText) findViewById(R.id.TFrate);
        final EditText health1 = (EditText) findViewById(R.id.TFhealth);
        final EditText union1 = (EditText) findViewById(R.id.TFunion);
        final EditText taxcredit1 = (EditText) findViewById(R.id.TFtaxcredit);
        final EditText overtime1 = (EditText) findViewById(R.id.TFovertime);


        butCalc.setOnClickListener(new View.OnClickListener() {







                                       Tax p = new Tax();

                                       //TextView result;
                                       @Override
                                       public void onClick(View view) {
                                           if(hours1.getText().toString().equals("")||union1.getText().toString().equals("")||taxcredit1.getText().toString().equals("")||overtime1.getText().toString().equals("")||health1.getText().toString().equals("")||overtime1.getText().toString().equals("")){
                                               Toast.makeText(getApplicationContext(), getString(R.string.fCheck),
                                                       Toast.LENGTH_LONG).show();
                                           }
                                           else {



                                               Double hour = Double.parseDouble(hours1.getText().toString());
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

                                               AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(TestTaxGUI.this);
                                               alertDialogBuilder.setMessage(getString(R.string.ti) + "\n" + getString(R.string.tH) + hour + "\n" + getString(R.string.tRate) + rate + "\n" + getString(R.string.tHea) + health + "\n" + getString(R.string.tUnion) + union + "\n"
                                                       + getString(R.string.tTaxCredit) + taxcredit + "\n" + getString(R.string.tOver) + overtime);
                                               alertDialogBuilder.setTitle(" user financial information ");
                                               AlertDialog alt =alertDialogBuilder.create();
                                               alt.show();
                                               //Toast.makeText(getApplicationContext(), getString(R.string.ti) + "\n" + getString(R.string.tH) + hour + "\n"
                                                              // + getString(R.string.tRate) + rate + "\n" + getString(R.string.tHea) + health + "\n" + getString(R.string.tUnion) + union + "\n"
                                                              // + getString(R.string.tTaxCredit) + taxcredit + "\n" + getString(R.string.tOver) + overtime,
                                               // Toast.LENGTH_LONG).show();

                                               if (radWeek.isChecked()) {


                                                   if (Locale.getDefault().getLanguage().equals("en")) {
                                                       p.weekly();

                                                       Toast.makeText(getApplicationContext(), getString(R.string.tWeekly) + aList.get(aList.size() - 1).weekly(),
                                                               Toast.LENGTH_LONG).show();
                                                   }
                                                   if (Locale.getDefault().getLanguage().equals("fr")) {
                                                       p.weekly();

                                                       Toast.makeText(getApplicationContext(), getString(R.string.tWeekly) + aList.get(aList.size() - 1).weekly(),
                                                               Toast.LENGTH_LONG).show();
                                                   }
                                                   if (Locale.getDefault().getLanguage().equals("es")) {
                                                       p.weekly();

                                                       Toast.makeText(getApplicationContext(), getString(R.string.tWeekly) + aList.get(aList.size() - 1).weekly(),
                                                               Toast.LENGTH_LONG).show();
                                                   }
                                               } else if (radMonth.isChecked()) {
                                                   if (Locale.getDefault().getLanguage().equals("en")) {
                                                       p.weekly();
                                                       p.monthly();
                                                       Toast.makeText(getApplicationContext(), getString(R.string.tMonthly) + aList.get(aList.size() - 1).monthly(),
                                                               Toast.LENGTH_LONG).show();
                                                   }
                                                   if (Locale.getDefault().getLanguage().equals("fr")) {
                                                       p.weekly();
                                                       p.monthly();
                                                       Toast.makeText(getApplicationContext(), getString(R.string.tMonthly) + aList.get(aList.size() - 1).monthly(),
                                                               Toast.LENGTH_LONG).show();
                                                   }
                                                   if (Locale.getDefault().getLanguage().equals("es")) {
                                                       p.weekly();
                                                       p.monthly();
                                                       Toast.makeText(getApplicationContext(), getString(R.string.tMonthly) + aList.get(aList.size() - 1).monthly(),
                                                               Toast.LENGTH_LONG).show();
                                                   }
                                               } else if (radAnnu.isChecked()) {
                                                   if (Locale.getDefault().getLanguage().equals("en")) {
                                                       p.weekly();
                                                       p.monthly();
                                                       p.annual();
                                                       Toast.makeText(getApplicationContext(), getString(R.string.tYearly) + aList.get(aList.size() - 1).annual(),
                                                               Toast.LENGTH_LONG).show();
                                                   }
                                                   if (Locale.getDefault().getLanguage().equals("fr")) {
                                                       p.weekly();
                                                       p.monthly();
                                                       p.annual();
                                                       Toast.makeText(getApplicationContext(), getString(R.string.tYearly) + aList.get(aList.size() - 1).annual(),
                                                               Toast.LENGTH_LONG).show();
                                                   }
                                                   if (Locale.getDefault().getLanguage().equals("es")) {
                                                       p.weekly();
                                                       p.monthly();
                                                       p.annual();
                                                       Toast.makeText(getApplicationContext(), getString(R.string.tYearly) + aList.get(aList.size() - 1).annual(),
                                                               Toast.LENGTH_LONG).show();
                                                   } else {
                                                       Toast.makeText(getApplicationContext(), getString(R.string.tOptions),
                                                               Toast.LENGTH_LONG).show();
                                                   }

                                               }
                                               netTest = p.netpay();


                                               startActivity(new Intent(getApplicationContext(), EntitlementsGUI.class));


                                           }







                                       }
                                   }









        );

    }



}


