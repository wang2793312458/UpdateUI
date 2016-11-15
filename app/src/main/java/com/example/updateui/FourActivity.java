package com.example.updateui;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/*
*
* 使用Handler的post(Runnabel)方法
*
* */
public class FourActivity extends AppCompatActivity {
private TextView mTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four);
        mTextView= (TextView) findViewById(R.id.four_text);
        Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                mTextView.setText("使用Handler的post(Runnabel)方法");
            }
        });
    }
}
