package com.hua.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class EditTextActivity extends AppCompatActivity {

    private Button login;
    private EditText usr, pwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_text);
        login = findViewById(R.id.login);
        usr = findViewById(R.id.usr);
        pwd = findViewById(R.id.pwd);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(EditTextActivity.this, "登录成功。", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(EditTextActivity.this, LoginActivity.class);
                intent.putExtra("usr", usr.getText().toString());
                intent.putExtra("pwd", pwd.getText().toString());
                startActivity(intent);
            }
        });

        usr.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i("hua", "usr:" + s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        pwd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.i("hua", "pwd:" + s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
