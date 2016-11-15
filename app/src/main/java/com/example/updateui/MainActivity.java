package com.example.updateui;

import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mButton1, mButton2, mButton3, mButton4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        NetWorkStatus();
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

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            showMyDialog(); //点击BACK弹出对话框
        }

        return false;
    }

    private void showMyDialog() {
        // 创建退出对话框
        AlertDialog isExit = new AlertDialog.Builder(this).create();
        // 设置对话框标题
        isExit.setTitle("提示");
        // 设置对话框消息
        isExit.setMessage("确定要退出吗，未保存的数据将会遗失");
        // 添加选择按钮并注册监听
        isExit.setButton("确定", listener);
        isExit.setButton2("取消", listener);
        // 显示对话框
        isExit.show();
    }

    /**
     * 监听对话框里面的button点击事件
     */
    DialogInterface.OnClickListener listener = new DialogInterface.OnClickListener() {
        public void onClick(DialogInterface dialog, int which) {
            switch (which) {
                case AlertDialog.BUTTON_POSITIVE:// "确认"按钮退出程序
                    finish();
                    break;
                case AlertDialog.BUTTON_NEGATIVE:// "取消"第二个按钮取消对话框
                    break;
                default:
                    break;
            }
        }
    };

    private boolean NetWorkStatus() {

        boolean netSataus = false;

        ConnectivityManager cwjManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);

        cwjManager.getActiveNetworkInfo();

        if (cwjManager.getActiveNetworkInfo() != null) {

            netSataus = cwjManager.getActiveNetworkInfo().isAvailable();

        }

        if (!netSataus) {

            AlertDialog.Builder b = new AlertDialog.Builder(this).setTitle("没有可用的网络")

                    .setMessage("是否对网络进行设置?");

            b.setPositiveButton("是", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int whichButton) {

                    Intent intent = null;
                    /**
                     * 判断手机系统的版本！如果API大于10 就是3.0+
                     * 因为3.0以上的版本的设置和3.0以下的设置不一样，调用的方法不同
                     */
                    if (android.os.Build.VERSION.SDK_INT > 10) {
                        intent = new Intent(android.provider.Settings.ACTION_WIFI_SETTINGS);
                    } else {
                        intent = new Intent();
                        ComponentName component = new ComponentName(
                                "com.android.settings",
                                "com.android.settings.WirelessSettings");
                        intent.setComponent(component);
                        intent.setAction("android.intent.action.VIEW");
                    }
                    startActivity(intent);
                }

            }).setNeutralButton("否", new DialogInterface.OnClickListener() {

                public void onClick(DialogInterface dialog, int whichButton) {

                    dialog.cancel();

                }

            }).show();

        }

        return netSataus;

    }
}
