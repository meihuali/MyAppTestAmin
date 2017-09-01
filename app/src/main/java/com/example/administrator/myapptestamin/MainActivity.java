package com.example.administrator.myapptestamin;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import com.whyalwaysmea.circular.AnimUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_start;
    private LinearLayout ll_layoutss;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        btn_start = findViewById(R.id.btn_start);
        btn_start.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_start:
                //点击跳转
                Intent intent = new Intent(MainActivity.this,TestActivity.class);
                AnimUtils.startIntent(intent,view, (Activity) MainActivity.this,R.id.ll_layoutss);
                break;
        }
    }


}
