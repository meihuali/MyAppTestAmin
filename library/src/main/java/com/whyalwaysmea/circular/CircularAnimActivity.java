package com.whyalwaysmea.circular;

import android.animation.Animator;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;

/**
 * 简单的Circular动画
 */
public class CircularAnimActivity extends AppCompatActivity implements View.OnClickListener {

    private View secondView;
    private FloatingActionButton floatBtn;
    private FloatingActionButton floatBtn2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular_anim);
        secondView = findViewById(R.id.second);
        floatBtn = (FloatingActionButton) findViewById(R.id.floatBtn);
        floatBtn2 = (FloatingActionButton) findViewById(R.id.floatBtn2);
        floatBtn.setOnClickListener(this);
        floatBtn2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.floatBtn) {
            secondView.setVisibility(View.VISIBLE);
            int centerX = (v.getLeft() + v.getRight()) / 2;
            System.out.println("left : " + v.getLeft());
            System.out.println("right : " + v.getRight());
            int centerY = (v.getTop() + v.getBottom()) / 2;
            // Math.hypot(x,y):  返回sqrt(x2 +y2)
            float finalRadius = (float) Math.hypot((double) centerX, (double) centerY);
            Animator mCircularReveal = ViewAnimationUtils.createCircularReveal(
                    secondView, centerX, centerY, 0, finalRadius);

            mCircularReveal.setDuration(4000).start();
        } else {
            secondView.setVisibility(View.VISIBLE);
            int centerX = 400;
            int centerY = 500;
            // Math.hypot(x,y):  返回sqrt(x2 +y2)
            float finalRadius = (float) Math.hypot((double) centerX, (double) centerY);
            Animator mCircularReveal = ViewAnimationUtils.createCircularReveal(
                    secondView, centerX, centerY, finalRadius, 0);

            mCircularReveal.setDuration(500).start();
        }

    }
}
