package com.llw.easylibrary.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SwitchCompat;

import android.os.Bundle;
import android.widget.CompoundButton;

import com.llw.easylibrary.R;
import com.llw.easyutil.EasyLog;

import static com.llw.easyutil.EasyToast.show;

/**
 * @author llw
 * @description EasyLog 日志打印  请在日志输入栏，输入LogActivity进行过滤
 * @date 2021/7/20 18:09
 */
public class LogActivity extends BaseActivity {

    private SwitchCompat switchAll, switchV, switchD, switchI, switchW, switchE, switchA;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log);
        //初始化
        initView();
        show("请配合AS的Logcat进行使用，检查日志打印结果");
    }

    /**
     * 初始化
     */
    private void initView() {
        back();
        setPageTitle(5);
        switchAll = findViewById(R.id.switch_all_log);
        switchV = findViewById(R.id.switch_v_log);
        switchD = findViewById(R.id.switch_d_log);
        switchI = findViewById(R.id.switch_i_log);
        switchW = findViewById(R.id.switch_w_log);
        switchE = findViewById(R.id.switch_e_log);
        switchA = findViewById(R.id.switch_a_log);
        findViewById(R.id.btn_print_log).setOnClickListener(v -> {
            //打印日志
            EasyLog.v("Verbose");
            EasyLog.d("Debug");
            EasyLog.i("Info");
            EasyLog.w("Warn");
            EasyLog.e("Error");
            EasyLog.a("Assert");
        });

        isPrintLog();

    }

    /**
     * 是否打印日志
     */
    private void isPrintLog() {
        isShowLog(switchAll, 0);
        isShowLog(switchV, 1);
        isShowLog(switchD, 2);
        isShowLog(switchI, 3);
        isShowLog(switchW, 4);
        isShowLog(switchE, 5);
        isShowLog(switchA, 6);
    }

    private void isShowLog(SwitchCompat switchCompat, int type) {
        switchCompat.setOnCheckedChangeListener((buttonView, isChecked) -> {
            switch (type) {
                case 0:
                    show("所有日志都" + (isChecked ? "打印" : "不打印"));
                    EasyLog.isPrintLog(isChecked);
                    break;
                case 1:
                    show("Verbose日志" + (isChecked ? "打印" : "不打印"));
                    EasyLog.isPrintLogV(isChecked);
                    break;
                case 2:
                    show("Debug日志" + (isChecked ? "打印" : "不打印"));
                    EasyLog.isPrintLogD(isChecked);
                    break;
                case 3:
                    show("Info日志" + (isChecked ? "打印" : "不打印"));
                    EasyLog.isPrintLogI(isChecked);
                    break;
                case 4:
                    show("Warn日志" + (isChecked ? "打印" : "不打印"));
                    EasyLog.isPrintLogW(isChecked);
                    break;
                case 5:
                    show("Error日志" + (isChecked ? "打印" : "不打印"));
                    EasyLog.isPrintLogE(isChecked);
                    break;
                case 6:
                    show("Assert日志" + (isChecked ? "打印" : "不打印"));
                    EasyLog.isPrintLogA(isChecked);
                    break;
            }
        });
    }
}