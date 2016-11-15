package com.example.updateui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mButton1, mButton2, mButton3, mButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mButton1 = (Button) findViewById(R.id.butten1);
        mButton1.setOnClickListener(this);
        mButton2 = (Button) findViewById(R.id.butten2);
        mButton2.setOnClickListener(this);
        mButton3 = (Button) findViewById(R.id.butten3);
        mButton3.setOnClickListener(this);
        mButton4 = (Button) findViewById(R.id.butten4);
        mButton4.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.butten1:
                startActivity(new Intent(MainActivity.this, OneActovity.class));
                break;
            case R.id.butten2:
                startActivity(new Intent(MainActivity.this, TwoActivity.class));
                break;
            case R.id.butten3:
                startActivity(new Intent(MainActivity.this, ThreeActivity.class));
                break;
            case R.id.butten4:
                startActivity(new Intent(MainActivity.this, FourActivity.class));
                break;

        }
    }
}
