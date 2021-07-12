package com.llw.easylibrary.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.appbar.MaterialToolbar;
import com.google.android.material.button.MaterialButton;
import com.llw.easylibrary.R;

/**
 * EasyToast Used
 * @author llw
 * @date 2021/07/12
 */
public class ToastActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);

        initView();
    }

    /**
     * 初始化
     */
    private void initView() {
        MaterialToolbar toolbar = findViewById(R.id.toolbar);
        TextView tvTitle = findViewById(R.id.tv_title);
        back(toolbar);
        tvTitle.setText("Toast使用");
    }
}