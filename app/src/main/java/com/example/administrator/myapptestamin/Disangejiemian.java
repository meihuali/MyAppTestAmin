package com.example.administrator.myapptestamin;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.whyalwaysmea.circular.AnimUtils;

/**
 * 项目名：MyAppTestAmin
 * 包名：com.example.administrator.myapptestamin
 * 文件名：Disangejiemian
 * 创建者 ：$梅华黎
 * 创建时间： 2017/9/1 11:56
 * 描述：TODO
 */
public class Disangejiemian extends AppCompatActivity {
    private View ll_layout;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_disangge);

        //程序进来的时候时候的 动画·
        AnimUtils.animhpel((Activity) this,R.id.ll_layout);

    }

    @Override
    public void onBackPressed() {
        AnimUtils.finishonBackPressed((Activity) Disangejiemian.this,R.id.ll_layout);
    }
}
