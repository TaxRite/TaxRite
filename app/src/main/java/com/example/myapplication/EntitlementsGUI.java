package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;
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


public class EntitlementsGUI extends AppCompatActivity {
public ArrayList<Tax> aList2 = new ArrayList();

public void Entitlments( Tax p, String dep){

}
@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_entitlements_gui);
        final Button entitlement= (Button)findViewById(R.id.entitelemnt);


       // ReadFromFile();
entitlement.setOnClickListener(new View.OnClickListener() {


                               Tax p= new Tax();
                                   TaxGUI g= new  TaxGUI();


                                   public void onClick(View view) {

p.weekly();
       // g.aList.equals(aList2)  ;
//g.aList.add().
p.weekly();

//g.aList.get(g.aList.size()-1).weekly();
                                       Toast.makeText(getApplicationContext(), "netpay "+ g.getaList().size()
                                               ,


                                               Toast.LENGTH_LONG).show();
                                       startActivity(new Intent(getApplicationContext(),RebateGUI.class));
                                   }

                               }
          );





        }

    }

