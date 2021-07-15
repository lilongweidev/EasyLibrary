package com.llw.easylibrary.ui;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.llw.easylibrary.R;
import com.llw.easyutil.EasyDate;

import java.util.Locale;

/**
 * EasyDate Used
 * @author llw
 * @date 2021/07/01
 */
public class DateTimeActivity extends BaseActivity {

    private TextView tvDatetime, tvFullDatetime, tvYearMonthDay, tvYearMonthDayCn,
            tvYearMonthDayCnDelimiter, tvHourMinuteSecond, tvHourMinuteSecondCn,
            tvHourMinuteSecondDelimiter, tvYear, tvMonth, tvDay, tvHour, tvMinute, tvSecond,
            tvMillisecond,tvTimestamp,tvWeek,tvMonthDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_time);

        initView();
    }

    /**
     * 初始化
     */
    private void initView() {
        back();
        setPageTitle(0);
        ImageView ivFunction = findViewById(R.id.iv_function);
        ivFunction.setImageResource(R.drawable.ic_refresh_white);
        tvDatetime = findViewById(R.id.tv_datetime);
        tvFullDatetime = findViewById(R.id.tv_full_datetime);
        tvYearMonthDay = findViewById(R.id.tv_year_month_day);
        tvYearMonthDayCn = findViewById(R.id.tv_year_month_day_cn);
        tvYearMonthDayCnDelimiter = findViewById(R.id.tv_year_month_day_delimiter);
        tvHourMinuteSecond = findViewById(R.id.tv_hour_minute_second);
        tvHourMinuteSecondCn = findViewById(R.id.tv_hour_minute_second_cn);
        tvHourMinuteSecondDelimiter = findViewById(R.id.tv_hour_minute_second_delimiter);
        tvYear = findViewById(R.id.tv_year);
        tvMonth = findViewById(R.id.tv_month);
        tvDay = findViewById(R.id.tv_day);
        tvHour = findViewById(R.id.tv_hour);
        tvMinute = findViewById(R.id.tv_minute);
        tvSecond = findViewById(R.id.tv_second);
        tvMillisecond = findViewById(R.id.tv_millisecond);
        tvTimestamp = findViewById(R.id.tv_timestamp);
        tvWeek = findViewById(R.id.tv_week);
        tvMonthDays = findViewById(R.id.tv_month_days);
        ivFunction.setOnClickListener(v -> refresh());
        refresh();
    }

    /**
     * 刷新页面时间
     */
    private void refresh() {
        tvDatetime.setText(String.format("标准时间：%s", EasyDate.getDateTime()));
        tvFullDatetime.setText(String.format("完整时间：%s", EasyDate.getFullDateTime()));
        tvYearMonthDay.setText(String.format("年月日：%s", EasyDate.getTheYearMonthAndDay()));
        tvYearMonthDayCn.setText(String.format("年月日：%s", EasyDate.getTheYearMonthAndDayCn()));
        tvYearMonthDayCnDelimiter.setText(String.format("年月日：%s", EasyDate.getTheYearMonthAndDayDelimiter("/")));
        tvHourMinuteSecond.setText(String.format("时分秒：%s", EasyDate.getHoursMinutesAndSeconds()));
        tvHourMinuteSecondCn.setText(String.format("时分秒：%s", EasyDate.getHoursMinutesAndSecondsCn()));
        tvHourMinuteSecondDelimiter.setText(String.format("时分秒：%s", EasyDate.getHoursMinutesAndSecondsDelimiter(".")));
        tvYear.setText(String.format("年：%s", EasyDate.getYear()));
        tvMonth.setText(String.format("月：%s", EasyDate.getMonth()));
        tvDay.setText(String.format("日：%s", EasyDate.getDay()));
        tvHour.setText(String.format("时：%s", EasyDate.getHour()));
        tvMinute.setText(String.format("分：%s", EasyDate.getMinute()));
        tvSecond.setText(String.format("秒：%s", EasyDate.getSecond()));
        tvMillisecond.setText(String.format("毫秒：%s", EasyDate.getMilliSecond()));
        tvTimestamp.setText(String.format(Locale.getDefault(),"时间戳：%d", EasyDate.getTimestamp()));
        tvWeek.setText(String.format("星期：%s", EasyDate.getTodayOfWeek()));
        tvMonthDays.setText(String.format(Locale.getDefault(),"本月天数：%d", EasyDate.getCurrentMonthDays()));
    }
}