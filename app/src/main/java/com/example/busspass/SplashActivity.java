package com.example.busspass;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {
    ProgressBar progressBar;
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);  getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN                                                                      );
        progressBar=findViewById(R.id.progressBar);
        textView=findViewById(R.id.text_view);
        progressBar.setMax(100);
        progressBar.setScaleY(3f);
        progressAnimation();
        ActionBar actionbar = getSupportActionBar();
        actionbar.hide();
    }
    public void progressAnimation(){
        ProgressBarAnimation anim= new ProgressBarAnimation(this, progressBar,textView,0f,100f);
        anim.setDuration(2000);
        progressBar.setAnimation(anim);



    }

}
