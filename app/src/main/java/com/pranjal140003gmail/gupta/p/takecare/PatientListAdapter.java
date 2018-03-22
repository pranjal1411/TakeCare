package com.pranjal140003gmail.gupta.p.takecare;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.LayoutRes;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.ObservableSnapshotArray;
import com.firebase.ui.database.SnapshotParser;
import com.google.firebase.database.Query;

import org.w3c.dom.Text;

import static android.R.attr.mode;
import static android.preference.PreferenceManager.getDefaultSharedPreferences;

/**
 * Created by pranjal on 30/07/2017.
 */

public class PatientListAdapter extends FirebaseRecyclerAdapter<PatientInfo,PatientDataHolder>{

    public  static PatientViewHolderOnCLickListener mPatientViewHolderOnCLickListener  ;

    public interface PatientViewHolderOnCLickListener{
         void OnClick(PatientInfo info)  ;
    }

    public PatientListAdapter(Class<PatientInfo> modelClass, @LayoutRes int modelLayout, Class<PatientDataHolder> viewHolderClass, Query query,PatientViewHolderOnCLickListener patientViewHolderOnCLickListener) {
        super(modelClass, modelLayout, viewHolderClass, query);
       mPatientViewHolderOnCLickListener =  patientViewHolderOnCLickListener ;
    }


    @Override
    protected void populateViewHolder(PatientDataHolder viewHolder, PatientInfo model, int position) {
            viewHolder.nameTextView.setText(model.getName());
            viewHolder.mPatientInfo = model ;

        Context context = viewHolder.dateTextView.getContext()  ;
        String name_key = viewHolder.nameTextView.getText().toString() ;
  if(PreferenceManager.getDefaultSharedPreferences(context).getBoolean(name_key,false)==true){
      viewHolder.shapeColor.setBackground(ContextCompat.getDrawable(context,R.drawable.shape_circle_green));
  }

    }

}

class PatientDataHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
          public static final String INTENT_KEY = "patientInfoClass" ;
           public TextView nameTextView  ;
           public TextView dateTextView ;
           public ImageView shapeColor ;
           public PatientInfo mPatientInfo ;

    public PatientDataHolder(View itemView) {
        super(itemView);


        nameTextView = (TextView)itemView.findViewById(R.id.name_text_view) ;
        dateTextView = (TextView) itemView.findViewById(R.id.date_text_view) ;
        shapeColor = (ImageView) itemView.findViewById(R.id.shape_circle) ;
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(PreferenceManager.getDefaultSharedPreferences(v.getContext()).getBoolean(nameTextView.getText().toString(),false)==false){
            SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(v.getContext());
            SharedPreferences.Editor editor = prefs.edit() ;
            editor.putBoolean(nameTextView.getText().toString(),true) ;
            editor.apply() ;
            shapeColor.setBackground(ContextCompat.getDrawable(v.getContext(),R.drawable.shape_circle_green));}
        PatientListAdapter.mPatientViewHolderOnCLickListener.OnClick(mPatientInfo) ;
    }


}