package com.llw.easyutil;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;


/**
 * EasyAnimation
 * @author llw
 */
public class EasyAnimation {

    /**
     * 开始眨眼动画
     * @param view 需要设置动画的View
     */
    public static void startBlink(View view) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
        alphaAnimation.setDuration(500);
        alphaAnimation.setStartOffset(20);
        alphaAnimation.setRepeatMode(Animation.REVERSE);
        alphaAnimation.setRepeatCount(Animation.INFINITE);
        view.startAnimation(alphaAnimation);
    }

    /**
     * 停止眨眼动画
     * @param view 需要清除动画的View
     */
    public static void stopBlink(View view) {
        if (view != null) {
            view.clearAnimation();
        }
    }
}
