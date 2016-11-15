package com.example.updateui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/*
*
*使用runOnUiThread(action)方法
*
* */
public class ThreeActivity extends AppCompatActivity {
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);
        mTextView = (TextView) findViewById(R.id.text_three);
        new MyThread().start();
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(4000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    mTextView.setText("使用runOnUiThread(action)方法");
                }
            });
        }
    }
}
