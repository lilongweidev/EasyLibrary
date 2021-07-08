package com.llw.easylibrary.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.llw.easylibrary.R;

/**
 * Main
 * @author llw
 */
public class MainActivity extends AppCompatActivity {

    private long timeMillis;//时间

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_datetime_used).setOnClickListener(v -> jumpActivity(DateTimeActivity.class));
        findViewById(R.id.btn_shared_used).setOnClickListener(v -> jumpActivity(SharedPreferencesActivity.class));
    }

    /**
     * 跳转Activity
     * @param clazz 目标Activity
     */
    private void jumpActivity(Class<?> clazz) {
        startActivity(new Intent(this, clazz));
    }


    /**
     * 增加一个退出应用的提示
     *
     * @param keyCode
     * @param event
     * @return
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN) {
            if ((System.currentTimeMillis() - timeMillis) > 2000) {
                Toast.makeText(this, "再按一次退出EasyLibrary",Toast.LENGTH_SHORT).show();
                timeMillis = System.currentTimeMillis();
            } else {
                System.exit(0);
            }
            return false;
        }
        return super.onKeyDown(keyCode, event);
    }
}