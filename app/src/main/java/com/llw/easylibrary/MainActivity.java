package com.llw.easylibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.llw.easyutil.EasyDate;
import com.llw.easyutil.EasyToast;

import java.text.SimpleDateFormat;
import java.util.Date;

import static com.llw.easyutil.EasyAnimation.startBlink;
import static com.llw.easyutil.EasyAnimation.stopBlink;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private TextView tvBlink;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}