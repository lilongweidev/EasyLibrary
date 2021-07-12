package com.llw.easylibrary.ui;

import android.os.Bundle;

import com.llw.easylibrary.R;
import com.llw.easyutil.EasyAnimation;

/**
 * 引导页
 * @author llw
 * @date 2021/07/06
 */
public class SplashActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        setLightStatusBar(this,true);
        EasyAnimation.moveViewWidth(findViewById(R.id.tv_translate), () -> jumpActivityFinish(MainActivity.class));
    }
}