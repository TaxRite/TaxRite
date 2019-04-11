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


public class EntitlementsGUI  extends AppCompatActivity {
	private EditText age1;
	private EditText dependencies1;
	private CheckBox single;
	private CheckBox maried;
	private CheckBox working;
	private CheckBox residency;
	private CheckBox jobseeker;
	private Button checkentilements;

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
			single = (CheckBox)findViewById(R.id.cbsingle);
			maried = (CheckBox)findViewById(R.id.cbmaried);
			single = (CheckBox)findViewById(R.id.cbsingle);
			maried = (CheckBox)findViewById(R.id.cbmaried);
			working=(CheckBox)findViewById(R.id.cbworking);
			jobseeker=(CheckBox)findViewById(R.id.cbjseeker); 
			checkentilements =(Button)findViewById(R.id.btnclick);
			residency=(CheckBox)findViewById(R.id.ckbresidence);

            final Button checkentilements = (Button) findViewById(R.id.btnclick);

			checkentilements.setOnClickListener(new View.OnClickListener() {


				Tax p = new Tax();
                TestTaxGUI g = new TestTaxGUI();
                Entitlements e= new Entitlements();

				@Override 
				public void onClick(View view) {
					
					Integer age=Integer.parseInt(age1.getText().toString());
					Integer dependencies =Integer.parseInt(dependencies1.getText().toString());
					e.setAge(age);
					e.setDependencies(dependencies);
					aList2.add(e);
					Toast.makeText(getApplicationContext(), "based on your net income  "+net(),
							Toast.LENGTH_LONG).show();
					
																				///medical card
					if (single.isChecked()&& !maried.isChecked()&& age <= (66) && (dependencies< 1 && net() <= 184 || maried.isChecked() &&  !single.isChecked() && age >= (66) && (dependencies < 1 && net() <= (201.50)))) {
						Toast.makeText(getApplicationContext(), "Good news! It seems that you might be entitled to get Medical card on based on scheme 1,please apply with form provided",
								Toast.LENGTH_LONG).show();
					} else if ((maried.isChecked() && !single.isChecked() && age <(66) && (dependencies < 1 && net() <= 164 || single.isChecked()&& !maried.isChecked ()&& age > (66) && (dependencies < 1 && net() <= (173.50))))){
						Toast.makeText(getApplicationContext(), "Good news! It seems that you might be entitled to get Medical card on based on scheme 2,please apply with form provided",
								Toast.LENGTH_LONG).show();
					} else if ((single.isChecked()||maried.isChecked() && age <(66) && (dependencies >0 && net() <= 266.50 && dependencies < 2 || single.isChecked()|| maried.isChecked() && age > (66) && (dependencies >0&& (dependencies <2 && net() <= (298)))))){
						Toast.makeText(getApplicationContext(), "Good news! It seems like you might be entitled to get Medical card on based on scheme 3,please apply with form provided",
								Toast.LENGTH_LONG).show();
					}
					else
						for (int i=0; i < 2; i++) {

							Toast.makeText(getApplicationContext(), "sorry you are not entitle to get medical card but you may try for a GP card only",
									Toast.LENGTH_LONG).show();
						}
																		///family supplement
					if ( net() < 521.00 && ((dependencies>0 && ((dependencies<2)&& working.isChecked()&& maried.isChecked()||single.isChecked())))) {
						Toast.makeText(getApplicationContext(), "you are entitle to get family supplement to make your weekly overall  income 521 ",

								Toast.LENGTH_LONG).show();
					}
					else if( net() >521.00 && net() <= 622.00 && ((dependencies>1)&& ((dependencies<3 ) ) &&working.isChecked()&& single.isChecked()||maried.isChecked())){
						Toast.makeText(getApplicationContext(), "you are entitle to get family supplement to make your weekly overall  income 622",

								Toast.LENGTH_LONG).show();
					}
					else if(net() >723.00 && net() <= 824.00 && dependencies>2 && dependencies<4 && working.isChecked()&& single.isChecked() || maried.isChecked()){


						Toast.makeText(getApplicationContext(), "you are entitle to get family supplement to make your weekly overall  income 622",
								Toast.LENGTH_LONG).show();
					}
					else if (net() >521.00 && dependencies <1 &&working.isChecked()&& single.isChecked()||maried.isChecked()) {
						Toast.makeText(getApplicationContext(), "sorry your circumstances seems bit complex please contact one of your local social office,Thanks",
								Toast.LENGTH_LONG).show();
					}
					else{
						Toast.makeText(getApplicationContext(), "sorry your circumstances seems bit complex please contact one of your local social office,Thanks",
								Toast.LENGTH_LONG).show();

					}
																	///child benefit
					if (dependencies== 1){
						Toast.makeText(getApplicationContext(), "You are entitle for child benefit of €140 ",
								Toast.LENGTH_LONG).show(); 
					}else if( dependencies == 2 ) {
						Toast.makeText(getApplicationContext(), "You are entitle for child benefit of €280 ",
								Toast.LENGTH_LONG).show();
					
					}else if( dependencies == 3){
					Toast.makeText(getApplicationContext(), "You are entitle for child benefit of €420 ",
							Toast.LENGTH_LONG).show();
					}else if( dependencies == 4){
					Toast.makeText(getApplicationContext(), "You are entitle for child benefit of €560 ",
							Toast.LENGTH_LONG).show();

					}else if( dependencies == 5){
					Toast.makeText(getApplicationContext(), "You are entitle for child benefit of €700 ",
							Toast.LENGTH_LONG).show();

					}else if( dependencies == 6){
					Toast.makeText(getApplicationContext(), "You are entitle for child benefit of €840 ",
							Toast.LENGTH_LONG).show();

					}else if( dependencies == 7){
					Toast.makeText(getApplicationContext(), "family sufflyments increase simultansiously €140 for every children ",
							Toast.LENGTH_LONG).show();
					}
																		///susi
					if(working.isChecked()&& residency.isChecked() ){
						Toast.makeText(getApplicationContext(), "You are also entitle for SUSI, please apply online with your supportive documents ",
								Toast.LENGTH_LONG).show();
					}
					else if (!residency.isChecked()&& working.isChecked()){
						Toast.makeText(getApplicationContext(), "Sory its seems like you are not entitle for susi as you are not living in ireland more than 3 years ",
								Toast.LENGTH_LONG).show();
					}
																			///rent supplement
					if (!working.isChecked()&& jobseeker.isChecked()){
						Toast.makeText(getApplicationContext(), "if you are a jobseeker or you working less than 30 hours you are entitlement to get rent supplement",
								Toast.LENGTH_LONG).show();
					}
					else if (!residency.isChecked()&& working.isChecked()) {
						Toast.makeText(getApplicationContext(), "Sory its seems like you are not entitle for rent supplement as you are working full time ",
								Toast.LENGTH_LONG).show();
					}
                	startActivity(new Intent(getApplicationContext(), RebateGUI.class));
                                               }

                                           }
            );


        }
    }


