package com.llw.easyutil;

import android.content.Context;

import java.util.Set;

/**
 * Easy SharedPreferences
 * @author llw
 */
public final class EasySP {

    private static final String NAME = "data_config";

    private static Context mContext;

    public static void init(Context context) {
        mContext = context;
    }

    /**
     * putBoolean
     * @param key 键
     * @param value 缓存值
     */
    public static void putBoolean(String key, boolean value) {
        mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit().putBoolean(key, value).apply();
    }

    /**
     * getBoolean
     * @param key 键
     * @param defValue 默认值
     * @return 结果
     */
    public static boolean getBoolean(String key, boolean defValue) {
        return mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE).getBoolean(key, defValue);
    }

    /**
     * putString
     * @param key 键
     * @param value 缓存值
     */
    public static void putString(String key, String value) {
        mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit().putString(key, value).apply();
    }

    /**
     * getString
     * @param key 键
     * @param defValue 默认值
     * @return 结果
     */
    public static String getString(String key, String defValue) {
        return mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE).getString(key, defValue);
    }

    /**
     * putInt
     * @param key 键
     * @param value 缓存值
     */
    public static void putInt(String key, int value) {
        mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit().putInt(key, value).apply();
    }

    /**
     * getInt
     * @param key 键
     * @param defValue 默认值
     * @return 结果
     */
    public static int getInt(String key, int defValue) {
        return mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE).getInt(key, defValue);
    }

    /**
     * putFloat
     * @param key 键
     * @param value 缓存值
     */
    public static void putFloat(String key, float value) {
        mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit().putFloat(key, value).apply();
    }

    /**
     * getFloat
     * @param key 键
     * @param defValue 默认值
     * @return 结果
     */
    public static float getFloat(String key, float defValue) {
        return mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE).getFloat(key, defValue);
    }

    /**
     * putLong
     * @param key 键
     * @param value 缓存值
     */
    public static void putLong(String key, long value) {
        mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit().putLong(key,value).apply();
    }

    /**
     * getLong
     * @param key 值
     * @param defValue 默认值
     * @return 结果
     */
    public static long getLong(String key, long defValue) {
        return mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE).getLong(key, defValue);
    }

    /**
     * putStringSet
     * @param key 键
     * @param value 缓存值
     */
    public static void putStringSet(String key, Set<String> value) {
        mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit().putStringSet(key,value).apply();
    }

    /**
     * getStringSet
     * @param key 值
     * @param defValue 默认值
     * @return 结果
     */
    public static Set<String> getStringSet(String key, Set<String> defValue) {
        return mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE).getStringSet(key, defValue);
    }

    /**
     * 清除缓存
     * @param key 键
     */
    public static void remove(String key) {
        mContext.getSharedPreferences(NAME, Context.MODE_PRIVATE).edit().remove(key).apply();
    }
}
