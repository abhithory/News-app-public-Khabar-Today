package com.sanapps.publickhabartoday;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Animatable;
import android.media.Image;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class SplashActivity extends AppCompatActivity {


    Animation fadeAni;
    ImageView logoImg, img2;
    TextView logoText;

    private static final long SPLASH_SCREEN_TIME_OUT = 2400;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        //This method is used so that your splash activity
        //can cover the entire screen.
        setContentView(R.layout.activity_splash);
        logoText = findViewById(R.id.logo_text_splash);
        logoImg = findViewById(R.id.logo_img_splash);
        img2 = findViewById(R.id.img_splash);
        fadeAni = AnimationUtils.loadAnimation(this, R.anim.fade_tansication);
        logoText.setAnimation(fadeAni);
        img2.setAnimation(fadeAni);
        logoImg.setAnimation(fadeAni);

        //this will bind your MainActivity.class file with activity_main.

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                Intent i = new Intent(SplashActivity.this,
                        MainActivity.class);
                //Intent is used to switch from one activity to another.

                startActivity(i);

                overridePendingTransition(R.transition.fadein, R.transition.fadeout);
                //invoke the SecondActivity.

                finish();
                //the current activity will get finished.
            }
        }, SPLASH_SCREEN_TIME_OUT);
    }


}

