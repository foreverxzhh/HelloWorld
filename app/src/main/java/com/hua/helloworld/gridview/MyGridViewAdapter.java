package com.hua.helloworld.gridview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hua.helloworld.R;

public class MyGridViewAdapter extends BaseAdapter {
    private Context mContext;
    private LayoutInflater layoutInflater;

    public MyGridViewAdapter(Context context) {
        this.mContext = context;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return 12;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    class ViewHolder {
        public ImageView iv;
        public TextView tv;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.grid_item, null);
            vh = new ViewHolder();
            vh.iv = convertView.findViewById(R.id.iv);
            vh.tv = convertView.findViewById(R.id.tv);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        Glide.with(mContext).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556109317772&di=fc98aca9ed600de2f8eb044d947b2f48&imgtype=0&src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farticle%2Fd6ed6cb561c5ae3230c7ee87ef62e36f44fe5448.jpg").into(vh.iv);
        vh.tv.setText("独角兽");
        return convertView;
    }
}
