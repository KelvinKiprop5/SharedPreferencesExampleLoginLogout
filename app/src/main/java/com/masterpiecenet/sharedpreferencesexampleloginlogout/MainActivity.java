package com.masterpiecenet.sharedpreferencesexampleloginlogout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.masterpiecenet.sharedpreferencesexampleloginlogout.Classes.SharedPreferencesConfigurations;


//-----------------------------------MainActivity extends AppCompatActivity-------------------------------//
public class MainActivity extends AppCompatActivity {

    //Declare variables
    private TextView tvWelcomeMessage;
    private Button btnLogout;

    private SharedPreferencesConfigurations sharedPreferencesConfigurations;

    //-----------------------------------onCreate-------------------------------//

    //-----------------------------------onCreate-------------------------------//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //Initialize variables
        tvWelcomeMessage = findViewById(R.id.textViewWelcomeMessage);
        btnLogout = findViewById(R.id.buttonLogout);

        sharedPreferencesConfigurations = new SharedPreferencesConfigurations(MainActivity.this);


        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Call
                logoutUser();
            }
        });


    }//-----------------------------------./onCreate-------------------------------//


    //-----------------------------------Method to logout user-------------------------------//
    private void logoutUser() {
        sharedPreferencesConfigurations.writeLoginStatus(false);

        //Take user to Login activity
        Intent loginIntent = new Intent(MainActivity.this, LoginActivity.class);
        startActivity(loginIntent);
        finish();//User will not be able to go back
    }//-----------------------------------./Method to logout user-------------------------------//

}//-----------------------------------./MainActivity extends AppCompatActivity-------------------------------//
