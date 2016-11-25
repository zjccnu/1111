package com.example.administrator.homework1;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.AdapterView;
import android.widget.ImageView;

public class LuncherActivity extends AppCompatActivity {
  private  ImageView imageView=null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_luncher);
        imageView=(ImageView)findViewById(R.id.splash);
        ObjectAnimator objectAnimator=ObjectAnimator.ofFloat(imageView,"alpha",0f,1f);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
        objectAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                startActivity(new Intent(LuncherActivity.this,MainActivity.class));
                finish();
            }
        });



    }




}
