package com.hua.helloworld;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.hua.helloworld.gridview.GridViewActivity;
import com.hua.helloworld.listview.ListViewActivity;
import com.hua.helloworld.recyclerview.RecyclerActivity;

public class MainActivity extends AppCompatActivity {

    private Button textview, button, edittext, radiobutton, checkbox, imageview, listview, gridview, webview, recyclerview, toast,alertdialog, progress, dialog, popup;
    private long time = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview = findViewById(R.id.textview);
        button = findViewById(R.id.button);
        edittext = findViewById(R.id.edittext);
        radiobutton = findViewById(R.id.radiobutton);
        checkbox = findViewById(R.id.checkbox);
        imageview = findViewById(R.id.imageview);
        listview = findViewById(R.id.listview);
        gridview = findViewById(R.id.gridview);
        webview = findViewById(R.id.webview);
        recyclerview = findViewById(R.id.recyclerview);
        toast = findViewById(R.id.toast);
        alertdialog = findViewById(R.id.alertdialog);
        progress = findViewById(R.id.progress);
        dialog = findViewById(R.id.dialog);
        popup = findViewById(R.id.popup);
        setOnClickListener();
    }

    private void setOnClickListener() {
        onClickListener mOnclickListener = new onClickListener();
        textview.setOnClickListener(mOnclickListener);
        button.setOnClickListener(mOnclickListener);
        edittext.setOnClickListener(mOnclickListener);
        radiobutton.setOnClickListener(mOnclickListener);
        checkbox.setOnClickListener(mOnclickListener);
        imageview.setOnClickListener(mOnclickListener);
        listview.setOnClickListener(mOnclickListener);
        gridview.setOnClickListener(mOnclickListener);
        webview.setOnClickListener(mOnclickListener);
        recyclerview.setOnClickListener(mOnclickListener);
        toast.setOnClickListener(mOnclickListener);
        alertdialog.setOnClickListener(mOnclickListener);
        progress.setOnClickListener(mOnclickListener);
        dialog.setOnClickListener(mOnclickListener);
        popup.setOnClickListener(mOnclickListener);
    }

    private class onClickListener implements View.OnClickListener {
        Intent intent = null;

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.textview:
                    intent = new Intent(MainActivity.this, TextViewActivity.class);
                    break;
                case R.id.button:
                    intent = new Intent(MainActivity.this, ButtonActivity.class);
                    break;
                case R.id.edittext:
                    intent = new Intent(MainActivity.this, EditTextActivity.class);
                    break;
                case R.id.radiobutton:
                    intent = new Intent(MainActivity.this, RadioButtonActivity.class);
                    break;
                case R.id.checkbox:
                    intent = new Intent(MainActivity.this, CheckBoxActivity.class);
                    break;
                case R.id.imageview:
                    intent = new Intent(MainActivity.this, ImageViewActivity.class);
                    break;
                case R.id.listview:
                    intent = new Intent(MainActivity.this, ListViewActivity.class);
                    break;
                case R.id.gridview:
                    intent = new Intent(MainActivity.this, GridViewActivity.class);
                    break;
                case R.id.webview:
                    intent = new Intent(MainActivity.this, WebViewActivity.class);
                    break;
                case R.id.recyclerview:
                    intent = new Intent(MainActivity.this, RecyclerActivity.class);
                    break;
                case R.id.toast:
                    intent = new Intent(MainActivity.this, ToastActivity.class);
                    break;
                case R.id.alertdialog:
                    intent = new Intent(MainActivity.this, AlertDialogActivity.class);
                    break;
                case R.id.progress:
                    intent = new Intent(MainActivity.this, ProgressActivity.class);
                    break;
                case R.id.dialog:
                    intent = new Intent(MainActivity.this, DialogActivity.class);
                    break;
                case R.id.popup:
                    intent = new Intent(MainActivity.this, PopupActivity.class);
                    break;
            }
            startActivity(intent);
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            if(System.currentTimeMillis() - time > 2000)
            {
                time = System.currentTimeMillis();
                Toast.makeText(this, "再次点击返回键退出。", Toast.LENGTH_SHORT).show();
                return true;
            }

        }
        return super.onKeyDown(keyCode, event);
    }
}
