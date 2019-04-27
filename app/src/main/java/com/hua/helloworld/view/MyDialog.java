package com.hua.helloworld.view;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.hua.helloworld.R;

public class MyDialog extends Dialog implements View.OnClickListener {
    private TextView title, content, btn1, btn2;
    private String title1, content1;
    private OnClickListener mOnClickListener;

    public MyDialog(Context context,OnClickListener listener) {
        super(context);
        mOnClickListener = listener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_dialog);

        WindowManager wm = getWindow().getWindowManager();
        Display d = wm.getDefaultDisplay();
        WindowManager.LayoutParams p = getWindow().getAttributes();
        Point size = new Point();
        d.getSize(size);
        p.width = (int)(size.x*0.8);
        getWindow().setAttributes(p);
        //调整弹窗大小

        getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        //设置弹窗背景透明，不然无法实现圆角效果

        title = findViewById(R.id.title);
        content = findViewById(R.id.content);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        if(title != null)
            title.setText(title1);
        if(content != null)
            content.setText(content1);
    }

    public MyDialog setTitle(String string)
    {
        title1 = string;
        return this;
    }

    public MyDialog setContent(String string)
    {
        content1 = string;
        return this;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId())
        {
            case R.id.btn1:
                mOnClickListener.onClick(v, this);
                break;
            case R.id.btn2:
                mOnClickListener.onClick(v, this);
                break;
        }
    }

    public interface OnClickListener
    {
        void onClick(View v, MyDialog myDialog);
    }
}
