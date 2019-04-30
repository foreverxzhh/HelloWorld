package com.hua.helloworld;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AlertDialogActivity extends AppCompatActivity {

    Button btn1, btn2, btn3, btn4, btn5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
        btn1 = findViewById(R.id.aleartdialog1);
        btn2 = findViewById(R.id.aleartdialog2);
        btn3 = findViewById(R.id.aleartdialog3);
        btn4 = findViewById(R.id.aleartdialog4);
        btn5 = findViewById(R.id.aleartdialog5);
        setOnClickListener();

    }

    void setOnClickListener() {
        MyListener ml = new MyListener();
        btn1.setOnClickListener(ml);
        btn2.setOnClickListener(ml);
        btn3.setOnClickListener(ml);
        btn4.setOnClickListener(ml);
        btn5.setOnClickListener(ml);
    }

    class MyListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.aleartdialog1:
                    AlertDialog.Builder builder = new AlertDialog.Builder(AlertDialogActivity.this);//注意这里context要传Activity的
                    builder.setTitle("请选择你的性别")
                            .setIcon(R.drawable.ic_launcher_foreground)
                            .setPositiveButton("男", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(AlertDialogActivity.this, "基佬", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setNegativeButton("女", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(AlertDialogActivity.this, "姬佬", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .setNeutralButton("扶他", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(AlertDialogActivity.this, "额。。。", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .show();
                    break;
                case R.id.aleartdialog2:
                    AlertDialog.Builder builder1 = new AlertDialog.Builder(AlertDialogActivity.this);
                    String item[] = {"上", "中", "下"};
                    builder1.setTitle("你打哪一路？")
                            .setItems(item, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    switch (which) {
                                        case 0:
                                            Toast.makeText(AlertDialogActivity.this, "你是上单", Toast.LENGTH_SHORT).show();
                                            break;
                                        case 1:
                                            Toast.makeText(AlertDialogActivity.this, "你是中单", Toast.LENGTH_SHORT).show();
                                            break;
                                        case 2:
                                            Toast.makeText(AlertDialogActivity.this, "你是ADC", Toast.LENGTH_SHORT).show();
                                            break;
                                    }
                                }
                            })
                            .show();
                    break;
                case R.id.aleartdialog3:
                    AlertDialog.Builder builder2 = new AlertDialog.Builder(AlertDialogActivity.this);
                    String item2[] = {"上", "中", "下"};
                    builder2.setTitle("你打哪一路？")
                            .setSingleChoiceItems(item2, 0, new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    switch (which) {
                                        case 0:
                                            Toast.makeText(AlertDialogActivity.this, "你是上单", Toast.LENGTH_SHORT).show();
                                            dialog.dismiss();//点击选项消失
                                            break;
                                        case 1:
                                            Toast.makeText(AlertDialogActivity.this, "你是中单", Toast.LENGTH_SHORT).show();
                                            dialog.dismiss();
                                            break;
                                        case 2:
                                            Toast.makeText(AlertDialogActivity.this, "你是ADC", Toast.LENGTH_SHORT).show();
                                            dialog.dismiss();
                                            break;
                                    }
                                }
                            })
                            .setCancelable(false)//点击外边不消失
                            .show();
                    break;
                case R.id.aleartdialog4:
                    AlertDialog.Builder builder3 = new AlertDialog.Builder(AlertDialogActivity.this);
                    String item3[] = {"上", "中", "下"};
                    boolean check[] = {true, false, false};
                    builder3.setTitle("你打哪一路？")
                            .setMultiChoiceItems(item3, check, new DialogInterface.OnMultiChoiceClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                                    switch (which) {
                                        case 0:
                                            if (isChecked)
                                                Toast.makeText(AlertDialogActivity.this, "你是上单", Toast.LENGTH_SHORT).show();
                                            break;
                                        case 1:
                                            if (isChecked)
                                                Toast.makeText(AlertDialogActivity.this, "你是中单", Toast.LENGTH_SHORT).show();
                                            break;
                                        case 2:
                                            if (isChecked)
                                                Toast.makeText(AlertDialogActivity.this, "你是ADC", Toast.LENGTH_SHORT).show();
                                            break;
                                    }
                                }
                            })
                            .setCancelable(false)
                            .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    Toast.makeText(AlertDialogActivity.this, "确定", Toast.LENGTH_SHORT).show();
                                }
                            })
                            .show();
                    break;
                case R.id.aleartdialog5:
                    AlertDialog.Builder builder4 = new AlertDialog.Builder(AlertDialogActivity.this);
                    View view = LayoutInflater.from(AlertDialogActivity.this).inflate(R.layout.activity_edit_text, null);
                    Button login = view.findViewById(R.id.login);
                    final EditText usr = view.findViewById(R.id.usr);
                    final EditText pwd = view.findViewById(R.id.pwd);
                    login.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(AlertDialogActivity.this, LoginActivity.class);
                            intent.putExtra("usr", usr.getText().toString());
                            intent.putExtra("pwd", pwd.getText().toString());
                            startActivity(intent);
                        }
                    });
                    builder4.setTitle("请先登录")
                            .setView(view)
                            .show();
                    break;
            }
        }
    }
}
