package com.qnjsdk.demo.sdkdemo;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.qckj.qnjsdk.QNJSdk;
import com.qckj.qnjsdk.QnjsdkBackCallback;
import com.qckj.qnjsdk.QnjsdkCallback;
import com.qckj.qnjsdk.bean.QnjsdkResult;
import com.qnjsdk.demo.R;


public class MainActivity extends Activity {

    EditText et_uuid;
    EditText et_phone;
    EditText et_color;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et_uuid = findViewById(R.id.et_uuid);
        et_phone = findViewById(R.id.et_phone);
        et_color = findViewById(R.id.et_color);


    }

    public void clickStart(View view) {
        String uuid = et_uuid.getText().toString();
        String phone = et_phone.getText().toString();
        String color = et_color.getText().toString();
        //设置主题色
        QNJSdk.setThemeColor(color);
        //设置退出sdk的回调方法
        QNJSdk.setBackCallback(new QnjsdkBackCallback() {
            @Override
            public void onBack() {
                Toast.makeText(MainActivity.this, "退出了sdk", Toast.LENGTH_LONG).show();
            }
        });
        /*
            Context context           上下文
            String phone              用户手机号
            String uid                用户uid
            QnjsdkCallback callback   sdk启动成功失败的回调
         */
        QNJSdk.start(MainActivity.this, phone, uuid, new QnjsdkCallback() {
            @Override
            public void onResult(QnjsdkResult result) {
                Toast.makeText(MainActivity.this, "code :" + result.getCode() + "\nmsg: " + result.getMsg(), Toast.LENGTH_LONG).show();
            }
        });
    }

}
