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

public class MainActivity extends AppCompatActivity {

    private Button textview, button, edittext, radiobutton, checkbox, imageview, listview, gridview, webview;
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
                case R.id.webview:
                    intent = new Intent(MainActivity.this, WebViewActivity.class);
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
