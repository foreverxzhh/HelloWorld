package com.hua.helloworld.recyclerview;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;


import com.hua.helloworld.R;

public class HorLinearActivity extends AppCompatActivity {

    private RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hor_linear);
        rv = findViewById(R.id.rv);
        LinearLayoutManager lm = new LinearLayoutManager(this);
        lm.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv.setLayoutManager(lm);
        rv.addItemDecoration(new MyDecoration());
        rv.setAdapter(new HorLinearAdapter(HorLinearActivity.this, new HorLinearAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(HorLinearActivity.this, "点击pos:"+pos, Toast.LENGTH_SHORT).show();
            }
        }, new HorLinearAdapter.OnItemLongClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(HorLinearActivity.this, "长按pos:"+pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }

    class MyDecoration extends RecyclerView.ItemDecoration
    {
        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            super.getItemOffsets(outRect, view, parent, state);
            outRect.set(0,0,1,0);
        }
    }
}
