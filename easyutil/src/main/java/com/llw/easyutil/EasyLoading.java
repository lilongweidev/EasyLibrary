package com.llw.easyutil;

import android.app.Dialog;
import android.content.Context;

/**
 * Easy Loading
 * @author llw
 */
public final class EasyLoading extends Dialog {

    public EasyLoading(Context context) {
        super(context);
    }

    public EasyLoading(Context context, int themeResId) {
        super(context, themeResId);
    }

    protected EasyLoading(Context context, boolean cancelable, OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
    }
}
