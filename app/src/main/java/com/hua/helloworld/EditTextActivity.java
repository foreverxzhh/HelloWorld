package com.hua.helloworld;

import android.content.Intent;
import android.support.annotation.Nullable;
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
                Bundle bundle = new Bundle();
                bundle.putString("usr", usr.getText().toString());
                bundle.putString("pwd", pwd.getText().toString());
                intent.putExtras(bundle);
                startActivityForResult(intent, 0);
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0) {
            if (resultCode == RESULT_OK) {
                Toast.makeText(this, "" + data.getExtras().getString("result"), Toast.LENGTH_SHORT).show();
            }
        }
    }
}
