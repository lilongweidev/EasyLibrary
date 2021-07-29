package com.llw.easyutil;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;

import java.io.File;

import static com.llw.easyutil.EasyPermissionCheck.*;
import static com.llw.easyutil.EasyToast.show;

/**
 * @author llw
 * @description EasyIntent
 * @date 2021/7/22 20:21
 */
public final class EasyIntent {

    /**
     * 进入手机拨号页面
     *
     * @param activity 当前Activity
     */
    public static void phoneDial(final Activity activity) {
        activity.startActivity(new Intent(Intent.ACTION_DIAL));
    }

    /**
     * 进入手机拨号页面并输入手机号，点击拨打按钮即可拨打
     *
     * @param activity 当前Activity
     */
    public static void phoneDial(final Activity activity, String phoneNum) {
        activity.startActivity(new Intent(Intent.ACTION_DIAL, Uri.parse("tel:" + phoneNum)));
    }

    /**
     * 进入手机拨号页面
     *
     * @param activity    当前Activity
     * @param requestCode 请求码
     */
    public static void phoneDialForResult(final Activity activity, int requestCode) {
        activity.startActivityForResult(new Intent(Intent.ACTION_DIAL), requestCode);
    }

    /**
     * 进入手机新建短信页面
     *
     * @param activity 当前Activity
     */
    public static void phoneSMS(final Activity activity) {
        activity.startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:")));
    }

    /**
     * 进入手机新建短信页面
     *
     * @param activity    当前Activity
     * @param requestCode 请求码
     */
    public static void phoneSMSForResult(final Activity activity, int requestCode) {
        activity.startActivityForResult(new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:")), requestCode);
    }

    /**
     * 进入手机新建短信页面
     *
     * @param activity          当前Activity
     * @param targetPhoneNumber 接收短信的号码
     */
    public static void phoneSMS(final Activity activity, String targetPhoneNumber) {
        activity.startActivity(new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + targetPhoneNumber)));
    }

    /**
     * 进入手机新建短信页面
     *
     * @param activity          当前Activity
     * @param targetPhoneNumber 接收短信的号码
     * @param smsContent        短信内容
     */
    public static void phoneSMS(final Activity activity, String targetPhoneNumber, String smsContent) {
        Intent intent = new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:" + targetPhoneNumber));
        intent.putExtra("sms_body", smsContent);
        activity.startActivity(intent);
    }

    /**
     * 打开手机相机 （请先获取相机权限）
     *
     * @param activity    当前Activity
     * @param requestCode 请求码
     */
    public static void phoneCamera(final Activity activity, int requestCode) {
        //检查是否有相机权限
        if (!hasCamera()) {
            show("未获得相机权限");
            return;
        }
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        activity.startActivityForResult(intent, requestCode);
    }

    /**
     * 打开手机相机 （请先获取相机权限）
     *
     * @param activity    当前Activity
     * @param requestCode 请求码
     * @param file 保存图片的文件
     */
    public static void phoneCamera(final Activity activity, int requestCode, File file) {
        //检查是否有相机权限
        if (!hasCamera()) {
            show("未获得相机权限");
            return;
        }
        Uri uri;
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.N) {
            // 从文件中创建uri
            uri = Uri.fromFile(file);
        } else {
            //兼容android7.0 使用共享文件的形式
            ContentValues contentValues = new ContentValues(1);
            contentValues.put(MediaStore.Images.Media.DATA, file.getAbsolutePath());
            uri = activity.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        }
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.addCategory(Intent.CATEGORY_DEFAULT);

        phoneCamera(activity,requestCode,uri);
    }

    /**
     * 打开手机相机 （请先获取相机权限）
     *
     * @param activity    当前Activity
     * @param requestCode 请求码
     * @param outputUri 保存图片的地址uir  Uri.fromFile(new File(Environment.getExternalStorageDirectory() + "/image.jpg"))
     */
    public static void phoneCamera(final Activity activity, int requestCode, Uri outputUri) {
        //检查是否有相机权限
        if (!hasCamera()) {
            show("未获得相机权限");
            return;
        }
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.addCategory(Intent.CATEGORY_DEFAULT);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, outputUri);
        activity.startActivityForResult(intent, requestCode);
    }





    /**
     * 打开手机相册 （请先获取文件读取权限）
     *
     * @param activity    当前Activity
     * @param requestCode 请求码
     */
    public static void phoneAlbum(final Activity activity, int requestCode) {
        if (!hasStorage()) {
            show("未获得文件读写权限");
            return;
        }
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        activity.startActivityForResult(intent, requestCode);
    }

    public static void phoneAlbum2(final Activity activity, int requestCode) {
        if (!hasStorage()) {
            show("未获得文件读写权限");
            return;
        }
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("image/*");
        activity.startActivityForResult(intent, requestCode);
    }


}
