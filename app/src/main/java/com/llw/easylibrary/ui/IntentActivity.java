package com.llw.easylibrary.ui;

import android.Manifest;
import android.content.ContentValues;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.core.os.EnvironmentCompat;

import com.llw.easylibrary.R;
import com.llw.easyutil.EasyDate;
import com.llw.easyutil.EasyIntent;
import com.llw.easyutil.EasyLog;
import com.llw.easyutil.EasyToast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.EasyPermissions;

import static com.llw.easyutil.EasyToast.show;

/**
 * @author llw
 * @description IntentActivity （意图Activity）
 * @date 2021/7/22 20:21
 */
public class IntentActivity extends BaseActivity {

    public static final int REQUEST_PERMISSION_CODE = 9527;
    private static final int OPEN_CAMERA = 100;
    private static final int OPEN_CAMERA_URI = 101;
    private static final int OPEN_ALBUM = 102;
    private File outputImagePath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent);

        //初始化
        initView();
    }

    /**
     * 初始化
     */
    private void initView() {
        back();
        setPageTitle(6);
        TextView tvFunction = findViewById(R.id.tv_function);
        tvFunction.setText("请求权限");
        tvFunction.setOnClickListener(v -> requestPermission());

        findViewById(R.id.btn_phone_dial).setOnClickListener(v -> EasyIntent.phoneDial(this));
        findViewById(R.id.btn_phone_dial_input_number).setOnClickListener(v -> EasyIntent.phoneDial(this, "10086"));
        findViewById(R.id.btn_phone_sms).setOnClickListener(v -> EasyIntent.phoneSMS(this));
        findViewById(R.id.btn_phone_sms_to_phone).setOnClickListener(v -> EasyIntent.phoneSMS(this, "10086"));
        findViewById(R.id.btn_phone_sms_to_phone_add_content).setOnClickListener(v -> EasyIntent.phoneSMS(this, "10086", "查话费"));
        findViewById(R.id.btn_open_camera).setOnClickListener(v -> EasyIntent.phoneCamera(this, OPEN_CAMERA));
        findViewById(R.id.btn_open_camera_get_uri).setOnClickListener(v -> {
            String filename = String.valueOf(EasyDate.getTimestamp());
            outputImagePath = new File(getExternalCacheDir(), filename + ".jpg");
            EasyIntent.phoneCamera(this, OPEN_CAMERA_URI, outputImagePath);
        });
        findViewById(R.id.btn_open_album).setOnClickListener(v -> EasyIntent.phoneAlbum(this, OPEN_ALBUM));
        findViewById(R.id.btn_open_album_2).setOnClickListener(v -> EasyIntent.phoneAlbum2(this, OPEN_ALBUM));
    }

    @AfterPermissionGranted(REQUEST_PERMISSION_CODE)
    private void requestPermission() {
        String[] perms = {Manifest.permission.CAMERA,
                Manifest.permission.WRITE_EXTERNAL_STORAGE,
                Manifest.permission.READ_EXTERNAL_STORAGE};
        if (EasyPermissions.hasPermissions(this, perms)) {
            //权限通过
            show("权限已通过");
        } else {
            // 没有权限
            EasyPermissions.requestPermissions(this, "App所请求权限", REQUEST_PERMISSION_CODE, perms);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        // 将结果转发给 EasyPermissions
        EasyPermissions.onRequestPermissionsResult(REQUEST_PERMISSION_CODE, permissions, grantResults, this);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case OPEN_CAMERA:
                EasyLog.d("相机返回");
                break;
            case OPEN_CAMERA_URI:
                EasyLog.d("相机返回,图片uri " + outputImagePath.getAbsolutePath());
                EasyToast.show(outputImagePath.getAbsolutePath());
                break;
            case OPEN_ALBUM:
                EasyLog.d("相册返回" + data.getData().getPath());
                EasyToast.show(data.getData().getPath());
                break;
        }
    }
}