package com.llw.easyutil;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;


/**
 * EasyAnimation
 *
 * @author llw
 * @date 2021/07/02
 */
public final class EasyAnimation {


    /**
     * 开始自定义动画
     *
     * @param view   需要设置动画的View
     * @param animId 动画资源文件id（自行配置）
     */
    public static void startCustomAnim(View view, int animId) {
        Animation animation = AnimationUtils.loadAnimation(EasyAppInfo.getContext(), animId);
        view.startAnimation(animation);
    }

    /**
     * 开始自定义动画
     *
     * @param view      需要设置动画的View
     * @param animation 动画（自行配置）
     */
    public static void startCustomAnim(View view, Animation animation) {
        view.startAnimation(animation);
    }

    public static void stopCustomAnim(View view) {
        if (view != null) {
            view.clearAnimation();
        }
    }

    /**
     * 开始眨眼动画
     *
     * @param view 需要设置动画的View
     */
    public static void startWink(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500);
        alphaAnimation.setStartOffset(20);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        view.startAnimation(alphaAnimation);
    }

    /**
     * 开始眨眼动画
     *
     * @param view           需要设置动画的View
     * @param alphaAnimation 透明度动画（自行配置）
     */
    public static void startWink(View view, AlphaAnimation alphaAnimation) {
        view.startAnimation(alphaAnimation);
    }

    /**
     * 停止眨眼动画
     *
     * @param view 需要清除动画的View
     */
    public static void stopWink(View view) {
        if (view != null) {
            view.clearAnimation();
        }
    }

    /**
     * 开始心跳动画
     *
     * @param view 需要设置动画的View
     */
    public static void startHeartbeat(View view) {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.5f, 1.0f, 0.5f, 1.0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        scaleAnimation.setDuration(1000);
        scaleAnimation.setRepeatMode(Animation.REVERSE);
        scaleAnimation.setRepeatCount(Animation.INFINITE);
        view.startAnimation(scaleAnimation);
    }

    /**
     * 开始心跳动画
     *
     * @param view           需要设置动画的View
     * @param scaleAnimation 缩放动画（自行配置）
     */
    public static void startHeartbeat(View view, ScaleAnimation scaleAnimation) {
        view.startAnimation(scaleAnimation);
    }

    /**
     * 停止心跳动画
     *
     * @param view 需要清除动画的View
     */
    public static void stopHeartbeat(View view) {
        if (view != null) {
            view.clearAnimation();
        }
    }

    /**
     * 移动指定View的宽度
     *
     * @param view
     */
    public static void moveViewWidth(View view, TranslateCallback callback) {
        view.post(() -> {
            //通过post拿到的tvTranslate.getWidth()不会为0。
            TranslateAnimation translateAnimation = new TranslateAnimation(0, view.getWidth(), 0, 0);
            translateAnimation.setDuration(1000);
            translateAnimation.setFillAfter(true);
            view.startAnimation(translateAnimation);

            //动画监听
            translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    //检查Android版本
                    callback.animationEnd();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        });
    }

    /**
     * 移动指定View的宽度
     *
     * @param view               需要位移的View
     * @param callback           位移动画回调
     * @param translateAnimation 位移动画 （自行配置）
     */
    public static void moveViewWidth(View view, TranslateCallback callback, TranslateAnimation translateAnimation) {
        view.post(() -> {
            //通过post拿到的tvTranslate.getWidth()不会为0。

            view.startAnimation(translateAnimation);

            //动画监听
            translateAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    //检查Android版本
                    callback.animationEnd();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        });
    }

    public interface TranslateCallback {
        //动画结束
        void animationEnd();
    }
}
