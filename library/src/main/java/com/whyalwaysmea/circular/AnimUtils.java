package com.whyalwaysmea.circular;

import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.RelativeLayout;


/**
 * 项目名：Circular
 * 包名：com.whyalwaysmea.circular
 * 文件名：AnimUtils
 * 创建者 ：$梅华黎
 * 创建时间： 2017/8/28 9:46
 * 描述：TODO
 */
public class AnimUtils {
    private  static SparseArray<View> views = new SparseArray();
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

    /*
    * 第一个参数为 传递当前的对象 这里不多解释
    * 第2个参数为你当前被点击的那个按钮所在的最外层的那个布局的ID 这里不是指总体布局的外层那个ID
    *  例如A在B 里面 那边B 在C 里面·那么这里传递的第2个参数就是 B 这个控件的ID
    *  第3个参数的传递的就是 你点击的那个按钮 所对应的那个 onclick 事件的那个view点getID 的那个view
    * */
    public static void finishAmins(Activity activity,int fukongjianID,View zikongjianID) {
        boolean statuss = true;
        //父控件初始化
         View view = activity.findViewById(fukongjianID);

        int xw  = (int) view.getX();
        int xy  = (int) view.getY();


        //获取子控件的Y轴
        zikongjianID.getWidth();
        int zy = (int) zikongjianID.getY();
        int zx = (int) zikongjianID.getX();
        //计算出当前被点击的控件的Y轴坐标
        int y  = xy+zy;
        int x = xw+zx;
        //调用动画
        finshAnim(statuss,x,y);
    }



    /*
    * 该方法是点击某个按钮 finish 的时候掉用
    * */
    public static void finshAnim(boolean status,int x,int y) {

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Animator animator = createRevealAnimator(true, x, y);
            animator.start();
        } else {
            activity1.finish();
        }

    }


    /*
    * 该方法是按返回键的时候掉用
    * */
    public static void finishonBackPressed() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Animator animator = createRevealAnimator(true, mX, mY);
            animator.start();
        } else {
            activity1.finish();
        }
    }
    /*
    * A界面点击跳转的时候调用·该方法
    * */
    public static void startIntent(Intent i,View view,Activity activity) {
        i.putExtra("x", (int)view.getX());
        i.putExtra("y", (int)view.getY());
        activity.startActivity(i);
    }
}
