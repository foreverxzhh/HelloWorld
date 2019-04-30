package com.hua.helloworld;

import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

public class ProgressActivity extends AppCompatActivity {

    ProgressBar p1, p2;
    Button download, progressdialog1, progressdialog2;
    ProgressDialog pd, pd2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);
        p1 = findViewById(R.id.p1);
        p2 = findViewById(R.id.p2);
        download = findViewById(R.id.download);
        p2.setProgress(0);
        p2.setSecondaryProgress(0);
        download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                handler.sendEmptyMessage(0);
            }
        });
        progressdialog1 = findViewById(R.id.progressdialog1);
        progressdialog2 = findViewById(R.id.progressdialog2);
        progressdialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd = new ProgressDialog(ProgressActivity.this);
                pd.setTitle("下载中");
                pd.setMessage("请稍后");
                pd.show();
            }
        });

        progressdialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pd2 = new ProgressDialog(ProgressActivity.this);
                pd2.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
                pd2.setTitle("下载中");
                pd2.setMessage("请稍后");
                pd2.setButton(DialogInterface.BUTTON_POSITIVE, "好", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(ProgressActivity.this, "取消", Toast.LENGTH_SHORT).show();
                    }
                });
                pd2.show();
                handler2.sendEmptyMessage(0);
            }
        });
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (p2.getProgress() < 100) {
                if (p2.getSecondaryProgress() < 100) {
                    p2.setSecondaryProgress(p2.getSecondaryProgress() + 10);
                } else {
                    p2.setSecondaryProgress(0);
                    p2.setProgress(p2.getProgress() + 1);
                }
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        handler.sendEmptyMessage(0);
                    }
                }, 100);
            } else {
                Toast.makeText(ProgressActivity.this, "下载完毕", Toast.LENGTH_SHORT).show();
            }
        }
    };

    Handler handler2 = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (pd2.getProgress() < 100) {
                if (pd2.getSecondaryProgress() < 100) {
                    pd2.setSecondaryProgress(pd2.getSecondaryProgress() + 10);
                } else {
                    pd2.setSecondaryProgress(0);
                    pd2.setProgress(pd2.getProgress() + 1);
                }
                handler2.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        handler2.sendEmptyMessage(0);
                    }
                }, 100);
            } else {
                Toast.makeText(ProgressActivity.this, "下载完毕", Toast.LENGTH_SHORT).show();
            }
        }
    };
}
