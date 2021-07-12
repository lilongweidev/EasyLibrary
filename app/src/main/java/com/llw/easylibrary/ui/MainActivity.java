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
 *
 * @author llw
 * @date 2021/06/25
 */
public class MainActivity extends BaseActivity {

    //时间
    private long timeMillis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.btn_datetime_used).setOnClickListener(v -> jumpActivity(DateTimeActivity.class));
        findViewById(R.id.btn_shared_used).setOnClickListener(v -> jumpActivity(SharedPreferencesActivity.class));
        findViewById(R.id.btn_regex_used).setOnClickListener(v -> jumpActivity(RegexActivity.class));
        findViewById(R.id.btn_toast_used).setOnClickListener(v -> jumpActivity(ToastActivity.class));
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