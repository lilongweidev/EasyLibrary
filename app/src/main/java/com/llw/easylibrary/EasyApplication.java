package com.llw.easylibrary;

import android.app.Application;

import com.llw.easyutil.Easy;

public class EasyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Easy.initialize(this);
    }
}
