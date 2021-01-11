package com.example.cityguideapp.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.cityguideapp.R;

import java.util.Calendar;

import static com.example.cityguideapp.Common.LoginSignup.Signup.EMAIL;
import static com.example.cityguideapp.Common.LoginSignup.Signup.FULL_NAME;
import static com.example.cityguideapp.Common.LoginSignup.Signup.PASSWORD;
import static com.example.cityguideapp.Common.LoginSignup.Signup.USER_NAME;

public class Signup2ndClass extends AppCompatActivity {

    public static final String GENDER = "gender";
    public static final String DATE = "date";

    ImageView back;
    TextView title;
    Button login, next;
    RadioGroup radioGroup;
    RadioButton selectedGender;
    DatePicker datePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_signup2nd_class);
        //initialization
        back = findViewById(R.id.sign_up_back_button);
        title = findViewById(R.id.sign_up_title);
        login = findViewById(R.id.sign_up_login_btn);
        next = findViewById(R.id.sign_up_next_btn);
        radioGroup = findViewById(R.id.radio_group);
        datePicker = findViewById(R.id.age_picker);
    }

    public void goingBack(View view) {
        Signup2ndClass.super.onBackPressed();

    }

    public void call3rdSignUpScreen(View view) {

        if (!validateGender() | !validateAge()){
            return;
        }

        selectedGender = findViewById(radioGroup.getCheckedRadioButtonId());
        String gender = selectedGender.getText().toString();
        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();
        String date = day + "/" + month + "/" + year;

        String name = getIntent().getStringExtra(FULL_NAME);
        String username = getIntent().getStringExtra(USER_NAME);
        String email = getIntent().getStringExtra(EMAIL);
        String password = getIntent().getStringExtra(PASSWORD);

        Intent intent = new Intent(Signup2ndClass.this, Signup3rdClass.class);
        intent.putExtra(FULL_NAME, name);
        intent.putExtra(USER_NAME, username);
        intent.putExtra(EMAIL, email);
        intent.putExtra(PASSWORD, password);
        intent.putExtra(GENDER, gender);
        intent.putExtra(DATE, date);

        //Add Transition
        Pair[] pairs = new Pair[4];
        pairs[0] = new Pair<View, String>(back, "transition_back_btn");
        pairs[1] = new Pair<View, String>(title, "transition_title_text");
        pairs[2] = new Pair<View, String>(next, "transition_next_btn");
        pairs[3] = new Pair<View, String>(login, "transition_login_btn");

        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(Signup2ndClass.this, pairs);
        startActivity(intent, options.toBundle());


    }

    private boolean validateGender() {
        if (radioGroup.getCheckedRadioButtonId() == -1) {
            Toast.makeText(this, "Please Select Gender", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }

    private boolean validateAge() {
        int currentYear = Calendar.getInstance().get(Calendar.YEAR);
        int userAge = datePicker.getYear();
        int isAgeValid = currentYear - userAge;

        if (isAgeValid < 14) {
            Toast.makeText(this, "You are not eligible to apply", Toast.LENGTH_SHORT).show();
            return false;
        } else
            return true;
    }
}