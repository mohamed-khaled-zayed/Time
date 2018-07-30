package com.binarycase.mohamed.ontime.ui.activity.commen;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.binarycase.mohamed.ontime.R;
import com.binarycase.mohamed.ontime.utils.LocaleHelper;
import com.binarycase.mohamed.ontime.data.prefs.CacheUtils;
import com.bumptech.glide.Glide;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView imageView=findViewById(R.id.splash_image);

        Glide.with(this)
                .load(R.drawable.splash)
                .asGif()
                .crossFade()
                .into(imageView);

        LocaleHelper.setLocale(this, CacheUtils.getUserLanguage(this,"language"));

        Handler handler=new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashActivity.this,WelcomeActivity.class));
                finish();
            }
        },3000);
    }


}
