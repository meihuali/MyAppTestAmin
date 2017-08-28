package com.whyalwaysmea.circular;

import android.animation.Animator;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity implements View.OnClickListener {

    private View content;
    private int mX;
    private int mY;

    Button btn_start;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        content =  findViewById(R.id.reveal_content);
       // AnimUtils.animhpel(this,content);
/*        content.post(new Runnable() {
            @Override
            public void run() {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    mX = getIntent().getIntExtra("x", 0);
                    mY = getIntent().getIntExtra("y", 0);
                    Animator animator = createRevealAnimator(false, mX, mY);
                    animator.start();
                }
//                content.setVisibility(View.VISIBLE);

            }
        });*/

/*        content.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    Animator animator = createRevealAnimator(true, (int) event.getX(), (int) event.getY());
                    animator.start();
                } else {
                    finish();
                }
                return false;
            }
        });*/

        btn_start = (Button) findViewById(R.id.btn_start);
        btn_start.setOnClickListener(this);
    }



/*
    private Animator createRevealAnimator(boolean reversed, int x, int y) {
        float hypot = (float) Math.hypot(content.getHeight(), content.getWidth());
        float startRadius = reversed ? hypot : 0;
        float endRadius = reversed ? 0 : hypot;

        Animator animator = null;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
            animator = ViewAnimationUtils.createCircularReveal(
                    content, x, y,
                    startRadius,
                    endRadius);
        }
        animator.setDuration(800);
        animator.setInterpolator(new AccelerateDecelerateInterpolator());
        if (reversed)
            animator.addListener(animatorListener);
        return animator;
    }
*/

/*    private Animator.AnimatorListener animatorListener = new Animator.AnimatorListener() {
        @Override
        public void onAnimationStart(Animator animation) {
        }

        @Override
        public void onAnimationEnd(Animator animation) {
            content.setVisibility(View.INVISIBLE);
            finish();
        }

        @Override
        public void onAnimationCancel(Animator animation) {
        }

        @Override
        public void onAnimationRepeat(Animator animation) {
        }
    };*/

    @Override
    public void onBackPressed() {
/*        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Animator animator = createRevealAnimator(true, mX, mY);
            animator.start();
        } else {
            finish();
        }*/
        AnimUtils.finshAnim(true,0,0);
    }

    @Override
    public void onClick(View v) {
/*        int i = v.getId();
        if (i == R.id.btn_start) {
            AnimUtils.finshAnim(true, (int) v.getX(), (int) v.getY());

        }*/
    }
}
