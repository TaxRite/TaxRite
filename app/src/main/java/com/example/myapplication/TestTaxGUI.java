package com.example.myapplication;

import android.content.DialogInterface;
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
        Button butEntitle = (Button) findViewById(R.id.btnEntitle);




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



                                               if (radWeek.isChecked()) {


                                                   if (Locale.getDefault().getLanguage().equals("en")) {
                                                       p.weekly();
                                                       AlertDialog.Builder x = new AlertDialog.Builder(TestTaxGUI.this);
                                                       x.setMessage(  aList.get(aList.size() - 1).weekly());
                                                       x.setTitle(R.string.tWeekly);
                                                       AlertDialog alt1 =x.create();
                                                       alt1.show();


                                                   }
                                                   if (Locale.getDefault().getLanguage().equals("fr")) {
                                                       p.weekly();
                                                       AlertDialog.Builder x1 = new AlertDialog.Builder(TestTaxGUI.this);
                                                       x1.setMessage(  aList.get(aList.size() - 1).weekly());
                                                       x1.setTitle(R.string.tWeekly);
                                                       AlertDialog alt2 =x1.create();
                                                       alt2.show();

                                                   }
                                                   if (Locale.getDefault().getLanguage().equals("es")) {
                                                       p.weekly();
                                                       AlertDialog.Builder x2 = new AlertDialog.Builder(TestTaxGUI.this);
                                                       x2.setMessage(  aList.get(aList.size() - 1).weekly()).setPositiveButton((getString(R.string.gNext)), new DialogInterface.OnClickListener() {

                                                           @Override

                                                           public void onClick(DialogInterface dialog, int which) {

                                                           }

                                                       })

                                                               .setNegativeButton((getString(R.string.eCan)), null);
                                                       x2.setTitle(getString(R.string.ti) );
                                                       x2.setTitle(R.string.tWeekly);
                                                       AlertDialog alt3 =x2.create();
                                                       alt3.show();

                                                   }
                                               } else if (radMonth.isChecked()) {
                                                   if (Locale.getDefault().getLanguage().equals("en")) {
                                                       p.weekly();
                                                       p.monthly();
                                                       AlertDialog.Builder x3 = new AlertDialog.Builder(TestTaxGUI.this);
                                                       x3.setMessage(  aList.get(aList.size() - 1).monthly()).setPositiveButton((getString(R.string.gNext)), new DialogInterface.OnClickListener() {

                                                           @Override

                                                           public void onClick(DialogInterface dialog, int which) {

                                                           }

                                                       })

                                                               .setNegativeButton((getString(R.string.eCan)), null);
                                                       x3.setTitle(getString(R.string.ti) );
                                                       x3.setTitle(R.string.tMonthly);
                                                       AlertDialog alt4 =x3.create();
                                                       alt4.show();

                                                   }
                                                   if (Locale.getDefault().getLanguage().equals("fr")) {
                                                       p.weekly();
                                                       p.monthly();
                                                       AlertDialog.Builder x4 = new AlertDialog.Builder(TestTaxGUI.this);
                                                       x4.setMessage(  aList.get(aList.size() - 1).monthly()).setPositiveButton((getString(R.string.gNext)), new DialogInterface.OnClickListener() {

                                                           @Override

                                                           public void onClick(DialogInterface dialog, int which) {

                                                           }

                                                       })

                                                               .setNegativeButton((getString(R.string.eCan)), null);
                                                       x4.setTitle(getString(R.string.ti) );;
                                                       x4.setTitle(R.string.tMonthly);
                                                       AlertDialog alt5 =x4.create();
                                                       alt5.show();

                                                   }
                                                   if (Locale.getDefault().getLanguage().equals("es")) {
                                                       p.weekly();
                                                       p.monthly();
                                                       AlertDialog.Builder x5 = new AlertDialog.Builder(TestTaxGUI.this);
                                                       x5.setMessage(  aList.get(aList.size() - 1).monthly()).setPositiveButton((getString(R.string.gNext)), new DialogInterface.OnClickListener() {

                                                           @Override

                                                           public void onClick(DialogInterface dialog, int which) {

                                                           }

                                                       })

                                                               .setNegativeButton((getString(R.string.eCan)), null);
                                                       x5.setTitle(getString(R.string.ti) );
                                                       x5.setTitle(R.string.tMonthly);
                                                       AlertDialog alt6 =x5.create();
                                                       alt6.show();

                                                   }
                                               } else if (radAnnu.isChecked()) {
                                                   if (Locale.getDefault().getLanguage().equals("en")) {
                                                       p.weekly();
                                                       p.monthly();
                                                       p.annual();
                                                       AlertDialog.Builder x6 = new AlertDialog.Builder(TestTaxGUI.this);
                                                       x6.setMessage(  aList.get(aList.size() - 1).annual()).setPositiveButton((getString(R.string.gNext)), new DialogInterface.OnClickListener() {

                                                           @Override

                                                           public void onClick(DialogInterface dialog, int which) {

                                                           }

                                                       })

                                                               .setNegativeButton((getString(R.string.eCan)), null);
                                                       x6.setTitle(getString(R.string.ti) );;
                                                       x6.setTitle(R.string.tYearly);
                                                       AlertDialog alt7 =x6.create();
                                                       alt7.show();

                                                   }
                                                   if (Locale.getDefault().getLanguage().equals("fr")) {
                                                       p.weekly();
                                                       p.monthly();
                                                       p.annual();
                                                       AlertDialog.Builder x7 = new AlertDialog.Builder(TestTaxGUI.this);
                                                       x7.setMessage(  aList.get(aList.size() - 1).annual()).setPositiveButton((getString(R.string.gNext)), new DialogInterface.OnClickListener() {

                                                           @Override

                                                           public void onClick(DialogInterface dialog, int which) {

                                                           }

                                                       })

                                                               .setNegativeButton((getString(R.string.eCan)), null);
                                                       x7.setTitle(getString(R.string.ti) );;
                                                       x7.setTitle(R.string.tYearly);
                                                       AlertDialog alt8 =x7.create();
                                                       alt8.show();

                                                   }
                                                   if (Locale.getDefault().getLanguage().equals("es")) {
                                                       p.weekly();
                                                       p.monthly();
                                                       p.annual();
                                                       AlertDialog.Builder x8 = new AlertDialog.Builder(TestTaxGUI.this);
                                                       x8.setMessage(  aList.get(aList.size() - 1).annual()).setPositiveButton((getString(R.string.gNext)), new DialogInterface.OnClickListener() {

                                                           @Override

                                                           public void onClick(DialogInterface dialog, int which) {

                                                           }

                                                       })

                                                               .setNegativeButton((getString(R.string.eCan)), null);
                                                       x8.setTitle(getString(R.string.ti) );;
                                                       x8.setTitle(R.string.tYearly);
                                                       AlertDialog alt9 =x8.create();
                                                       alt9.show();
                                                       // Toast.makeText(getApplicationContext(), getString(R.string.tYearly) + aList.get(aList.size() - 1).annual(),
                                                       // Toast.LENGTH_LONG).show();
                                                   } else {
                                                       Toast.makeText(getApplicationContext(), getString(R.string.tOptions),
                                                               Toast.LENGTH_LONG).show();
                                                   }

                                               }
                                               AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(TestTaxGUI.this);
                                               alertDialogBuilder.setMessage( "\n" + getString(R.string.tH) + hour + "\n" + getString(R.string.tRate) + rate + "\n" + getString(R.string.tHea) + health + "\n" + getString(R.string.tUnion) + union + "\n"
                                                       + getString(R.string.tTaxCredit) + taxcredit + "\n" + getString(R.string.tOver) + overtime).setPositiveButton("Go next", new DialogInterface.OnClickListener() {

                                                   @Override

                                                   public void onClick(DialogInterface dialog, int which) {

                                                   }

                                               })

                                                       .setNegativeButton((getString(R.string.eCan)), null);
                                               alertDialogBuilder.setTitle(getString(R.string.ti) );
                                               AlertDialog alt =alertDialogBuilder.create();
                                               alt.show();
                                               netTest = p.netpay();





                                           }







                                       }
                                   }






        );




        butEntitle.setOnClickListener(new View.OnClickListener(){

                                        @Override

                                        public void onClick(View view){

                                            openEntitlmentsGUI();

                                        }



                                    }

        );


    }

    public void openEntitlmentsGUI(){

        Intent intent= new Intent(this,EntitlementsGUI.class);

        startActivity(intent);

    }

}
