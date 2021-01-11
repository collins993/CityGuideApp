package com.example.cityguideapp.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;


import com.example.cityguideapp.R;
import com.google.android.material.textfield.TextInputLayout;
import com.hbb20.CountryCodePicker;

import static com.example.cityguideapp.Common.LoginSignup.Signup.EMAIL;
import static com.example.cityguideapp.Common.LoginSignup.Signup.FULL_NAME;
import static com.example.cityguideapp.Common.LoginSignup.Signup.PASSWORD;
import static com.example.cityguideapp.Common.LoginSignup.Signup.USER_NAME;
import static com.example.cityguideapp.Common.LoginSignup.Signup2ndClass.DATE;
import static com.example.cityguideapp.Common.LoginSignup.Signup2ndClass.GENDER;

public class Signup3rdClass extends AppCompatActivity {
    public static final String PHONE_NO = "phone_number";

    TextInputLayout phoneNumber;
    CountryCodePicker countryCodePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_signup3rd_class);
        //initialization
        phoneNumber = findViewById(R.id.sign_up_phone_number);
        countryCodePicker = findViewById(R.id.country_code_picker);
    }

    public void goingBack(View view) {
        Signup3rdClass.super.onBackPressed();

    }

    public void callVerifyOTPScreen(View view) {
        if (!validatePhoneNumber())
        return;


        String name = getIntent().getStringExtra(FULL_NAME);
        String username = getIntent().getStringExtra(USER_NAME);
        String email = getIntent().getStringExtra(EMAIL);
        String password = getIntent().getStringExtra(PASSWORD);
        String gender = getIntent().getStringExtra(GENDER);
        String date = getIntent().getStringExtra(DATE);

        String _userPhoneNumber = phoneNumber.getEditText().getText().toString().trim();
//        String phoneNo = "+" + countryCodePicker.getFullNumber() + _userPhoneNumber;


        Intent intent = new Intent(Signup3rdClass.this, VerifyOTP.class);
        intent.putExtra(FULL_NAME, name);
        intent.putExtra(USER_NAME, username);
        intent.putExtra(EMAIL, email);
        intent.putExtra(PASSWORD, password);
        intent.putExtra(GENDER, gender);
        intent.putExtra(DATE, date);
        intent.putExtra(PHONE_NO, _userPhoneNumber);

        startActivity(intent);
    }

    private boolean validatePhoneNumber() {
        String val = phoneNumber.getEditText().getText().toString();


            if (val.isEmpty()){
                phoneNumber.setError("Field cannot be empty");
                return false;
            }
            else{
                phoneNumber.setError(null);
                return true;
            }



    }

    

}