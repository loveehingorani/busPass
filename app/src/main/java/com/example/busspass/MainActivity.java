package com.example.busspass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity   {

    private TextView mUserName;
    private DrawerLayout mDrawerLayout;
    private NavController navController;
    MondayDatabaseHelper mondaydb;
    TuesdayDatabaseHelper tuesdaydb;
    WednesdayDatabaseHelper wednesdaydb;
    ThursdayDatabaseHelper thursdaydb;
    FridayDatabaseHelper fridaydb;
    SaturdayDatabaseHelper saturdaydb;
    SundayDatabaseHelper sundaydb;
    private ActionBarDrawerToggle mToggle;
    private  AppBarConfiguration appBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mondaydb= new MondayDatabaseHelper(this);
        tuesdaydb=new TuesdayDatabaseHelper(this);
        wednesdaydb=new WednesdayDatabaseHelper(this);
        thursdaydb=new ThursdayDatabaseHelper(this);
        fridaydb=new FridayDatabaseHelper(this);
        saturdaydb=new SaturdayDatabaseHelper(this);
        sundaydb=new SundayDatabaseHelper(this);

        mDrawerLayout=(DrawerLayout) findViewById(R.id.drawerLayout);
        NavigationView navigationView=(NavigationView) findViewById(R.id.nav_view);
      // navigationView.setNavigationItemSelectedListener(this);

        mUserName=(TextView) findViewById(R.id.usernamedisplay);
       // mUserName.setText();
        View headView =navigationView.getHeaderView(0);

        mUserName=(TextView) headView.findViewById(R.id.usernamedisplay);

        mUserName.setText(FirebaseAuth.getInstance().getCurrentUser().getDisplayName());
        navController=Navigation.findNavController(this,R.id.nav_host);
        appBarConfiguration =
                new AppBarConfiguration.Builder(new int[]{R.id.home,R.id.buybuspass,R.id.transactions,R.id.busTimePdf,R.id.reminder,R.id.logout,R.id.aboutus})
                        .setDrawerLayout(mDrawerLayout)
                        .build();
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_SMS) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_SMS, Manifest.permission.RECEIVE_SMS}, 101);
//        }
        mondaydb.insertData("1","07:00 AM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        mondaydb.insertData("2","07:00 AM", "Chomu Puliya", "LNMIIT", "Government Bus",false,false);
        mondaydb.insertData("3","08:00 AM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        mondaydb.insertData("4","08:00 AM", "Ajmeri Gate", "LNMIIT", "Government Bus",false,false);
        mondaydb.insertData("5","08:45 AM", "LNMIIT", "Nai Ki Thadi", "Government Bus",false,false);
        mondaydb.insertData("6","09:10 AM", "Nai Ki Thadi", "LNMIIT", "Government Bus",false,false);
        mondaydb.insertData("7","09:15 AM", "LNMIIT", "Chomu Puliya", "Government Bus",false,false);
        mondaydb.insertData("8","11:00 AM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service",false, false);
        mondaydb.insertData("9","11:15 AM", "Chomu Puliya", "LNMIIT", "Government Bus",false,false);
        mondaydb.insertData("10","12:00 PM", "Ajmeri Gate", "LNMIIT", "Government Bus",false,false);
        mondaydb.insertData("11","12:45 PM", "LNMIIT", "Nai Ki Thadi", "Government Bus",false,false);
        mondaydb.insertData("12","01:25 PM", "Nai Ki Thadi", "LNMIIT", "Government Bus",false,false);
        mondaydb.insertData("13","01:30 PM", "LNMIIT", "Chomu Puliya", "Government Bus",false,false);
        mondaydb.insertData("14","01:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        mondaydb.insertData("15","03:05 PM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service",false, false);
        mondaydb.insertData("16","03:30 PM", "Chomu Puliya", "LNMIIT", "Government Bus",false,false);
        mondaydb.insertData("17","04:00 PM", "Ajmeri Gate", "LNMIIT", "Government Bus",false,false);
        mondaydb.insertData("18","04:45 PM", "LNMIIT", "Nai Ki Thadi", "Government Bus",false,false);
        mondaydb.insertData("19","05:00 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false, false);
        mondaydb.insertData("20","05:20 PM", "Nai Ki Thadi", "LNMIIT", "Government Bus",false,false);
        mondaydb.insertData("21","05:30 PM", "LNMIIT", "Chomu Puliya", "Government Bus",false,false);
        mondaydb.insertData("22","06:15 PM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service",false, false);
        mondaydb.insertData("23","06:30 PM", "LNMIIT", "Raja Park", "LNMIIT Bus Service",false, false);
        mondaydb.insertData("24","07:00 PM", "LNMIIT", "Raja Park", "LNMIIT Bus Service",false, false);
        mondaydb.insertData("25","07:15 PM", "Raja Park", "LNMIIT", "LNMIIT Bus Service",false,false);
        mondaydb.insertData("26","08:05 PM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service",false,false);
        mondaydb.insertData("27","08:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        mondaydb.insertData("28","09:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        mondaydb.insertData("29","09:45 PM", "Raja Park", "LNMIIT", "LNMIIT Bus Service",false,false);

//Tuesday
        tuesdaydb.insertData("1","07:00 AM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        tuesdaydb.insertData("2","07:00 AM", "Chomu Puliya", "LNMIIT", "Government Bus",false,false);
        tuesdaydb.insertData("3","08:00 AM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        tuesdaydb.insertData("4","08:00 AM", "Ajmeri Gate", "LNMIIT", "Government Bus",false,false);
        tuesdaydb.insertData("5","08:45 AM", "LNMIIT", "Nai Ki Thadi", "Government Bus",false,false);
        tuesdaydb.insertData("6","09:10 AM", "Nai Ki Thadi", "LNMIIT", "Government Bus",false,false);
        tuesdaydb.insertData("7","09:15 AM", "LNMIIT", "Chomu Puliya", "Government Bus",false,false);
        tuesdaydb.insertData("8","11:00 AM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service",false, false);
        tuesdaydb.insertData("9","11:15 AM", "Chomu Puliya", "LNMIIT", "Government Bus",false,false);
        tuesdaydb.insertData("10","12:00 PM", "Ajmeri Gate", "LNMIIT", "Government Bus",false,false);
        tuesdaydb.insertData("11","12:45 PM", "LNMIIT", "Nai Ki Thadi", "Government Bus",false,false);
        tuesdaydb.insertData("12","01:25 PM", "Nai Ki Thadi", "LNMIIT", "Government Bus",false,false);
        tuesdaydb.insertData("13","01:30 PM", "LNMIIT", "Chomu Puliya", "Government Bus",false,false);
        tuesdaydb.insertData("14","01:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        tuesdaydb.insertData("15","03:05 PM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service",false, false);
        tuesdaydb.insertData("16","03:30 PM", "Chomu Puliya", "LNMIIT", "Government Bus",false,false);
        tuesdaydb.insertData("17","04:00 PM", "Ajmeri Gate", "LNMIIT", "Government Bus",false,false);
        tuesdaydb.insertData("18","04:45 PM", "LNMIIT", "Nai Ki Thadi", "Government Bus",false,false);
        tuesdaydb.insertData("19","05:00 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false, false);
        tuesdaydb.insertData("20","05:20 PM", "Nai Ki Thadi", "LNMIIT", "Government Bus",false,false);
        tuesdaydb.insertData("21","05:30 PM", "LNMIIT", "Chomu Puliya", "Government Bus",false,false);
        tuesdaydb.insertData("22","06:15 PM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service",false, false);
        tuesdaydb.insertData("23","06:30 PM", "LNMIIT", "Raja Park", "LNMIIT Bus Service",false, false);
        tuesdaydb.insertData("24","07:00 PM", "LNMIIT", "Raja Park", "LNMIIT Bus Service",false, false);
        tuesdaydb.insertData("25","07:15 PM", "Raja Park", "LNMIIT", "LNMIIT Bus Service",false,false);
        tuesdaydb.insertData("26","08:05 PM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service",false,false);
        tuesdaydb.insertData("27","08:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        tuesdaydb.insertData("28","09:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        tuesdaydb.insertData("29","09:45 PM", "Raja Park", "LNMIIT", "LNMIIT Bus Service",false,false);

        wednesdaydb.insertData("1","07:00 AM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        wednesdaydb.insertData("2","07:00 AM", "Chomu Puliya", "LNMIIT", "Government Bus",false,false);
        wednesdaydb.insertData("3","08:00 AM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        wednesdaydb.insertData("4","08:00 AM", "Ajmeri Gate", "LNMIIT", "Government Bus",false,false);
        wednesdaydb.insertData("5","08:45 AM", "LNMIIT", "Nai Ki Thadi", "Government Bus",false,false);
        wednesdaydb.insertData("6","09:10 AM", "Nai Ki Thadi", "LNMIIT", "Government Bus",false,false);
        wednesdaydb.insertData("7","09:15 AM", "LNMIIT", "Chomu Puliya", "Government Bus",false,false);
        wednesdaydb.insertData("8","11:00 AM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service",false, false);
        wednesdaydb.insertData("9","11:15 AM", "Chomu Puliya", "LNMIIT", "Government Bus",false,false);
        wednesdaydb.insertData("10","12:00 PM", "Ajmeri Gate", "LNMIIT", "Government Bus",false,false);
        wednesdaydb.insertData("11","12:45 PM", "LNMIIT", "Nai Ki Thadi", "Government Bus",false,false);
        wednesdaydb.insertData("12","01:25 PM", "Nai Ki Thadi", "LNMIIT", "Government Bus",false,false);
        wednesdaydb.insertData("13","01:30 PM", "LNMIIT", "Chomu Puliya", "Government Bus",false,false);
        wednesdaydb.insertData("14","01:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        wednesdaydb.insertData("15","03:05 PM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service",false, false);
        wednesdaydb.insertData("16","03:30 PM", "Chomu Puliya", "LNMIIT", "Government Bus",false,false);
        wednesdaydb.insertData("17","04:00 PM", "Ajmeri Gate", "LNMIIT", "Government Bus",false,false);
        wednesdaydb.insertData("18","04:45 PM", "LNMIIT", "Nai Ki Thadi", "Government Bus",false,false);
        wednesdaydb.insertData("19","05:00 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false, false);
        wednesdaydb.insertData("20","05:20 PM", "Nai Ki Thadi", "LNMIIT", "Government Bus",false,false);
        wednesdaydb.insertData("21","05:30 PM", "LNMIIT", "Chomu Puliya", "Government Bus",false,false);
        wednesdaydb.insertData("22","06:15 PM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service",false, false);
        wednesdaydb.insertData("23","06:30 PM", "LNMIIT", "Raja Park", "LNMIIT Bus Service",false, false);
        wednesdaydb.insertData("24","07:00 PM", "LNMIIT", "Raja Park", "LNMIIT Bus Service",false, false);
        wednesdaydb.insertData("25","07:15 PM", "Raja Park", "LNMIIT", "LNMIIT Bus Service",false,false);
        wednesdaydb.insertData("26","08:05 PM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service",false,false);
        wednesdaydb.insertData("27","08:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        wednesdaydb.insertData("28","09:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        wednesdaydb.insertData("29","09:45 PM", "Raja Park", "LNMIIT", "LNMIIT Bus Service",false,false);

        thursdaydb.insertData("1","07:00 AM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        thursdaydb.insertData("2","07:00 AM", "Chomu Puliya", "LNMIIT", "Government Bus",false,false);
        thursdaydb.insertData("3","08:00 AM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        thursdaydb.insertData("4","08:00 AM", "Ajmeri Gate", "LNMIIT", "Government Bus",false,false);
        thursdaydb.insertData("5","08:45 AM", "LNMIIT", "Nai Ki Thadi", "Government Bus",false,false);
        thursdaydb.insertData("6","09:10 AM", "Nai Ki Thadi", "LNMIIT", "Government Bus",false,false);
        thursdaydb.insertData("7","09:15 AM", "LNMIIT", "Chomu Puliya", "Government Bus",false,false);
        thursdaydb.insertData("8","11:00 AM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service",false, false);
        thursdaydb.insertData("9","11:15 AM", "Chomu Puliya", "LNMIIT", "Government Bus",false,false);
        thursdaydb.insertData("10","12:00 PM", "Ajmeri Gate", "LNMIIT", "Government Bus",false,false);
        thursdaydb.insertData("11","12:45 PM", "LNMIIT", "Nai Ki Thadi", "Government Bus",false,false);
        thursdaydb.insertData("12","01:25 PM", "Nai Ki Thadi", "LNMIIT", "Government Bus",false,false);
        thursdaydb.insertData("13","01:30 PM", "LNMIIT", "Chomu Puliya", "Government Bus",false,false);
        thursdaydb.insertData("14","01:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        thursdaydb.insertData("15","03:05 PM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service",false, false);
        thursdaydb.insertData("16","03:30 PM", "Chomu Puliya", "LNMIIT", "Government Bus",false,false);
        thursdaydb.insertData("17","04:00 PM", "Ajmeri Gate", "LNMIIT", "Government Bus",false,false);
        thursdaydb.insertData("18","04:45 PM", "LNMIIT", "Nai Ki Thadi", "Government Bus",false,false);
        thursdaydb.insertData("19","05:00 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false, false);
        thursdaydb.insertData("20","05:20 PM", "Nai Ki Thadi", "LNMIIT", "Government Bus",false,false);
        thursdaydb.insertData("21","05:30 PM", "LNMIIT", "Chomu Puliya", "Government Bus",false,false);
        thursdaydb.insertData("22","06:15 PM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service",false, false);
        thursdaydb.insertData("23","06:30 PM", "LNMIIT", "Raja Park", "LNMIIT Bus Service",false, false);
        thursdaydb.insertData("24","07:00 PM", "LNMIIT", "Raja Park", "LNMIIT Bus Service",false, false);
        thursdaydb.insertData("25","07:15 PM", "Raja Park", "LNMIIT", "LNMIIT Bus Service",false,false);
        thursdaydb.insertData("26","08:05 PM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service",false,false);
        thursdaydb.insertData("27","08:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        thursdaydb.insertData("28","09:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        thursdaydb.insertData("29","09:45 PM", "Raja Park", "LNMIIT", "LNMIIT Bus Service",false,false);

        fridaydb.insertData("1","07:00 AM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        fridaydb.insertData("2","07:00 AM", "Chomu Puliya", "LNMIIT", "Government Bus",false,false);
        fridaydb.insertData("3","08:00 AM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        fridaydb.insertData("4","08:00 AM", "Ajmeri Gate", "LNMIIT", "Government Bus",false,false);
        fridaydb.insertData("5","08:45 AM", "LNMIIT", "Nai Ki Thadi", "Government Bus",false,false);
        fridaydb.insertData("6","09:10 AM", "Nai Ki Thadi", "LNMIIT", "Government Bus",false,false);
        fridaydb.insertData("7","09:15 AM", "LNMIIT", "Chomu Puliya", "Government Bus",false,false);
        fridaydb.insertData("8","11:00 AM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service",false, false);
        fridaydb.insertData("9","11:15 AM", "Chomu Puliya", "LNMIIT", "Government Bus",false,false);
        fridaydb.insertData("10","12:00 PM", "Ajmeri Gate", "LNMIIT", "Government Bus",false,false);
        fridaydb.insertData("11","12:45 PM", "LNMIIT", "Nai Ki Thadi", "Government Bus",false,false);
        fridaydb.insertData("12","01:25 PM", "Nai Ki Thadi", "LNMIIT", "Government Bus",false,false);
        fridaydb.insertData("13","01:30 PM", "LNMIIT", "Chomu Puliya", "Government Bus",false,false);
        fridaydb.insertData("14","01:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        fridaydb.insertData("15","03:05 PM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service",false, false);
        fridaydb.insertData("16","03:30 PM", "Chomu Puliya", "LNMIIT", "Government Bus",false,false);
        fridaydb.insertData("17","04:00 PM", "Ajmeri Gate", "LNMIIT", "Government Bus",false,false);
        fridaydb.insertData("18","04:45 PM", "LNMIIT", "Nai Ki Thadi", "Government Bus",false,false);
        fridaydb.insertData("19","05:00 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false, false);
        fridaydb.insertData("20","05:20 PM", "Nai Ki Thadi", "LNMIIT", "Government Bus",false,false);
        fridaydb.insertData("21","05:30 PM", "LNMIIT", "Chomu Puliya", "Government Bus",false,false);
        fridaydb.insertData("22","06:15 PM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service",false, false);
        fridaydb.insertData("23","06:30 PM", "LNMIIT", "Raja Park", "LNMIIT Bus Service",false, false);
        fridaydb.insertData("24","07:00 PM", "LNMIIT", "Raja Park", "LNMIIT Bus Service",false, false);
        fridaydb.insertData("25","07:15 PM", "Raja Park", "LNMIIT", "LNMIIT Bus Service",false,false);
        fridaydb.insertData("26","08:05 PM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service",false,false);
        fridaydb.insertData("27","08:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        fridaydb.insertData("28","09:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        fridaydb.insertData("29","09:45 PM", "Raja Park", "LNMIIT", "LNMIIT Bus Service",false,false);


        saturdaydb.insertData("1","07:00 AM", "Chomu Puliya", "LNMIIT", "Government Bus",false,false);
        saturdaydb.insertData("2","08:00 AM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        saturdaydb.insertData("3","08:00 AM", "Ajmeri Gate", "LNMIIT", "Government Bus",false,false);
        saturdaydb.insertData("4","08:45 AM", "LNMIIT", "Nai Ki Thadi", "Government Bus",false,false);
        saturdaydb.insertData("5","09:10 AM", "Nai Ki Thadi", "LNMIIT", "Government Bus",false,false);
        saturdaydb.insertData("6","09:15 AM", "LNMIIT", "Chomu Puliya", "Government Bus",false,false);
        saturdaydb.insertData("7","10:00 AM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service",false,false);
        saturdaydb.insertData("8","11:15 AM", "Chomu Puliya", "LNMIIT", "Government Bus",false,false);
        saturdaydb.insertData("9","12:00 PM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service",false,false);
        saturdaydb.insertData("10","12:00 PM", "Ajmeri Gate", "LNMIIT", "Government Bus",false,false);
        saturdaydb.insertData("11","12:45 PM", "LNMIIT", "Nai Ki Thadi", "Government Bus",false,false);
        saturdaydb.insertData("12","01:25 PM", "Nai Ki Thadi", "LNMIIT", "Government Bus",false,false);
        saturdaydb.insertData("13","01:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        saturdaydb.insertData("14","01:30 PM", "LNMIIT", "Chomu Puliya", "Government Bus",false,false);
        saturdaydb.insertData("15","03:00 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        saturdaydb.insertData("16","03:30 PM", "Chomu Puliya", "LNMIIT", "Government Bus",false,false);
        saturdaydb.insertData("17","03:30 PM", "LNMIIT", "Raja Park", "LNMIIT Bus Service",false,false);
        saturdaydb.insertData("18","04:00 PM", "Ajmeri Gate", "LNMIIT", "Government Bus",false,false);
        saturdaydb.insertData("19","04:15 PM", "LNMIIT", "Raja Park", "LNMIIT Bus Service",false,false);
        saturdaydb.insertData("20","04:30 PM", "Raja Park", "LNMIIT", "LNMIIT Bus Service",false,false);
        saturdaydb.insertData("21","04:45 PM", "LNMIIT", "Nai Ki Thadi", "Government Bus",false,false);
        saturdaydb.insertData("22","05:20 PM", "Nai Ki Thadi", "LNMIIT", "Government Bus",false,false);
        saturdaydb.insertData("23","05:30 PM", "LNMIIT", "Chomu Puliya", "Government Bus",false,false);
        saturdaydb.insertData("24","05:30 PM", "Raja Park", "LNMIIT", "LNMIIT Bus Service",false,false);
        saturdaydb.insertData("25","06:15 PM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service",false,false);
        saturdaydb.insertData("26","06:30 PM", "LNMIIT", "Raja Park", "LNMIIT Bus Service",false,false);
        saturdaydb.insertData("27","07:00 PM", "LNMIIT", "Raja Park", "LNMIIT Bus Service",false,false);
        saturdaydb.insertData("28","07:15 PM", "Raja Park", "LNMIIT", "LNMIIT Bus Service",false,false);
        saturdaydb.insertData("29","07:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        saturdaydb.insertData("30","08:05 PM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service",false,false);
        saturdaydb.insertData("31","09:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        saturdaydb.insertData("32","09:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        saturdaydb.insertData("33","09:45 PM", "Raja Park", "LNMIIT", "LNMIIT Bus Service",false,false);


        sundaydb.insertData("1","08:00 AM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        sundaydb.insertData("2","10:00 AM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service",false,false);
        sundaydb.insertData("3","12:00 PM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service",false,false);
        sundaydb.insertData("4","01:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        sundaydb.insertData("5","03:00 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        sundaydb.insertData("6","03:30 PM", "LNMIIT", "Raja Park", "LNMIIT Bus Service",false,false);
        sundaydb.insertData("7","04:15 PM", "LNMIIT", "Raja Park", "LNMIIT Bus Service",false,false);
        sundaydb.insertData("8","04:30 PM", "Raja Park", "LNMIIT", "LNMIIT Bus Service",false,false);
        sundaydb.insertData("9","05:30 PM", "Raja Park", "LNMIIT", "LNMIIT Bus Service",false,false);
        sundaydb.insertData("10","06:15 PM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service",false,false);
        sundaydb.insertData("11","06:30 PM", "LNMIIT", "Raja Park", "LNMIIT Bus Service",false,false);
        sundaydb.insertData("12","07:00 PM", "LNMIIT", "Raja Park", "LNMIIT Bus Service",false,false);
        sundaydb.insertData("13","07:15 PM", "Raja Park", "LNMIIT", "LNMIIT Bus Service",false,false);
        sundaydb.insertData("14","07:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        sundaydb.insertData("15","08:05 PM", "LNMIIT", "Ajmeri Gate", "LNMIIT Bus Service",false,false);
        sundaydb.insertData("16","09:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        sundaydb.insertData("17","09:30 PM", "Ajmeri Gate", "LNMIIT", "LNMIIT Bus Service",false,false);
        sundaydb.insertData("18","09:45 PM", "Raja Park", "LNMIIT", "LNMIIT Bus Service",false,false);


        NavigationUI.setupWithNavController(navigationView,navController);
        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration);
//        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
//        mDrawerLayout.addDrawerListener(mToggle);
//        mToggle.syncState();
//
     // getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);
        //getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,new MainPageFragment()).commit();
        //navigationView.setCheckedItem(R.id.buspass);

    }

    @Override
    public boolean onSupportNavigateUp() {
        return NavigationUI.navigateUp(navController,appBarConfiguration);
    }

    @Override
    public void onBackPressed() {
        if(mDrawerLayout.isDrawerOpen(GravityCompat.START))
            mDrawerLayout.closeDrawer(GravityCompat.START);
        else {
            super.onBackPressed();
        }
    }
//    public boolean onNavigationItemSelected(MenuItem item) {
//        int id = item.getItemId();
//
//        if (id == R.id.logout) {
//
//            FirebaseAuth.getInstance().signOut();
//            Intent intent = new Intent(this, LoginActivity.class);
//            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TOP);
//            startActivity(intent);
//            finish();
//        }
//       // DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawerLayout);
//        mDrawerLayout.closeDrawer(GravityCompat.START);
//        return true;
//
//    }
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        if(mToggle.onOptionsItemSelected(item))
//            return true;
//        return super.onOptionsItemSelected(item);
//    }



}
