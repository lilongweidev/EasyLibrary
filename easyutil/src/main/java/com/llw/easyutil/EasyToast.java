package com.llw.easyutil;

import android.content.Context;
import android.widget.Toast;

/**
 * EasyToast
 * @author llw
 * @date 2021/06/28
 */
public final class EasyToast {

    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
    }

    /**
     * Toast
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
}
