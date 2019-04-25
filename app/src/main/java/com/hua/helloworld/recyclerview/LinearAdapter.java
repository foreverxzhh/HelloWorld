package com.hua.helloworld.recyclerview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.hua.helloworld.R;

public class LinearAdapter extends RecyclerView.Adapter<LinearAdapter.MyViewHolder> {
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;

    LinearAdapter(Context context, OnItemClickListener onItemClickListener, OnItemLongClickListener OnItemLongClickListener)
    {
        mContext = context;
        mOnItemClickListener = onItemClickListener;
        mOnItemLongClickListener = OnItemLongClickListener;
    }

    @NonNull
    @Override
    public LinearAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.grid_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull LinearAdapter.MyViewHolder viewHolder,final int i) {
        Glide.with(mContext).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556109317772&di=fc98aca9ed600de2f8eb044d947b2f48&imgtype=0&src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farticle%2Fd6ed6cb561c5ae3230c7ee87ef62e36f44fe5448.jpg").into(viewHolder.iv);
        viewHolder.tv.setText("独角兽");
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mOnItemClickListener.onClick(i);
            }
        });
        viewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                mOnItemLongClickListener.onClick(i);
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return 30;
    }

    class MyViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView iv;
        private TextView tv;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
        }
    }

    public interface  OnItemClickListener
    {
        void onClick(int pos);
    }

    public interface OnItemLongClickListener
    {
        void onClick(int pos);
    }
}
