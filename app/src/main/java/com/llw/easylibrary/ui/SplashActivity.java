package com.llw.easylibrary.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.llw.easylibrary.R;
import com.llw.easyutil.EasyAnimation;

/**
 * 引导页
 * @author llw
 */
public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        EasyAnimation.moveViewWidth(findViewById(R.id.tv_translate), () -> jumpActivity());
    }

    private void jumpActivity() {
        startActivity(new Intent(this,MainActivity.class));
        finish();
    }

}