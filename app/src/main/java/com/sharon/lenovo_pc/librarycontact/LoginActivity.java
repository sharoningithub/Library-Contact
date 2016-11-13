package com.sharon.lenovo_pc.librarycontact;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Lenovo-pc on 2016/11/11.
 */
public class LoginActivity extends Activity{
    private Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.loginpage);
        btn = (Button)findViewById(R.id.login_button);
        //注册点击事件
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =new Intent(LoginActivity.this,MainActivity.class);//第一个参数：上下文对象；第二个参数：class文件
                startActivity(intent);
            }
        });
    }
}
