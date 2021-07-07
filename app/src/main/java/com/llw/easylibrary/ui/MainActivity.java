package com.llw.easylibrary.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.llw.easylibrary.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_datetime_used).setOnClickListener(v -> jumpActivity(DateTimeActivity.class));
    }

    /**
     * 跳转Activity
     * @param clazz 目标Activity
     */
    private void jumpActivity(Class<?> clazz) {
        startActivity(new Intent(this, clazz));
    }

}