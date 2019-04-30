package com.hua.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.PopupWindow;

public class PopupActivity extends AppCompatActivity {

    Button popup;
    PopupWindow pw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup);
        popup = findViewById(R.id.popup);
        popup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View view = LayoutInflater.from(PopupActivity.this).inflate(R.layout.pop, null);
                pw = new PopupWindow(view, popup.getWidth(), ViewGroup.LayoutParams.WRAP_CONTENT);
                pw.setFocusable(true);
                pw.setOutsideTouchable(true);
                pw.showAsDropDown(popup);
            }
        });
    }
}
