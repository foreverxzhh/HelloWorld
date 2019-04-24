package com.hua.helloworld.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hua.helloworld.R;

public class MyListViewAdapter extends BaseAdapter {

    private Context mContext;
    private LayoutInflater layoutInflater;

    public MyListViewAdapter(Context context)
    {
        mContext = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 10;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    static class ViewHandler
    {
        public ImageView iv;
        public TextView tv1, tv2, tv3;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHandler vh = null;
        if(convertView == null)
        {
            convertView = layoutInflater.inflate(R.layout.list_item,null);
            vh = new ViewHandler();
            vh.iv = convertView.findViewById(R.id.iv);
            vh.tv1 = convertView.findViewById(R.id.tv1);
            vh.tv2 = convertView.findViewById(R.id.tv2);
            vh.tv3 = convertView.findViewById(R.id.tv3);
            convertView.setTag(vh);
            Glide.with(mContext).load("https://www.baidu.com/img/bd_logo1.png").into(vh.iv);
            vh.tv1.setText("这是标题");
            vh.tv2.setText("2019-04-24");
            vh.tv3.setText("这是内容");
        }
        else
        {
            vh = (ViewHandler) convertView.getTag();
        }
        return convertView;
    }
}
