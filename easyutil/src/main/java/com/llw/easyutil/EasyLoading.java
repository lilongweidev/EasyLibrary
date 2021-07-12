package com.llw.easyutil;

import android.app.Dialog;
import android.content.Context;

/**
 * Easy Loading
 * @author llw
 * @date 2021/06/28
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
