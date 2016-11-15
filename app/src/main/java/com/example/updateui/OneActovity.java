package com.example.updateui;

import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
/*
*
* 使用Handler消息传递机制
*
* */
public class OneActovity extends AppCompatActivity {
    private TextView mTextView;

    Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0x123) {
                mTextView.setText("使用Handler消息传递机制");
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_one);
        mTextView = (TextView) findViewById(R.id.one_text);
        new MyThread().start();
    }

    class MyThread extends Thread {
        @Override
        public void run() {
            super.run();
            try {
                //延迟两秒更新
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            mHandler.sendEmptyMessage(0x123);
        }
    }
}
