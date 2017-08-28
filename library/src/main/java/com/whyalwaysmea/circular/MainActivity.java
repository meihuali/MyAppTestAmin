package com.whyalwaysmea.circular;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final Button startActivity = (Button) findViewById(R.id.start_activity);
        startActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });

        Button circularAnim = (Button) findViewById(R.id.circular_anim);
        circularAnim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CircularAnimActivity.class);
                startActivity(intent);
            }
        });

        Button materialActivity = (Button) findViewById(R.id.material_activity);
        materialActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this, MaterialAnimActivity.class);
                startActivity(intent);
            }
        });

        Button circularButton = (Button) findViewById(R.id.button);
        circularButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CircularButtonActivity.class);
                startActivity(intent);
            }
        });
    }
}
