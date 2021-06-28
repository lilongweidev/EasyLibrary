package com.llw.easyutil;

import android.content.Context;
import android.widget.Toast;

/**
 * EasyToast
 * @author llw
 */
public class EasyToast {

    /**
     * Toast
     */
    public static void show(final Context context, final CharSequence text) {
        Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
    }

    /**
     * LongToast
     */
    public static void showLong(final Context context, final CharSequence text) {
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
    }
}
