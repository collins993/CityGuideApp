package com.example.cityguideapp.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.cityguideapp.Common.LoginSignup.RetailerStartUpScreen;
import com.example.cityguideapp.HelperClasses.HomeAdapter.CategoryAdapterClass;
import com.example.cityguideapp.HelperClasses.HomeAdapter.CategoryHelperClass;
import com.example.cityguideapp.HelperClasses.HomeAdapter.FeaturedAdapterClass;
import com.example.cityguideapp.HelperClasses.HomeAdapter.FeaturedHelperClass;
import com.example.cityguideapp.HelperClasses.HomeAdapter.MostViewedAdapterClass;
import com.example.cityguideapp.R;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class UserDashboard extends AppCompatActivity {

    public static final float END_SCALE = 0.7f;

    RecyclerView featuredRecycler, mostViewedRecycler, categoriesRecycler;
    FeaturedAdapterClass adapterClass;
    MostViewedAdapterClass mostViewedAdapterClass;
    CategoryAdapterClass categoryAdapterClass;
    ImageView menuIcon;
    LinearLayout contentView;

    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_user_dashboard);

        //initialization
        featuredRecycler = findViewById(R.id.featured_recycler);
        mostViewedRecycler = findViewById(R.id.mv_recycler);
        categoriesRecycler = findViewById(R.id.categories_recycler);
        menuIcon = findViewById(R.id.menu_icon);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.navigation_view);
        contentView = findViewById(R.id.content);

        navigationDrawer();

        featuredRecycler();

        mostViewedRecycler();

        categoriesRecycler();

    }

    public void callRetailerScreen(View view) {
        startActivity(new Intent(UserDashboard.this, RetailerStartUpScreen.class));
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerVisible(GravityCompat.START))
            drawerLayout.closeDrawer(GravityCompat.START);
        else
            super.onBackPressed();

    }

    private void navigationDrawer() {
        navigationView.bringToFront();
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {

                    case R.id.nav_all_categories:
                        startActivity(new Intent(UserDashboard.this, AllCategories.class));
                        break;
                }
                return true;
            }
        });
        navigationView.setCheckedItem(R.id.nav_home);

        menuIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (drawerLayout.isDrawerVisible(GravityCompat.START))
                    drawerLayout.closeDrawer(GravityCompat.START);
                else
                    drawerLayout.openDrawer(GravityCompat.START);

            }
        });

        animateNavigationDrawer();
    }

    private void animateNavigationDrawer() {
        drawerLayout.setScrimColor(getResources().getColor(R.color.purple_700));
        drawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {
                //Scale the view based on current slide effect
                final float diffScaleOffset = slideOffset * (1 - END_SCALE);
                final float offsetScale = 1 - diffScaleOffset;
                contentView.setScaleX(offsetScale);
                contentView.setScaleY(offsetScale);
                //Translate the view accounting for scaled width
                final float xOffset = drawerView.getWidth() * slideOffset;
                final float xOffsetDiff = contentView.getWidth() * diffScaleOffset / 2;
                final float xTranslation = xOffset - xOffsetDiff;
                contentView.setTranslationX(xTranslation);
            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }


        });
    }

    private void categoriesRecycler() {
        categoriesRecycler.setHasFixedSize(true);
        categoriesRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<CategoryHelperClass> categoryLocation = new ArrayList<>();

        categoryLocation.add(new CategoryHelperClass(R.drawable.education_category, "Education"));
        categoryLocation.add(new CategoryHelperClass(R.drawable.hospital_category, "Hospitals"));
        categoryLocation.add(new CategoryHelperClass(R.drawable.restaurant_category, "Restaurants"));

        categoryAdapterClass = new CategoryAdapterClass(categoryLocation);
        categoriesRecycler.setAdapter(categoryAdapterClass);

    }

    private void mostViewedRecycler() {
        mostViewedRecycler.setHasFixedSize(true);
        mostViewedRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<FeaturedHelperClass> featuredCatLocation = new ArrayList<>();

        featuredCatLocation.add(new FeaturedHelperClass(R.drawable.featured_location_1, "Mega Chicken", "This is a quick service eatery where you can branch and get your meals or relax and enjoy the variety of offers they have displayed for you."));
        featuredCatLocation.add(new FeaturedHelperClass(R.drawable.featured_location_2, "Dominos", "Order pizza, pasta, sandwiches & more online for carryout or delivery from Domino's. View menu, find locations, track orders."));
        featuredCatLocation.add(new FeaturedHelperClass(R.drawable.featured_location_3, "Ikeja Mall", "Welcome to Ikeja City Mall. DISCOVER MORE . UPDATES ON VISITING THE CENTRE All you need is here under one roof. Explore more 12 RESTAURANTS 12 RESTAURANTS Over 100 shops ."));

        mostViewedAdapterClass = new MostViewedAdapterClass(featuredCatLocation);
        mostViewedRecycler.setAdapter(mostViewedAdapterClass);
    }

    private void featuredRecycler() {
        featuredRecycler.setHasFixedSize(true);
        featuredRecycler.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        ArrayList<FeaturedHelperClass> featuredLocation = new ArrayList<>();

        featuredLocation.add(new FeaturedHelperClass(R.drawable.featured_location_1, "Mega Chicken", "This is a quick service eatery where you can branch and get your meals or relax and enjoy the variety of offers they have displayed for you."));
        featuredLocation.add(new FeaturedHelperClass(R.drawable.featured_location_2, "Dominos", "Order pizza, pasta, sandwiches & more online for carryout or delivery from Domino's. View menu, find locations, track orders."));
        featuredLocation.add(new FeaturedHelperClass(R.drawable.featured_location_3, "Ikeja Mall", "Welcome to Ikeja City Mall. DISCOVER MORE . UPDATES ON VISITING THE CENTRE All you need is here under one roof. Explore more 12 RESTAURANTS 12 RESTAURANTS Over 100 shops ."));

        adapterClass = new FeaturedAdapterClass(featuredLocation);
        featuredRecycler.setAdapter(adapterClass);


    }
}