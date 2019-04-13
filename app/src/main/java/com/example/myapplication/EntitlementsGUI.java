package com.example.myapplication;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.provider.MediaStore;
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


public class EntitlementsGUI  extends AppCompatActivity {
	private EditText age1;
	private EditText dependencies1;
	private RadioButton single;
	private RadioButton maried;
	private RadioButton working;
	private CheckBox residency;
	private RadioButton jobseeker;
	private TextView result;
	private Button checkentilements;
	private Button nextpage;

	public ArrayList<Tax> aList2 = new ArrayList();


	public static double net (){
    double net = TestTaxGUI.netTest;
    return  net;

}


        @Override

        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_entitlements_gui);
			setContentView(R.layout.activity_entitlements_gui);
			age1= (EditText)findViewById(R.id.txtage);
			dependencies1 = (EditText)findViewById(R.id.txtdependencies);
			single = (RadioButton) findViewById(R.id.rbsingle);
			maried = (RadioButton) findViewById(R.id.rbmaried);
			working = (RadioButton) findViewById(R.id.rbworking);
			jobseeker = (RadioButton) findViewById(R.id.rbjseeker);
			residency=(CheckBox)findViewById(R.id.ckbresidence);
			checkentilements =(Button)findViewById(R.id.btnclick);
			residency=(CheckBox)findViewById(R.id.ckbresidence);
			nextpage=(Button)findViewById(R.id.next);

            final Button checkentilements = (Button) findViewById(R.id.btnclick);
			final Button nextpage = (Button) findViewById(R.id.next);

			checkentilements.setOnClickListener(new View.OnClickListener() {


				Tax p = new Tax();
                TestTaxGUI g = new TestTaxGUI();
                Entitlements e= new Entitlements();

				@Override 
				public void onClick(View view) {
					AlertDialog.Builder builder = new AlertDialog.Builder(EntitlementsGUI.this);
					Integer age=Integer.parseInt(age1.getText().toString());
					Integer dependencies =Integer.parseInt(dependencies1.getText().toString());
					e.setAge(age);
					e.setDependencies(dependencies);
					aList2.add(e);
					builder.setMessage("Your net payment="+net())
							.setPositiveButton("Go next", new DialogInterface.OnClickListener() {
							@Override
								public void onClick(DialogInterface dialog, int which) {
								}
							})
							.setNegativeButton("Cancel", null);
					AlertDialog alert = builder.create();
					alert.show();
												///medical card
					if (single.isChecked() && age <= (66) && (dependencies< 1 && net() <= 184 || maried.isChecked() && age >= (66) && (dependencies < 1 && net() <= (201.50)))) {
						AlertDialog.Builder a = new AlertDialog.Builder(EntitlementsGUI.this);
						a.setMessage(  "Good news!! you are entitle to get medical card");
						a.setTitle("Medical card");
						AlertDialog alt1 =a.create();
						alt1.show();
					} else if ((maried.isChecked() || !single.isChecked() && age <(66) && (dependencies < 1 && net() <= 164 || single.isChecked()&& !maried.isChecked ()&& age > (66) && (dependencies < 1 && net() <= (173.50))))){
						AlertDialog.Builder a1 = new AlertDialog.Builder(EntitlementsGUI.this);
						a1.setMessage(  "Good news!! you are entitle to get medical card");
						a1.setTitle("Medical card");
						AlertDialog alt2 =a1.create();
						alt2.show();
					} else if ((single.isChecked()|| maried.isChecked() && age <(66) && (dependencies >0 && net() <= 266.50 && dependencies < 2 || single.isChecked()|| maried.isChecked() && age > (66) && (dependencies >0&& (dependencies <2 && net() <= (298)))))){
						AlertDialog.Builder a3 = new AlertDialog.Builder(EntitlementsGUI.this);
						a3.setMessage(  "Good news!! you are entitle to get medical card");
						a3.setTitle("Medical card");
						AlertDialog alt3 =a3.create();
						alt3.show();
					}
					else
						for (int i=0; i < 2; i++) {
							AlertDialog.Builder a4 = new AlertDialog.Builder(EntitlementsGUI.this);
							a4.setMessage(  "Sorry, it's seems like you are entitle for medical card this time but you may try for a GP card");
							a4.setTitle("Medical card");
							AlertDialog alt4 =a4.create();
							alt4.show();
						}
																		///amily supplementf
					if ( net() < 521.00 && ((dependencies>0 && ((dependencies<2)&& working.isChecked()&& maried.isChecked())))) {
						AlertDialog.Builder a5= new AlertDialog.Builder(EntitlementsGUI.this);
						a5.setMessage(  "Good news!! you are entitle to get family supplement to make your total weekly income 521");
						a5.setTitle("family supplement");
						AlertDialog alt5 =a5.create();
						alt5.show();
					}
					else if( net() >521.00 && net() <= 622.00 && ((dependencies>1)&& ((dependencies<3 ) ) &&working.isChecked()&& single.isChecked()||maried.isChecked())){
						AlertDialog.Builder a6= new AlertDialog.Builder(EntitlementsGUI.this);
						a6.setMessage(  "Good news!! you are entitle to get family supplement to make your total weekly income 622");
						a6.setTitle("family supplement");
						AlertDialog alt6 =a6.create();
						alt6.show();
					}
					else if(net() >622.00 && net() <= 723.00 && dependencies>2 && dependencies<4 && working.isChecked()&& single.isChecked() || maried.isChecked()){
						AlertDialog.Builder a7= new AlertDialog.Builder(EntitlementsGUI.this);
						a7.setMessage(  "Good news!! you are entitle to get family supplement to make your total weekly income 723");
						a7.setTitle("family supplement");
						AlertDialog alt7 =a7.create();
						alt7.show();
					}
					else if (net() >521.00 && dependencies <1 && working.isChecked()&& single.isChecked()) {
						AlertDialog.Builder a8= new AlertDialog.Builder(EntitlementsGUI.this);
						a8.setMessage( "Sorry, it's look like you are not entitle for family supplement as your income is higher than required ");
						a8.setTitle("family supplement");
						AlertDialog alt8 =a8.create();
						alt8.show();
					}
																	///child benefit
					if (dependencies== 1){
						AlertDialog.Builder a9= new AlertDialog.Builder(EntitlementsGUI.this);
						a9.setMessage(  "You are entitle for child benefit of €140 ");
						a9.setTitle("Child benefit");
						AlertDialog alt9 =a9.create();
						alt9.show();
					}else if( dependencies == 2 ) {

						AlertDialog.Builder a10= new AlertDialog.Builder(EntitlementsGUI.this);
						a10.setMessage(  "You are entitle for child benefit of €280 ");
						a10.setTitle("Child benefit");
						AlertDialog alt10 =a10.create();
						alt10.show();
					
					}else if( dependencies == 3){
						AlertDialog.Builder a11= new AlertDialog.Builder(EntitlementsGUI.this);
						a11.setMessage(  "You are entitle for child benefit of €420 ");
						a11.setTitle("Child benefit");
						AlertDialog alt11 =a11.create();
						alt11.show();
					
					}else if( dependencies == 4){
						AlertDialog.Builder a12= new AlertDialog.Builder(EntitlementsGUI.this);
						a12.setMessage(  "Child benefit increase 140 euro for every single child ");
						a12.setTitle("Child benefit");
						AlertDialog alt12 =a12.create();
						alt12.show();
					}
																		///susi
					if(working.isChecked()&& residency.isChecked() ){
						AlertDialog.Builder a13= new AlertDialog.Builder(EntitlementsGUI.this);
						a13.setMessage(  "You are entitle to get student grant, please apply online ");
						a13.setTitle("SUSI");
						AlertDialog alt13 =a13.create();
						alt13.show();
					}
					else if (!residency.isChecked()&& working.isChecked()){
						AlertDialog.Builder a14= new AlertDialog.Builder(EntitlementsGUI.this);
						a14.setMessage(  "Sorry, you are not entitle to get SUSI");
						a14.setTitle("SUSI");
						AlertDialog alt14 =a14.create();
						alt14.show();
					}
																			///rent supplement
					if (!working.isChecked()&& jobseeker.isChecked()){
						AlertDialog.Builder a15= new AlertDialog.Builder(EntitlementsGUI.this);
						a15.setMessage(  "You are entitle to get rent supplement ");
						a15.setTitle("Rent supplement");
						AlertDialog alt15 =a15.create();
						alt15.show();
					}
					else if (!residency.isChecked()&& working.isChecked()) {
						AlertDialog.Builder a16 = new AlertDialog.Builder(EntitlementsGUI.this);
						a16.setMessage("Sorry, you are not entitle to get rent supplement ");
						a16.setTitle("Rent supplement ");
						AlertDialog alt16 = a16.create();
						alt16.show();
					}
                	
                                               }

                                           }
            );
			nextpage.setOnClickListener(new View.OnClickListener(){
				@Override
				public void onClick(View view){
					openRebateGUI();
				}
				
			}
			);


        }
        public void openRebateGUI(){
		Intent intent= new Intent(this,RebateGUI.class);
		startActivity(intent);
		}
    }


