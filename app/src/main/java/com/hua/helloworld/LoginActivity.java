package com.hua.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class LoginActivity extends AppCompatActivity {

    private TextView usr, pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i("hua", "usr:" + getIntent().getExtras().getString("usr") + ";pwd:" + getIntent().getExtras().getString("pwd"));
        usr = findViewById(R.id.usr);
        pwd = findViewById(R.id.pwd);
        usr.setText("用户名是：" + getIntent().getExtras().getString("usr"));
        pwd.setText("密码是：" + getIntent().getExtras().getString("pwd"));
    }
}
