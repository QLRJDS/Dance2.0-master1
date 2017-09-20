package com.example.danceapp.dance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

/**
 * Created by Jinya LIANG on 2017/9/17.
 */
public class LogActivity extends AppCompatActivity implements View.OnClickListener{

    Button login,register;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_login);

        initView();
    }
    private void initView()//初始化控件
    {
        login= (Button) findViewById(R.id.login_bt);
        login.setOnClickListener(this);

        register = (Button) findViewById(R.id.register_bt);
        register.setOnClickListener(this) ;
    }

    public void onClick(View v) {
        switch (v.getId()) {
            /*case R.id.back_to_room://
                finish();
                break;*/
            case R.id.register_bt://注册
                Intent intent = new Intent(LogActivity.this, RegisterActivity.class);
                LogActivity.this.startActivity(intent);
                break;
        }
    }
}
