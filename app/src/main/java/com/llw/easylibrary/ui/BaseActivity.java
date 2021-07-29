package com.llw.easylibrary.ui;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.appbar.MaterialToolbar;
import com.llw.easylibrary.R;
import com.llw.easylibrary.bean.Function;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity {

    /**
     * 功能图标
     */
    private int[] drawableArray = {R.drawable.ic_time_white, R.drawable.ic_save_white, R.drawable.ic_regex_white,
            R.drawable.ic_toast_white, R.drawable.ic_app_info_white, R.drawable.ic_log_white, R.drawable.ic_intent_white,
            R.drawable.ic_animation_white};
    /**
     * 功能名称
     */
    private String[] nameArray = new String[]{"DateTime", "SharedPere", "RegexUsed", "ToastUsed", "AppInfo", "Logcat", "Intent","Animation"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    /**
     * 获取功能列表
     */
    protected List<Function> getFunctionList() {
        List<Function> functionList = new ArrayList<>();
        for (int i = 0;i < drawableArray.length;i++) {
            functionList.add(new Function(drawableArray[i],nameArray[i]));
        }
        return functionList;
    }

    /**
     * 状态栏颜色
     *
     * @param activity 页面
     * @param dark     是否深色
     */
    protected static void setLightStatusBar(Activity activity, boolean dark) {
        View decor = activity.getWindow().getDecorView();
        if (dark) {
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
        } else {
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
        }
    }

    protected void jumpActivity(final Class<?> clazz) {
        startActivity(new Intent(this, clazz));
    }

    /**
     * 根据功能position进行页面导航
     * @param position 功能position
     */
    protected void jumpActivity(final int position) {
        switch (position){
            case 0:
                jumpActivity(DateTimeActivity.class);
                break;
            case 1:
                jumpActivity(SharedPreferencesActivity.class);
                break;
            case 2:
                jumpActivity(RegexActivity.class);
                break;
            case 3:
                jumpActivity(ToastActivity.class);
                break;
            case 4:
                jumpActivity(AppInfoActivity.class);
                break;
            case 5:
                jumpActivity(LogActivity.class);
                break;
            case 6:
                jumpActivity(IntentActivity.class);
                break;
            case 7:
                jumpActivity(AnimationActivity.class);
                break;
            default:break;
        }
    }

    protected void jumpActivityFinish(final Class<?> clazz) {
        startActivity(new Intent(this, clazz));
        finish();
    }

    protected void back(final MaterialToolbar toolbar) {
        toolbar.setNavigationOnClickListener(v -> finish());
    }

    protected void back() {
        MaterialToolbar toolbar = (MaterialToolbar) findViewById(com.llw.easylibrary.R.id.toolbar);
        toolbar.setNavigationOnClickListener(v -> finish());
    }

    @SuppressLint("SetTextI18n")
    protected void setPageTitle(int type){
        TextView tvTitle = (TextView)findViewById(com.llw.easylibrary.R.id.tv_title);
        switch (type) {
            case 0:
                tvTitle.setText("日期时间使用");
                break;
            case 1:
                tvTitle.setText("本地缓存使用");
                break;
            case 2:
                tvTitle.setText("正则表达式使用");
                break;
            case 3:
                tvTitle.setText("Toast使用");
                break;
            case 4:
                tvTitle.setText("App信息");
                break;
            case 5:
                tvTitle.setText("日志打印");
                break;
            case 6:
                tvTitle.setText("快捷跳转");
                break;
            case 7:
                tvTitle.setText("简单动画");
                break;
        }

    }


}
