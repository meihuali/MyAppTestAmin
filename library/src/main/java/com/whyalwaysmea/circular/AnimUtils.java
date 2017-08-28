package com.whyalwaysmea.circular;

import android.animation.Animator;
import android.app.Activity;
import android.os.Build;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;

/**
 * 项目名：Circular
 * 包名：com.whyalwaysmea.circular
 * 文件名：AnimUtils
 * 创建者 ：$梅华黎
 * 创建时间： 2017/8/28 9:46
 * 描述：TODO
 */
public class AnimUtils {

    public static int mX;
    private static int mY;
    private static View view1;
    private static Activity activity1;




    public static void animhpel(final Activity activity, View view) {
         activity1 = activity;
        view1 = view;
        view.post(new Runnable() {
            @Override
            public void run() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {

                    mX = activity.getIntent().getIntExtra("x", 0);
                    mY = activity.getIntent().getIntExtra("y", 0);
                    Animator animator = createRevealAnimator(false, mX, mY);
                    animator.start();
                }
//                content.setVisibility(View.VISIBLE);

            }
        });
    }


    public static Animator createRevealAnimator(boolean reversed, int x, int y) {
        float hypot = (float) Math.hypot(view1.getHeight(), view1.getWidth());
        float startRadius = reversed ? hypot : 0;
        float endRadius = reversed ? 0 : hypot;

        Animator animator = null;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            animator = ViewAnimationUtils.createCircularReveal(
                    view1, x, y,
                    startRadius,
                    endRadius);
        }
        animator.setDuration(800);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        if (reversed)
            animator.addListener(animatorListener);
        return animator;
    }

    private static Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            view1.setVisibility(View.INVISIBLE);
            activity1.finish();
        }

        @Override
        public void onAnimationCancel(Animator animation) {
        }

        @Override
        public void onAnimationRepeat(Animator animation) {
        }
    };

    public static void finshAnim(boolean status,int x,int y) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Animator animator = createRevealAnimator(true, x, y);
            animator.start();
        } else {
            activity1.finish();
        }

    }
}
