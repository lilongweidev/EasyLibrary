package com.llw.easyutil;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Easy
 * @author llw
 * @date 2021/07/06
 */
public class Easy {

    private static Context mContext;

    private static Easy easy = new Easy();

    private Easy() {}

    public static Easy getInstance() {
        return easy;
    }

    /**
     * 初始化
     * @param context 上下文
     */
    public static void initialize(Context context) {
        mContext = context;
        //初始化 Toast
        EasyToast.init(mContext);
        //初始化 SharedPreferences
        EasySP.init(mContext);
        //初始化 Size
        EasySize.init(mContext);
    }
}
