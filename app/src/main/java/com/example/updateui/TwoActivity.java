package com.example.updateui;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

/*
*
*使用AsyncTask异步任务
注：更新UI的操作只能在onPostExecute(String result)方法中。
*
*
* */
public class TwoActivity extends AppCompatActivity {
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two);
        mTextView = (TextView) findViewById(R.id.two_text);
        new YIBU().execute();
    }

    class YIBU extends AsyncTask<String, String, String> {

        @Override
        protected String doInBackground(String... strings) {

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return null;
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            mTextView.setText("使用AsyncTask异步任务");
        }
    }
}
