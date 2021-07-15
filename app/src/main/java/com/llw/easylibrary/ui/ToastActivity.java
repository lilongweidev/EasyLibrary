package com.llw.easylibrary.ui;

import androidx.annotation.RequiresApi;
import androidx.appcompat.widget.AppCompatSeekBar;

import android.os.Build;
import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.TextView;

import com.llw.easylibrary.R;

import java.util.Locale;

import static com.llw.easyutil.EasyToast.*;

/**
 * EasyToast Used
 * @author llw
 * @date 2021/07/12
 */
public class ToastActivity extends BaseActivity {


    private float radius;
    private int gravity;
    private int bgColor;
    private int txColor;

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
        back();
        setPageTitle(3);
        TextView tvRadius = findViewById(R.id.tv_radius);
        AppCompatSeekBar sbRadius = findViewById(R.id.sb_radius);
        sbRadius.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                tvRadius.setText(String.format(Locale.getDefault(),"%d", progress));
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                radius = seekBar.getProgress();
            }
        });

        RadioGroup radioGroupGravity = findViewById(R.id.rg_gravity);
        gravity = 0;
        radioGroupGravity.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId) {
                case R.id.rb_top:
                    gravity = 2;
                    break;
                case R.id.rb_center:
                    gravity = 1;
                    break;
                case R.id.rb_bottom:
                    gravity = 0;
                    break;
                default:break;
            }
        });

        RadioGroup radioGroupBg = findViewById(R.id.rg_bg);
        bgColor = R.color.black;
        radioGroupBg.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId){
                case R.id.rb_red_bg:
                    bgColor = R.color.red;
                    break;
                case R.id.rb_green_bg:
                    bgColor = R.color.green;
                    break;
                case R.id.rb_blue_bg:
                    bgColor = R.color.blue;
                    break;
                case R.id.rb_orange_bg:
                    bgColor = R.color.orange;
                    break;
                case R.id.rb_purple_bg:
                    bgColor = R.color.purple;
                    break;
                default:
                    bgColor = R.color.black;
                    break;
            }
        });

        RadioGroup radioGroupTx = findViewById(R.id.rg_tx);
        txColor = R.color.white;
        radioGroupTx.setOnCheckedChangeListener((group, checkedId) -> {
            switch (checkedId){
                case R.id.rb_red_tx:
                    txColor = R.color.red;
                    break;
                case R.id.rb_green_tx:
                    txColor = R.color.green;
                    break;
                case R.id.rb_blue_tx:
                    txColor = R.color.blue;
                    break;
                case R.id.rb_orange_tx:
                    txColor = R.color.orange;
                    break;
                case R.id.rb_purple_tx:
                    txColor = R.color.purple;
                    break;
                default:
                    txColor = R.color.white;
                    break;
            }
        });

        findViewById(R.id.btn_default_toast).setOnClickListener(v -> show("默认Toast"));
        findViewById(R.id.btn_default_long_toast).setOnClickListener(v -> showLong("默认Long Toast"));
        //自定义 位置 Toast
        findViewById(R.id.btn_gravity_toast).setOnClickListener(v -> showToast(this,"顶部 Easy Toast",gravity));
        //自定义圆角Toast
        findViewById(R.id.btn_radius_toast).setOnClickListener(v -> showToast(this,"自定义圆角 Easy Toast",radius));
        //自定义背景Toast
        findViewById(R.id.btn_bg_color_toast).setOnClickListener(v -> showBgColorToast(this,"自定义背景颜色 Easy Toast", bgColor));
        //自定义文字颜色 Toast
        findViewById(R.id.btn_tx_color_toast).setOnClickListener(v -> showTxColorToast(this,"自定义文字颜色 Easy Toast", txColor));
        //文字、背景颜色改变 Toast
        findViewById(R.id.btn_color_toast).setOnClickListener(v -> showColorToast(this,"文字、背景颜色改变 Easy Toast",bgColor,txColor));
        //圆角、文字、背景改变 Toast
        findViewById(R.id.btn_base_toast).setOnClickListener(v -> showToastBase(this,"圆角、文字、背景改变 Easy Toast",bgColor,txColor,radius));
        //位置、圆角、文字、背景改变 Toast
        findViewById(R.id.btn_plus_toast).setOnClickListener(v -> showToastPlus(this,"位置、圆角、文字、背景改变 Easy Toast",gravity,bgColor,txColor,radius));
    }
}