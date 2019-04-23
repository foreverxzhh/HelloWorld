package com.hua.helloworld;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;


public class TextViewActivity extends AppCompatActivity {

    private TextView tv1, tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);
        tv1 = findViewById(R.id.tv1);
        tv2 = findViewById(R.id.tv2);
        tv1.setSelected(true);
        tv1.getPaint().setFlags(Paint.STRIKE_THRU_TEXT_FLAG);
        tv2.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
    }
}
