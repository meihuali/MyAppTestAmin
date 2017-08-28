package com.example.administrator.myapptestamin;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.whyalwaysmea.circular.AnimUtils;

/**
 * 项目名：MyAppTestAmin
 * 包名：com.example.administrator.myapptestamin
 * 文件名：TestActivity
 * 创建者 ：$梅华黎
 * 创建时间： 2017/8/28 13:56
 * 描述：TODO
 */
public class TestActivity extends AppCompatActivity implements View.OnClickListener {

    private View ll_layout;
    private Button btn_start;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initView();
        iniAniM();
    }

    private void initView() {
        //根布局的 ID
        ll_layout = findViewById(R.id.ll_layout);
        //按钮的ID
        btn_start = (Button)findViewById(R.id.btn_start);
        btn_start.setOnClickListener(this);
    }
    /*
    *  动画
    * */
    private void iniAniM() {
        //程序进来的时候时候的 动画·
        AnimUtils.animhpel((Activity) this,ll_layout);
    }


    /*
    * 这里是点击 button 按钮返回的动画·
    * */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                AnimUtils.finshAnim(true,(int)view.getX(),(int)view.getY());
                break;
        }
    }
    /*
    * 按返回键的动画
    * */
    @Override
    public void onBackPressed() {
        AnimUtils.finishonBackPressed();
    }
}
