package com.pranjal140003gmail.gupta.p.takecare;

import android.net.Uri;

import java.io.Serializable;

/**
 * Created by pranjal on 30/07/2017.
 */

public class PatientInfo implements Serializable {
    private String mName ;
    private String mSex ;
    private String mDOB ;
    private String mPhone ;
    private String mEmailId ;
    private String mProblemDescription ;
    private String mInfectedPhoto  ;

    public PatientInfo(){
        //For firebase
    }

    public String getName() {
        return mName;
    }

    public PatientInfo(String name,String sex,String DOB,String Phone,String EmailId,String problemDescription,String infectedPhotoUri){
        mName =name ;
        mSex = sex ;
        mDOB = DOB ;
        mPhone = Phone;
        mEmailId = EmailId  ;
        mProblemDescription = problemDescription ;
        mInfectedPhoto = infectedPhotoUri  ;
    }

    public void setName(String Name) {
        this.mName = Name;
    }

    public String getSex() {
        return mSex;
    }

    public void setSex(String Sex) {
        this.mSex = Sex;
    }

    public String getDOB() {
        return mDOB;
    }

    public void setDOB(String DOB) {
        this.mDOB = DOB;
    }

    public String getProblemDescription() {
        return mProblemDescription;
    }

    public void setProblemDescription(String ProblemDescription) {
        this.mProblemDescription = ProblemDescription;
    }

    public String getPhone() {
        return mPhone;
    }

    public void setPhone(String Phone) {
        this.mPhone = Phone;
    }

    public String getEmailId() {
        return mEmailId;
    }

    public void setEmailId(String EmailId) {
        this.mEmailId = EmailId;
    }

    public String getInfectedPhoto() {
        return mInfectedPhoto;
    }

    public void setInfectedPhoto(String InfectedPhoto) {
        this.mInfectedPhoto = InfectedPhoto;
    }
}
