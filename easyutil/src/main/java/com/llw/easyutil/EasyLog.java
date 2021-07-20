package com.llw.easyutil;

import android.util.Log;

/**
 * @author llw
 * @description EasyLog
 * @date 2021/7/20 16:52
 */
public final class EasyLog {

    /**
     * 是否打印日志（所有类型）
     */
    private static boolean IS_SHOW_LOG = true;
    /**
     * 是否打印Verbose日志
     */
    private static boolean IS_SHOW_LOG_V = true;
    /**
     * 是否打印Debug日志
     */
    private static boolean IS_SHOW_LOG_D = true;
    /**
     * 是否打印Info日志
     */
    private static boolean IS_SHOW_LOG_I = true;
    /**
     * 是否打印Warn日志
     */
    private static boolean IS_SHOW_LOG_W = true;
    /**
     * 是否打印Error日志
     */
    private static boolean IS_SHOW_LOG_E = true;
    /**
     * 是否打印Assert日志
     */
    private static boolean IS_SHOW_LOG_A = true;

    /**
     * 日志类型
     */
    private static final int V = 0x1;
    private static final int D = 0x2;
    private static final int I = 0x3;
    private static final int W = 0x4;
    private static final int E = 0x5;
    private static final int A = 0x6;

    private static int index = 4;

    /**
     * 不设置打印内容 可以通过此常量来打印日志，记录程序代码执行顺序
     */
    private static final String DEFAULT_MESSAGE = "execute";

    /**
     * 控制是否打印日志
     *
     * @param isShowLog true or false false不打印，在发布应用时记得设置为false。
     */
    public static void isPrintLog(boolean isShowLog) {
        IS_SHOW_LOG = isShowLog;
    }

    /**
     * 是否打印Verbose日志
     */
    public static void isPrintLogV(boolean isPrintLogV) {
        IS_SHOW_LOG_V = isPrintLogV;
    }

    /**
     * 是否打印Debug日志
     */
    public static void isPrintLogD(boolean isPrintLogD) {
        IS_SHOW_LOG_D = isPrintLogD;
    }

    /**
     * 是否打印Info日志
     */
    public static void isPrintLogI(boolean isPrintLogI) {
        IS_SHOW_LOG_I = isPrintLogI;
    }

    /**
     * 是否打印Warn日志
     */
    public static void isPrintLogW(boolean isPrintLogW) {
        IS_SHOW_LOG_W = isPrintLogW;
    }

    /**
     * 是否打印Error日志
     */
    public static void isPrintLogE(boolean isPrintLogE) {
        IS_SHOW_LOG_E = isPrintLogE;
    }
    /**
     * 是否打印Assert日志
     */
    public static void isPrintLogA(boolean isPrintLogA) {
        IS_SHOW_LOG_A = isPrintLogA;
    }


    public static void v() {
        if(!IS_SHOW_LOG_V){
            return;
        }
        printLog(V, null, DEFAULT_MESSAGE);
    }

    public static void v(String msg) {
        if(!IS_SHOW_LOG_V){
            return;
        }
        printLog(V, null, msg);
    }

    public static void v(String tag, String msg) {
        if(!IS_SHOW_LOG_V){
            return;
        }
        printLog(V, tag, msg);
    }

    public static void d() {
        if(!IS_SHOW_LOG_D){
            return;
        }
        printLog(D, null, DEFAULT_MESSAGE);
    }

    public static void d(String msg) {
        if(!IS_SHOW_LOG_D){
            return;
        }
        printLog(D, null, msg);
    }

    public static void d(String tag, String msg) {
        if(!IS_SHOW_LOG_D){
            return;
        }
        printLog(D, tag, msg);
    }

    public static void i() {
        if(!IS_SHOW_LOG_I){
            return;
        }
        printLog(I, null, DEFAULT_MESSAGE);
    }

    public static void i(String msg) {
        if(!IS_SHOW_LOG_I){
            return;
        }
        printLog(I, null, msg);
    }

    public static void i(String tag, String msg) {
        if(!IS_SHOW_LOG_I){
            return;
        }
        printLog(I, tag, msg);
    }

    public static void w() {
        if(!IS_SHOW_LOG_W){
            return;
        }
        printLog(W, null, DEFAULT_MESSAGE);
    }

    public static void w(String msg) {
        if(!IS_SHOW_LOG_W){
            return;
        }
        printLog(W, null, msg);
    }

    public static void w(String tag, String msg) {
        if(!IS_SHOW_LOG_W){
            return;
        }
        printLog(W, tag, msg);
    }

    public static void e() {
        if(!IS_SHOW_LOG_E){
            return;
        }
        printLog(E, null, DEFAULT_MESSAGE);
    }

    public static void e(String msg) {
        if(!IS_SHOW_LOG_E){
            return;
        }
        printLog(E, null, msg);
    }

    public static void e(String tag, String msg) {
        if(!IS_SHOW_LOG_E){
            return;
        }
        printLog(E, tag, msg);
    }

    public static void a() {
        if(!IS_SHOW_LOG_A){
            return;
        }
        printLog(A, null, DEFAULT_MESSAGE);
    }

    public static void a(String msg) {
        if(!IS_SHOW_LOG_A){
            return;
        }
        printLog(A, null, msg);
    }

    public static void a(String tag, String msg) {
        if(!IS_SHOW_LOG_A){
            return;
        }
        printLog(A, tag, msg);
    }

    /**
     * 日志打印
     *
     * @param type   日志类型
     * @param tagStr tag表示
     * @param msg    日志内容
     */
    private static void printLog(int type, String tagStr, String msg) {
        //isPrintLog()传入 false时不进行日志打印
        if (!IS_SHOW_LOG) {
            return;
        }
        //StackTraceElement表示StackTrace(堆栈轨迹)中的一个元素，属性包括方法调用者的类名、方法名、文件名以及调用的行数。
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        //类名
        String className = stackTrace[index].getFileName();
        //方法名
        String methodName = stackTrace[index].getMethodName();
        //代码行号
        int lineNumber = stackTrace[index].getLineNumber();
        //设置tag，tagStr为null则使用类名作为tag
        String tag = (tagStr == null ? className : tagStr);
        //获取方法名
        methodName = methodName.substring(0, 1).toUpperCase() + methodName.substring(1);
        //组装日志内容
        String logStr = assemblyContent(msg, className, methodName, lineNumber);

        switch (type) {
            case V:
                Log.v(tag, logStr);
                break;
            case D:
                Log.d(tag, logStr);
                break;
            case I:
                Log.i(tag, logStr);
                break;
            case W:
                Log.w(tag, logStr);
                break;
            case E:
                Log.e(tag, logStr);
                break;
            case A:
                Log.wtf(tag, logStr);
                break;
            default:
                break;
        }

    }

    /**
     * 组装日志内容
     *
     * @param msg        内容
     * @param className  类名
     * @param methodName 方法名
     * @param lineNumber 行号
     * @return 组装后的日志内容
     */
    private static String assemblyContent(String msg, String className, String methodName, int lineNumber) {
        StringBuilder stringBuilder = new StringBuilder();
        //打印内容组装
        stringBuilder.append("[ (")
                .append(className)
                .append(":")
                .append(lineNumber)
                .append(")#")
                .append(methodName)
                .append(" ] ")
                .append(msg);

        return stringBuilder.toString();
    }


}
