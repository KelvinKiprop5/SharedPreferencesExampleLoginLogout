package com.masterpiecenet.sharedpreferencesexampleloginlogout;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.masterpiecenet.sharedpreferencesexampleloginlogout.Classes.SharedPreferencesConfigurations;


//-----------------------------------LoginActivity extends AppCompatActivity-------------------------------//
public class LoginActivity extends AppCompatActivity {

    //Declare variables
    private EditText etUserName, etPassword;
    private Button btnLogin;

    private SharedPreferencesConfigurations sharedPreferencesConfigurations;

    //-----------------------------------onCreate-------------------------------//
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);



        //Initialize variables
        etUserName = findViewById(R.id.editTextUsername);
        etPassword = findViewById(R.id.editTextPassword);

        btnLogin = findViewById(R.id.buttonLogin);

        sharedPreferencesConfigurations = new SharedPreferencesConfigurations(LoginActivity.this);


        //Handle login button click
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //Call
                loginUser();
            }
        });


        //Check if user is logged in i.e if status is tru
        if (sharedPreferencesConfigurations.readLoginStatus()){
            //Take user to main activity
            Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(mainIntent);
            finish();//User will not be able to go back
        }



    }  //-----------------------------------./onCreate-------------------------------//





    //-----------------------------------Method to login user-------------------------------//
    private void loginUser() {
        //Get user inputs
        String username = etUserName.getText().toString();
        String password = etPassword.getText().toString();

        //Ensure no field is
        if (username.isEmpty()){
            Toast.makeText(LoginActivity.this, "Username field is empty", Toast.LENGTH_SHORT).show();
        }else if  (password.isEmpty()){
            Toast.makeText(LoginActivity.this, "Password field is empty", Toast.LENGTH_SHORT).show();
        }
        //Check if user inputs are equal to our saved values in the preferences
        else if (username.equals(getResources().getString(R.string.user_name)) && !username.isEmpty()
           && password.equals(getResources().getString(R.string.user_password)) && !password.isEmpty()){

            //Take user to main activity
            Intent mainIntent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(mainIntent);
            finish();//User will not be able to go back

            //Save our login status
            sharedPreferencesConfigurations.writeLoginStatus(true);

            Toast.makeText(LoginActivity.this, "Login successful", Toast.LENGTH_SHORT).show();

        }else {
            Toast.makeText(LoginActivity.this, "Login failed due to unknown error...Try again", Toast.LENGTH_SHORT).show();
            //Remove values from text fields
            etUserName.setText("");
            etPassword.setText("");
        }

    }//-----------------------------------./Method to login user-------------------------------//


}  //-----------------------------------LoginActivity extends AppCompatActivity-------------------------------//
