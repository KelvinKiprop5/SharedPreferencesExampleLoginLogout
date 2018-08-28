package com.masterpiecenet.sharedpreferencesexampleloginlogout.Classes;

import android.content.Context;
import android.content.SharedPreferences;

import com.masterpiecenet.sharedpreferencesexampleloginlogout.R;


//-----------------------------------SharedPreferencesConfigurations-------------------------------//
public class SharedPreferencesConfigurations {

    //Variables
    private SharedPreferences sharedPreferences;
    private Context context;

    //Constructor
    public SharedPreferencesConfigurations(Context context) {
        this.context = context;
        //Initialize shared preference variable and set opening mode private
        sharedPreferences = context.getSharedPreferences(context.getResources().getString(R.string.login_preference), Context.MODE_PRIVATE);
    }




    //-----------------------------------Method to writeLoginStatus-------------------------------//
    public void writeLoginStatus(boolean status) {

        //Create and initialize editor object
        SharedPreferences.Editor editor =  sharedPreferences.edit();
        //Add value
        editor.putBoolean(context.getResources().getString(R.string.login_preference_status), status);
        //Then save value
        editor.commit();

    }//-----------------------------------./Method to writeLoginStatus-------------------------------//



    //-----------------------------------Method to readLoginStatus-------------------------------//
    public boolean readLoginStatus() {

        //Create variable and assign value
        boolean status = false;
        status = sharedPreferences.getBoolean(context.getResources().getString(R.string.login_preference_status), status);
        //Return default value which is false
        return status;

    }//-----------------------------------./Method to readLoginStatus-------------------------------//




}//-----------------------------------./SharedPreferencesConfigurations-------------------------------//
