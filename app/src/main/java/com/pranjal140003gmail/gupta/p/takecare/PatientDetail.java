package com.pranjal140003gmail.gupta.p.takecare;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.widget.TextView;

import static android.provider.LiveFolders.INTENT;

public class PatientDetail extends AppCompatActivity {
     private TextView mNameTextView ;
     private TextView mAge ;
     private TextView mSex ;
     private TextView mPhone ;
     private TextView mEmailId ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_detail);

        mNameTextView = (TextView)findViewById(R.id.patient_name);
        mAge = (TextView) findViewById(R.id.patient_age);
        mSex = (TextView)findViewById(R.id.patient_sex);
        mPhone = (TextView)findViewById(R.id.patient_phone);
        mEmailId =(TextView)findViewById(R.id.patient_email) ;

        Bundle bundle =  getIntent().getExtras() ;
         PatientInfo info = (PatientInfo) bundle.get(MainActivity.INTENT_DETAIL_KEY) ;
         mNameTextView.setText(info.getName());

        mSex.setText(info.getSex());
        mPhone.setText(info.getPhone());
        mEmailId.setText(info.getEmailId());
    }

}
