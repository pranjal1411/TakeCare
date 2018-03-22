package com.pranjal140003gmail.gupta.p.takecare;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class MainActivity extends AppCompatActivity  implements PatientListAdapter.PatientViewHolderOnCLickListener{

    private RecyclerView mRecyclerView ;
    private PatientListAdapter mPatientListAdapter ;
    private DatabaseReference mDatabaseReference ;

    public static final String INTENT_DETAIL_KEY = "detailActivityKey" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Firebas Instance lol z hello dear

        mDatabaseReference = FirebaseDatabase.getInstance().getReference().child("patientData") ;

        mRecyclerView = (RecyclerView)findViewById(R.id.recycler_view) ;
        LinearLayoutManager layoutManager = new LinearLayoutManager(this) ;

        mRecyclerView.setLayoutManager(layoutManager);

        PatientInfo info  = new PatientInfo();
        String name = "Unknown" ;


        mPatientListAdapter = new PatientListAdapter(PatientInfo.class,R.layout.list_item,PatientDataHolder.class,mDatabaseReference,this) ;

        mRecyclerView.setAdapter(mPatientListAdapter);

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mPatientListAdapter.cleanup();
    }

    @Override
    public void OnClick(PatientInfo info) {

        Intent intent = new Intent(this,PatientDetail.class)  ;
        intent.putExtra(INTENT_DETAIL_KEY,info) ;
        startActivity(intent);

    }
}

