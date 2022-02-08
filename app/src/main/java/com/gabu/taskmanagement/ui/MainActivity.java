package com.gabu.taskmanagement.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.gabu.taskmanagement.R;
import com.gabu.taskmanagement.fragments.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import hotchemi.android.rate.AppRate;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        BottomNavigationView bottomNav = findViewById(R.id.bottomNav);
       // bottomNav.setOnNavigationItemSelectedListener(navListener);

        // show rate app prompt
        AppRate.with (this)
                .setInstallDays(1)
                .setLaunchTimes(3)
                .setRemindInterval(2)
                .monitor();
        AppRate.showRateDialogIfMeetsConditions(this);
        // this checks to see if there's any savedInstance, if null, then it replaces the fragment container
        // with home fragment.
        if (savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.fragmentcontainer, new HomeFragment()).commit();
        }



    }
}