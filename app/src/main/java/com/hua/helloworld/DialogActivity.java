package com.hua.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hua.helloworld.view.MyDialog;

public class DialogActivity extends AppCompatActivity {

    Button dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);
        dialog = findViewById(R.id.dialog);
        dialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog dl = new MyDialog(DialogActivity.this, new MyDialog.OnClickListener() {
                    @Override
                    public void onClick(View v, MyDialog myDialog) {
                        switch (v.getId()) {
                            case R.id.btn1:
                                Toast.makeText(DialogActivity.this, "确定", Toast.LENGTH_SHORT).show();
                                myDialog.dismiss();
                                break;
                            case R.id.btn2:
                                Toast.makeText(DialogActivity.this, "取消", Toast.LENGTH_SHORT).show();
                                myDialog.dismiss();
                                break;
                        }
                    }
                });
                dl.setTitle("Warning!").setContent("Boom!!!!!!").show();
            }
        });
    }
}
