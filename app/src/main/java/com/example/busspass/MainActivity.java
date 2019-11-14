package com.example.busspass;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity   {

    private DrawerLayout mDrawerLayout;
    private NavController navController;
    private ActionBarDrawerToggle mToggle;
    private  AppBarConfiguration appBarConfiguration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDrawerLayout=(DrawerLayout) findViewById(R.id.drawerLayout);
        NavigationView navigationView=(NavigationView) findViewById(R.id.nav_view);
      // navigationView.setNavigationItemSelectedListener(this);

        navController=Navigation.findNavController(this,R.id.nav_host);
        appBarConfiguration =
                new AppBarConfiguration.Builder(new int[]{R.id.home,R.id.buybuspass,R.id.transactions,R.id.busTimePdf,R.id.reminder,R.id.logout})
                        .setDrawerLayout(mDrawerLayout)
                        .build();

        NavigationUI.setupWithNavController(navigationView,navController);
        NavigationUI.setupActionBarWithNavController(this,navController,appBarConfiguration);
//        mToggle=new ActionBarDrawerToggle(this,mDrawerLayout,R.string.open,R.string.close);
//        mDrawerLayout.addDrawerListener(mToggle);
//        mToggle.syncState();
//
//      getSupportActionBar().setDisplayHomeAsUpEnabled(true);
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
