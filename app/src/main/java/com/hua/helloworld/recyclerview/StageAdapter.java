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

public class StageAdapter extends RecyclerView.Adapter<StageAdapter.MyViewHolder> {
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;
    private OnItemLongClickListener mOnItemLongClickListener;

    StageAdapter(Context context, OnItemClickListener onItemClickListener, OnItemLongClickListener onItemLongClickListener) {
        mContext = context;
        mOnItemClickListener = onItemClickListener;
        mOnItemLongClickListener = onItemLongClickListener;
    }

    @NonNull
    @Override
    public StageAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new MyViewHolder(LayoutInflater.from(mContext).inflate(R.layout.grid_item, viewGroup, false));
    }

    @Override
    public void onBindViewHolder(@NonNull StageAdapter.MyViewHolder viewHolder, final int i) {
        if (i % 3 == 0) {
            Glide.with(mContext).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556109317772&di=fc98aca9ed600de2f8eb044d947b2f48&imgtype=0&src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farticle%2Fd6ed6cb561c5ae3230c7ee87ef62e36f44fe5448.jpg").into(viewHolder.iv);
        } else if (i % 3 == 1) {
            Glide.with(mContext).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556200438236&di=3cd4f878f0024168075bc54b6cf8c4b2&imgtype=0&src=http%3A%2F%2Fimgup02.fanw8.com%2Ffanw8%2F2019-01%2F30%2F11%2F15488179212755_0.jpg").into(viewHolder.iv);
        } else {
            Glide.with(mContext).load("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556200842995&di=842cac1ac1d7bcdaae04d8d928eacc38&imgtype=0&src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farticle%2Fdab0fc5b1f72efec9563a92aeaae57fc60989b41.jpg").into(viewHolder.iv);
        }
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

    class MyViewHolder extends RecyclerView.ViewHolder {
        private ImageView iv;
        private TextView tv;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            iv = itemView.findViewById(R.id.iv);
            tv = itemView.findViewById(R.id.tv);
        }
    }

    public interface OnItemClickListener {
        void onClick(int pos);
    }

    public interface OnItemLongClickListener {
        void onClick(int pos);
    }
}
