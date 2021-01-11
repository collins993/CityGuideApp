package com.example.cityguideapp.Common;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.cityguideapp.R;
import com.example.cityguideapp.User.UserDashboard;

public class SplashScreen extends AppCompatActivity {

    private static int SPLASH_TIMER = 5000;

    LinearLayout layoutMove;
    Animation sideAnim, bottomAnim;
    SharedPreferences onBoardingSharedPref;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );
        //Initialization
        layoutMove = findViewById(R.id.layout_move);
        sideAnim = AnimationUtils.loadAnimation(this, R.anim.side_anim);
        bottomAnim = AnimationUtils.loadAnimation(this, R.anim.bottom_anim);
        //Assign to Elements
        layoutMove.setAnimation(sideAnim);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                onBoardingSharedPref = getSharedPreferences("onBoardingScreen", MODE_PRIVATE);
                boolean isFirstTime = onBoardingSharedPref.getBoolean("firstTime", true);
                if (isFirstTime){
                    editor = onBoardingSharedPref.edit();
                    editor.putBoolean("firstTime", false);
                    editor.apply();

                    startActivity(new Intent(SplashScreen.this, OnBoarding.class));
                    finish();
                }
                else {
                    startActivity(new Intent(SplashScreen.this, UserDashboard.class));
                    finish();
                }


            }
        },SPLASH_TIMER);

    }
}