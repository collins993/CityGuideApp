package com.example.cityguideapp.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cityguideapp.R;
import com.google.android.material.textfield.TextInputLayout;

import java.util.Objects;

public class Signup extends AppCompatActivity {

    public static final String FULL_NAME = "full-name";
    public static final String USER_NAME = "user-name";
    public static final String EMAIL = "email";
    public static final String PASSWORD = "password";

    ImageView imageView;
    TextView signUpTitle;
    Button signUpNextBtn, signUpLoginButton;
    TextInputLayout fullName, userName, email, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_signup);
        //initializations
        imageView = findViewById(R.id.sign_up_back_button);
        signUpTitle = findViewById(R.id.sign_up_title);
        signUpNextBtn = findViewById(R.id.sign_up_next_btn);
        signUpLoginButton = findViewById(R.id.sign_up_login_btn);
        fullName = findViewById(R.id.sign_up_full_name);
        userName = findViewById(R.id.sign_up_user_name);
        email = findViewById(R.id.sign_up_email);
        password = findViewById(R.id.sign_up_password);


    }

    public void goingBack(View view) {
        Signup.super.onBackPressed();

    }

    public void callNextSignUpScreen(View view) {

        if (!validateFullName() | !validateUserName() | !validateEmail() |!validatePassword()){
            return;
        }

        String fName = fullName.getEditText().getText().toString().trim();
        String uName = userName.getEditText().getText().toString().trim();
        String myEmail = email.getEditText().getText().toString().trim();
        String myPass = password.getEditText().getText().toString().trim();

        Intent intent = new Intent(Signup.this, Signup2ndClass.class);
        intent.putExtra(FULL_NAME, fName);
        intent.putExtra(USER_NAME, uName);
        intent.putExtra(EMAIL, myEmail);
        intent.putExtra(PASSWORD, myPass);

        //Add Transition
        Pair[] pairs = new Pair[4];
        pairs[0] = new Pair<View, String>(imageView, "transition_back_btn");
        pairs[1] = new Pair<View, String>(signUpTitle, "transition_title_text");
        pairs[2] = new Pair<View, String>(signUpNextBtn, "transition_next_btn");
        pairs[3] = new Pair<View, String>(signUpLoginButton, "transition_login_btn");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Signup.this, pairs);
        startActivity(intent, options.toBundle());


    }

    private boolean validateFullName() {
        String val = Objects.requireNonNull(fullName.getEditText()).getText().toString().trim();
        if (val.isEmpty()) {
            fullName.setError("Field can not be empty");
            return false;
        } else {
            fullName.setError(null);
            fullName.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateUserName() {
        String val = Objects.requireNonNull(userName.getEditText()).getText().toString().trim();
        String checkSpaces = "\\A\\w{1,20}\\z";

        if (val.isEmpty()) {
            userName.setError("Field can not be empty");
            return false;
        } else if (val.length() > 20) {
            userName.setError("Username can not be more than 20.");
            return false;
        } else if (!val.matches(checkSpaces)) {
            userName.setError("No white spaces for username");
            return false;
        } else {
            userName.setError(null);
            userName.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validateEmail() {
        String val = email.getEditText().getText().toString().trim();
        String checkEmail = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()) {
            email.setError("Field can not be empty");
            return false;
        }
        else if (!val.matches(checkEmail)) {
            email.setError("Invalid Email");
            return false;
        }
        else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }
    }

    private boolean validatePassword() {
        String val = password.getEditText().getText().toString().trim();
        String checkPassword = "^" +
                "(?=.*[0-9])" +             //at least 1 digit
                "(?=.*[a-z])" +             //at least 1 lower case letter
                "(?=.*[A-Z])" +             //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +          //any letter
                "(?=.*[@#$%^&+=])" +        //at least 1 special character
                "(?=\\S+$)" +               //no white spaces
                ".{4,}" +                   //at least 4 characters
                "$";

        if (val.isEmpty()) {
            password.setError("Field can not be empty");
            return false;
        }
        else if (!val.matches(checkPassword)) {
            password.setError("Password should contain atleast 4 characters and 1 upper and lower case and i special char");
            return false;
        }
        else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }
    }


}