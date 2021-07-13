package com.llw.easyutil;

import android.app.Activity;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Toast;

/**
 * EasyToast
 *
 * @author llw
 * @date 2021/06/28
 */
public final class EasyToast {

    private static Context mContext;
    private static Toast mToast;

    public static void init(Context context) {
        mContext = context;
        mToast = new Toast(mContext);
    }

    /**
     * 默认Toast
     */
    public static void show(final CharSequence text) {
        Toast.makeText(mContext, text, Toast.LENGTH_SHORT).show();
    }

    /**
     * LongToast
     */
    public static void showLong(final CharSequence text) {
        Toast.makeText(mContext, text, Toast.LENGTH_LONG).show();
    }

    /**
     * 自定义Toast
     *
     * @param activity 显示在Activity上
     * @param text     显示内容
     */
    public static void showToast(final Activity activity, String text) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_easy_toast, null);
        EasyView easyView = view.findViewById(R.id.v_easy);
        easyView.setText(text);
        setToast(view);
    }

    /**
     * 自定义Long ToastView
     *
     * @param activity 显示在Activity上
     * @param text     显示内容
     */
    public static void showLongToast(final Activity activity, String text) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_easy_toast, null);
        EasyView easyView = view.findViewById(R.id.v_easy);
        easyView.setText(text);
        setLongToast(view);
    }

    /**
     * 自定义Toast 设置显示Toast的位置
     *
     * @param activity 显示在Activity上
     * @param text     显示内容
     * @param gravity  显示在屏幕上的位置  0 底部显示  1 中部显示  2 顶部显示
     */
    public static void showToast(final Activity activity, String text, int gravity) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_easy_toast, null);
        EasyView easyView = view.findViewById(R.id.v_easy);
        easyView.setText(text);
        setToast(view, gravity);
    }

    /**
     * 自定义Toast  设置背景圆角
     *
     * @param activity 显示在Activity上
     * @param text     显示内容
     * @param radius   背景圆角
     */
    public static void showToast(final Activity activity, String text, float radius) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_easy_toast, null);
        EasyView easyView = view.findViewById(R.id.v_easy);
        easyView.setBgRadius(radius);
        easyView.setText(text);
        setToast(view);
    }

    /**
     * 自定义颜色Toast
     *
     * @param activity  显示在Activity上
     * @param text      显示内容
     * @param bgColor   背景颜色
     * @param textColor 文字颜色
     */
    public static void showColorToast(final Activity activity, String text, int bgColor, int textColor) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_easy_toast, null);
        EasyView easyView = view.findViewById(R.id.v_easy);
        easyView.setBgColor(activity, bgColor);
        easyView.setTextColor(activity, textColor);
        easyView.setText(text);
        setToast(view);
    }

    /**
     * 自定义颜色Toast 设置背景颜色
     *
     * @param activity 显示在Activity上
     * @param text     显示内容
     * @param bgColor  背景颜色
     */
    public static void showBgColorToast(final Activity activity, String text, int bgColor) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_easy_toast, null);
        EasyView easyView = view.findViewById(R.id.v_easy);
        easyView.setBgColor(activity, bgColor);
        easyView.setText(text);
        setToast(view);
    }

    /**
     * 自定义颜色Toast 设置文字颜色
     *
     * @param activity  显示在Activity上
     * @param text      显示内容
     * @param textColor 文字颜色
     */
    public static void showTxColorToast(final Activity activity, String text, int textColor) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_easy_toast, null);
        EasyView easyView = view.findViewById(R.id.v_easy);
        easyView.setTextColor(activity, textColor);
        easyView.setText(text);
        setToast(view);
    }

    /**
     * 自定义颜色Toast 设置背景颜色、文字颜色、圆角
     *
     * @param activity  显示在Activity上
     * @param text      显示内容
     * @param bgColor   背景颜色
     * @param textColor 文字颜色
     * @param radius    背景圆角
     */
    public static void showToastBase(final Activity activity, String text, int bgColor, int textColor, float radius) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_easy_toast, null);
        EasyView easyView = view.findViewById(R.id.v_easy);
        easyView.setBgColor(activity, bgColor);
        easyView.setBgRadius(radius);
        easyView.setTextColor(activity, textColor);
        easyView.setText(text); //toast内容
        setToast(view);
    }

    /**
     * 自定义颜色Toast 设置背景颜色、文字颜色、圆角
     *
     * @param activity  显示在Activity上
     * @param text      显示内容
     * @param bgColor   背景颜色
     * @param textColor 文字颜色
     * @param radius    背景圆角
     */
    public static void showToastPlus(final Activity activity, String text,int gravity, int bgColor, int textColor, float radius) {
        LayoutInflater inflater = activity.getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_easy_toast, null);
        EasyView easyView = view.findViewById(R.id.v_easy);
        easyView.setBgColor(activity, bgColor);
        easyView.setBgRadius(radius);
        easyView.setTextColor(activity, textColor);
        easyView.setText(text); //toast内容
        setToast(view,gravity);
    }

    /**
     * 设置Toast
     *
     * @param view
     */
    private static void setToast(View view) {
        mToast.setGravity(Gravity.BOTTOM, 12, 20);
        //显示位置 上中下
        mToast.setDuration(Toast.LENGTH_SHORT);
        mToast.setView(view);
        mToast.show();
    }

    /**
     * 设置Toast
     *
     * @param view
     * @param gravity 0 底部显示  1 中部显示  2 顶部显示
     */
    private static void setToast(View view, int gravity) {
        mToast.setGravity(gravity == 0 ? Gravity.BOTTOM : gravity == 1 ? Gravity.CENTER : Gravity.TOP, 12, 20);
        mToast.setDuration(Toast.LENGTH_SHORT);
        mToast.setView(view);
        mToast.show();
    }

    /**
     * 设置Long Toast
     *
     * @param view
     */
    private static void setLongToast(View view) {
        mToast.setGravity(Gravity.BOTTOM, 12, 20);
        mToast.setDuration(Toast.LENGTH_LONG);
        mToast.setView(view); //添加视图文件
        mToast.show();
    }


    /**
     * 设置Toast
     *
     * @param view    视图
     * @param gravity 0 底部显示  1 中部显示  2 顶部显示
     * @param isLong  是否长时间显示
     */
    private static void setToast(View view, int gravity, boolean isLong) {
        mToast.setGravity(gravity == 0 ? Gravity.BOTTOM : gravity == 1 ? Gravity.CENTER : Gravity.TOP, 12, 20);
        mToast.setDuration(isLong ? Toast.LENGTH_LONG : Toast.LENGTH_SHORT);
        mToast.setView(view); //添加视图文件
        mToast.show();
    }
}
