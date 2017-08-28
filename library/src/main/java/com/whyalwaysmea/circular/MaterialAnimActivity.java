package com.whyalwaysmea.circular;

import android.animation.Animator;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

/**
 * github上找的一个demo
 * 相关连接：https://github.com/4k3R/material-card-animation
 */
public class MaterialAnimActivity extends AppCompatActivity {

    ImageView imageView;
    ImageButton imageButton, closeButton;
    RelativeLayout revealView;
    LinearLayout layoutButtons;
    Animation alphaAppear, alphaDisappear;
    int x, y, width, height, hypotenuse;
    float pixelDensity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_material_anim);

        pixelDensity = getResources().getDisplayMetrics().density;

        imageView = (ImageView) findViewById(R.id.imageView);
        imageButton = (ImageButton) findViewById(R.id.launchTwitterAnimation);
        closeButton = (ImageButton) findViewById(R.id.closeButton);
        revealView = (RelativeLayout) findViewById(R.id.linearView);
        layoutButtons = (LinearLayout) findViewById(R.id.layoutButtons);

        alphaAppear = AnimationUtils.loadAnimation(this, R.anim.alpha_anim);
        alphaDisappear = AnimationUtils.loadAnimation(this, R.anim.alpha_disappear);


        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                launchTwitter(view);
            }
        });

        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                closeTwitter(view);
            }
        });
    }

    public void launchTwitter(View view) {

        /*
         MARGIN_RIGHT = 16dp
         FAB_BUTTON_RADIUS = 28dp
         */
        width = imageView.getWidth();
        height = imageView.getHeight();

        x = width / 2;
        y = height / 2;
        hypotenuse = (int) Math.hypot(x, y);

        x = (int) (x - ((16 * pixelDensity) + (28 * pixelDensity)));

        FrameLayout.LayoutParams parameters = (FrameLayout.LayoutParams)
                revealView.getLayoutParams();
        parameters.height = imageView.getHeight();
        revealView.setLayoutParams(parameters);

        imageButton.animate()
                .translationX(-x)
                .translationY(-y)
                .setDuration(200)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {

                        Animator anim = ViewAnimationUtils.createCircularReveal(revealView, width / 2, height / 2, 28 * pixelDensity, hypotenuse);
                        anim.setDuration(350);
                        anim.addListener(new Animator.AnimatorListener() {
                            @Override
                            public void onAnimationStart(Animator animator) {
                                System.out.println("start");
                            }

                            @Override
                            public void onAnimationEnd(Animator animator) {
                                layoutButtons.setVisibility(View.VISIBLE);
                                closeButton.setVisibility(View.VISIBLE);
                                layoutButtons.startAnimation(alphaAppear);
                                closeButton.startAnimation(alphaAppear);
                                System.out.println("startend");

                            }

                            @Override
                            public void onAnimationCancel(Animator animator) {

                            }

                            @Override
                            public void onAnimationRepeat(Animator animator) {

                            }
                        });
                        imageButton.setVisibility(View.GONE);
                        revealView.setVisibility(View.VISIBLE);
                        anim.start();
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });
    }

    public void closeTwitter(View view) {

        alphaDisappear.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Animator anim = ViewAnimationUtils.createCircularReveal(revealView, width / 2, height / 2, hypotenuse, 28 * pixelDensity);
                anim.setDuration(350);
                anim.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        revealView.setVisibility(View.GONE);
                        imageButton.setVisibility(View.VISIBLE);
                        imageButton.animate()
                                .translationX(0f)
                                .translationY(0f)
                                .setDuration(200)
                                .setListener(null);
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });
                anim.start();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

        layoutButtons.setVisibility(View.GONE);
        closeButton.setVisibility(View.GONE);
        layoutButtons.startAnimation(alphaDisappear);
        closeButton.startAnimation(alphaDisappear);
    }
}
