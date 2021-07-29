package com.llw.easyutil;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.util.Log;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author llw
 * @description EasyAppInfo 获取App信息
 * @date 2021/7/15 19:01
 */
public final class EasyAppInfo {

    public static final String APP_FIRST_START = "appFirstStart";
    public static final String TODAY_START_UP_APP_TIME = "todayStartUpAppTime";

    public static Context getContext() {
        return mContext;
    }

    private static Context mContext;
    private static PackageManager mPackageManager;
    private static PackageInfo mPackageInfo;

    public static PackageManager getPackageManager() {
        return mPackageManager;
    }

    private static List<AppInfo> appInfoList;


    public static void init(Context context) {
        mContext = context;
        try {
            mPackageManager = mContext.getPackageManager();
            mPackageInfo = mContext.getPackageManager().getPackageInfo(mContext.getPackageName(), 0);

            EasyPermissionCheck.init();
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取App版本号
     *
     * @return long 例如 1
     */
    public static long getVersionCode() {
        return mPackageInfo.getLongVersionCode();
    }

    /**
     * 获取App版本名
     *
     * @return String 例如 "1.0.0"
     */
    public static String getVersionName() {
        return mPackageInfo.versionName;
    }

    /**
     * 获取手机上所有应用
     *
     * @return true or false
     */
    public static List<PackageInfo> getAllApp() {
        return mPackageManager.getInstalledPackages(0);
    }

    /**
     * 获取手机上所有应用
     *
     * @param isPreInstalled 获取手机是否为系统预装的App false则获取手动安装的应用
     * @return true or false
     */
    public static List<PackageInfo> getAllApp(boolean isPreInstalled) {
        List<PackageInfo> preInstallApps = new ArrayList<>();
        List<PackageInfo> manualInstallationApps = new ArrayList<>();
        //获取手机内所有应用
        List<PackageInfo> packages = mPackageManager.getInstalledPackages(0);
        for (int i = 0; i < packages.size(); i++) {
            PackageInfo packageInfo = (PackageInfo) packages.get(i);
            //判断是否为非系统预装的应用程序
            if ((packageInfo.applicationInfo.flags & ApplicationInfo.FLAG_SYSTEM) <= 0) {
                // 手动安装的应用
                manualInstallationApps.add(packageInfo);
            } else {
                //系统预装
                preInstallApps.add(packageInfo);
            }
        }
        return isPreInstalled ? preInstallApps : manualInstallationApps;
    }


    /**
     * 获取App包名
     *
     * @return String 例如 "com.llw.easyutil"
     */
    public static String getPackageName() {
        return mContext.getPackageName();
    }

    /**
     * 判断App是否是首次启动（指安装后的第一次运行）
     *
     * @return true or false
     */
    public static boolean isFirstStartApp() {
        boolean isFirst = EasySP.getBoolean(APP_FIRST_START, true);
        if (isFirst) {
            EasySP.putBoolean(APP_FIRST_START, false);
            return true;
        } else {
            return false;
        }
    }

    /**
     * 判断是否是今日首次启动APP（指今天的第一次运行）
     *
     * @return true or false
     */
    public static boolean isTodayFirstStartApp() {
        String saveDate = EasySP.getString(TODAY_START_UP_APP_TIME, "2020-07-14");
        String todayDate = EasyDate.getTheYearMonthAndDay();
        if (!saveDate.equals(todayDate)) {
            EasySP.putString(TODAY_START_UP_APP_TIME, EasyDate.getTheYearMonthAndDay());
            return true;
        } else {
            return false;
        }
    }

    /**
     * 获取手机上所有App信息
     * @return App列表数据
     */
    public static List<AppInfo> getAppInfoList() {
        List<PackageInfo> packageInfoList = mPackageManager.getInstalledPackages(0);
        return getAppList(packageInfoList);
    }

    /**
     * 获取手机上所有App信息
     * @param packageInfoList 安装包列表
     * @return App列表数据
     */
    public static List<AppInfo> getAppInfoList(List<PackageInfo> packageInfoList) {
        return getAppList(packageInfoList);
    }

    /**
     * App列表数据组装
     * @param packageInfoList 安装包列表
     * @return App列表数据
     */
    private static List<AppInfo> getAppList(List<PackageInfo> packageInfoList) {
        appInfoList = new ArrayList<>();
        for (PackageInfo packageInfo : packageInfoList) {
            String appName = packageInfo.applicationInfo.loadLabel(mPackageManager).toString();
            String packageName = packageInfo.packageName;
            Drawable appIcon = packageInfo.applicationInfo.loadIcon(mPackageManager);
            appInfoList.add(new AppInfo(appName, packageName, appIcon));
        }
        return appInfoList;
    }

    public static void setAppInfoList(List<AppInfo> appInfoList) {
        EasyAppInfo.appInfoList = appInfoList;
    }

    /**
     * AppInfo 包含（应用名称、包名、应用图标）
     */
    public static class AppInfo {
        private String appName;
        private String packageName;
        private Drawable appIcon;

        public String getAppName() {
            return appName;
        }

        public void setAppName(String appName) {
            this.appName = appName;
        }

        public String getPackageName() {
            return packageName;
        }

        public void setPackageName(String packageName) {
            this.packageName = packageName;
        }

        public Drawable getAppIcon() {
            return appIcon;
        }

        public void setAppIcon(Drawable appIcon) {
            this.appIcon = appIcon;
        }

        public AppInfo(String appName, String packageName, Drawable appIcon) {
            this.appName = appName;
            this.packageName = packageName;
            this.appIcon = appIcon;
        }
    }
}
