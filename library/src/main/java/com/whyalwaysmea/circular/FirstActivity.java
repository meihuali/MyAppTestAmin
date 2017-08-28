package com.whyalwaysmea.circular;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_start;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

 /*       View v = findViewById(R.id.touch_me_view);
        v.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent i = new Intent(FirstActivity.this, SecondActivity.class);
                i.putExtra("x", (int)event.getX());
                i.putExtra("y", (int)event.getY());
                startActivity(i);
                return false;
            }
        });*/

        initView();
    }

    private void initView() {
        btn_start = (Button) findViewById(R.id.btn_start);
        btn_start.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
/*        int i1 = v.getId();
        if (i1 == R.id.btn_start) {
            Intent i = new Intent(FirstActivity.this, SecondActivity.class);
            i.putExtra("x", (int) v.getX());
            i.putExtra("y", (int) v.getY());
            startActivity(i);

        }*/
    }
}
