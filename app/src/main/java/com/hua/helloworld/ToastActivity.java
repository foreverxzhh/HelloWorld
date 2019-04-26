package com.hua.helloworld;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class ToastActivity extends AppCompatActivity {

    Button t1,t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toast);
        t1 = findViewById(R.id.t1);
        t2 = findViewById(R.id.t2);
        setOnClickListener();
    }
    public void setOnClickListener()
    {
        MyClickListener mListener = new MyClickListener();
        t1.setOnClickListener(mListener);
        t2.setOnClickListener(mListener);
    }
    class MyClickListener implements View.OnClickListener
    {
        @Override
        public void onClick(View v) {
            switch (v.getId())
            {
                case R.id.t1:
                    Toast t1 = Toast.makeText(getApplicationContext(),"居中测试",Toast.LENGTH_SHORT);
                    t1.setGravity(Gravity.CENTER,0,0);
                    t1.show();
                    break;
                case R.id.t2:
                    Toast t2 = Toast.makeText(getApplicationContext(),"图片测试",Toast.LENGTH_SHORT);
                    LayoutInflater ly = LayoutInflater.from(getApplicationContext());
                    View view = ly.inflate(R.layout.list_item,null);
                    ImageView iv = view.findViewById(R.id.iv);
                    TextView tv1,tv2,tv3;
                    tv1 = view.findViewById(R.id.tv1);
                    tv2 = view.findViewById(R.id.tv2);
                    tv3 = view.findViewById(R.id.tv3);
                    tv1.setText("标题");
                    tv2.setText("呵呵");
                    tv3.setText("wow");
                    Glide.with(getApplicationContext()).load("https://www.baidu.com/img/bd_logo1.png").into(iv);
                    t2.setView(view);
                    t2.show();
                    break;
            }
        }
    }
}
