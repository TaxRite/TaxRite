package com.example.myapplication;

import android.content.Intent;
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



public class TestTaxGUI extends AppCompatActivity {

    public ArrayList<Tax> aList = new ArrayList();
    ListView show;
    Double hour,rate,overtime,taxcredit,healthinsurance,unionsubs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_tax_gui);

        Button butCalc = (Button)findViewById(R.id.btncalculate) ;


        ReadFromFile();

        final RadioButton radWeek = (RadioButton)findViewById(R.id.rbweekly);
        final RadioButton radMonth = (RadioButton)findViewById(R.id.rbmonthly);
        final RadioButton radAnnu = (RadioButton)findViewById(R.id.rbannu);
        final EditText hours1= (EditText)findViewById(R.id.TFhours);
        final EditText rate1= (EditText)findViewById(R.id.TFrate);
        final EditText health1= (EditText)findViewById(R.id.TFhealth);
        final EditText union1= (EditText)findViewById(R.id.TFunion);
        final EditText taxcredit1= (EditText)findViewById(R.id.TFtaxcredit);
        final EditText overtime1= (EditText)findViewById(R.id.TFovertime);


        butCalc.setOnClickListener(new View.OnClickListener()
                                     {
                                         Tax p= new Tax();
                                         //TextView result;
                                         @Override
                                         public void onClick(View view)
                                         {
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

                                             Toast.makeText(getApplicationContext(), "THe following info has been added: "+"\n"+"Hours: "+hour+"\n"
                                                             +"Rate: "+rate+"\n"+"Health Insurance: "+health+"\n"+"Union Subs: "+union+"\n"
                                                             +"Tax Credit: "+taxcredit+"\n"+"Overtime: "+overtime,


                                                     Toast.LENGTH_LONG).show();
                                                     WriteToFile();
                                             if(radWeek.isSelected()){

                                                 Toast.makeText(getApplicationContext(), "weekly"+aList.get(aList.size()-1).weekly(),
                                                         Toast.LENGTH_LONG).show();
                                             }
                                             if(radMonth.isSelected()){
                                                 p.weekly();
                                                 Toast.makeText(getApplicationContext(), "monthly"+aList.get(aList.size()-1).monthly(),
                                                         Toast.LENGTH_LONG).show();
                                             }
                                             if(radAnnu.isSelected()){
                                                 p.weekly();
                                                 p.monthly();
                                                 Toast.makeText(getApplicationContext(), "annually"+aList.get(aList.size()-1).annual(),
                                                         Toast.LENGTH_LONG).show();
                                             }
                                             //String hours = hours1.getText().toString();
                                             //result.setText("Name:\t" + hours );
                                             startActivity(new Intent(getApplicationContext(),EntitlementsGUI.class));
                                         }
                                     }


        );

    }
    public void WriteToFile (){
        String text="";
        try{
            File a=new File ("C:/Users/lam10/Desktop/codeapril/out.dat");
            FileOutputStream b= new FileOutputStream(a);
            ObjectOutputStream c= new ObjectOutputStream(b);
            c.write(text.getBytes());
            c.close();
        }
        catch (IOException e){
            System.out.print(e);
        }

    }
    public void ReadFromFile(){
        try{
            File a = new File("C:/Users/lam10/Desktop/codeapril/out.dat");
            FileInputStream b= new FileInputStream(a);
            ObjectInputStream c= new ObjectInputStream(b);
            aList=(ArrayList<Tax>)c.readObject();
            c.close();
        }
        catch (IOException|ClassNotFoundException ex){
            System.out.print(ex);
        }
    }
}


