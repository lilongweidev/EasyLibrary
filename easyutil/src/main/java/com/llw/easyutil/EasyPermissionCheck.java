package com.llw.easyutil;

import android.Manifest;
import android.content.Context;
import android.content.pm.PackageManager;

/**
 * @author llw
 * @description EasyPermissionCheck （权限检查）
 * @date 2021/7/23 16:59
 */
public class EasyPermissionCheck {

    public static final String CAMERA = Manifest.permission.CAMERA;
    public static final String READ_EXTERNAL_STORAGE = Manifest.permission.READ_EXTERNAL_STORAGE;
    public static final String WRITE_EXTERNAL_STORAGE = Manifest.permission.WRITE_EXTERNAL_STORAGE;
    public static final String AUDIO = Manifest.permission.RECORD_AUDIO;

    private static PackageManager pm;
    private static String packageName;

    public static void init() {
        pm = EasyAppInfo.getPackageManager();
        packageName = EasyAppInfo.getPackageName();
    }

    /**
     * 检查相机权限
     */
    public static boolean hasCamera() {
        return checkPermission(CAMERA);
    }

    /**
     * 文件读写权限
     */
    public static boolean hasStorage() {
        return checkPermission(READ_EXTERNAL_STORAGE) && checkPermission(WRITE_EXTERNAL_STORAGE);
    }

    /**
     * 检查麦克风权限
     */
    public static boolean hasAudio() {
        return checkPermission(AUDIO);
    }

    /**
     * 检查权限
     *
     * @param permissionName 权限名
     */
    private static boolean checkPermission(String permissionName) {
        return (PackageManager.PERMISSION_GRANTED == pm.checkPermission(permissionName, packageName));
    }

}
