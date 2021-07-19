package com.llw.easylibrary;

import android.app.Application;

import com.llw.easyutil.Easy;
import com.llw.easyutil.EasySize;

/**
 * EasyApplication
 * @author llw
 * @date 2021/07/01
 */
public class EasyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        Easy.initialize(this);
    }
}
