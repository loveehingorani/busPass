package com.example.busspass;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import android.widget.ProgressBar;
import android.widget.TextView;

public class ProgressBarAnimation extends Animation {
     Context context;
     ProgressBar progressBar;
     TextView textView;
     float  from;
     float to;

      ProgressBarAnimation(Context context, ProgressBar progressBar, TextView textView, float from , float to){
        this.context=context;
        this.progressBar=progressBar;
        this.textView=textView;
        this.from=from;
        this.to=to;

    }

    @Override
    protected void applyTransformation(float interpolatedTime, Transformation t) {
        super.applyTransformation(interpolatedTime, t);
        float value = from + (to - from) * interpolatedTime;
        int x= (int)value;
        String m="%";
        String s=String.valueOf(x);
        String z=s+m;
        progressBar.setProgress(x);
        textView.setText(z);
        if (value == to) {

        Intent intent= new Intent(context , LoginActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        context.startActivity(intent);
            ((Activity) context).finish();
        }
    }
}
