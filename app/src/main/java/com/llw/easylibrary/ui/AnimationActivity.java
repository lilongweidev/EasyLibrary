package com.llw.easylibrary.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.llw.easylibrary.BuildConfig;
import com.llw.easylibrary.R;
import com.llw.easyutil.EasyAnimation;

/**
 * @author llw
 * @description AnimationActivity (简单动画演示)
 * @date 2021/7/28 10:53
 */
public class AnimationActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animation);
        initView();

    }

    /**
     * 初始化
     */
    private void initView() {
        back();
        setPageTitle(7);
        ImageView ivWink = findViewById(R.id.iv_wink);
        ImageView ivHeartbeat = findViewById(R.id.iv_heartbeat);
        findViewById(R.id.btn_start_wink).setOnClickListener(v -> EasyAnimation.startWink(ivWink));
        findViewById(R.id.btn_stop_wink).setOnClickListener(v -> EasyAnimation.stopWink(ivWink));
        findViewById(R.id.btn_start_heartbeat).setOnClickListener(v -> EasyAnimation.startHeartbeat(ivHeartbeat));
        findViewById(R.id.btn_stop_heartbeat).setOnClickListener(v -> EasyAnimation.stopHeartbeat(ivHeartbeat));
    }
}