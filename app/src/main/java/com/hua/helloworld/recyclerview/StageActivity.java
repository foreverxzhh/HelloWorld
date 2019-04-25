package com.hua.helloworld.recyclerview;

import android.graphics.Rect;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;

import com.hua.helloworld.R;

public class StageActivity extends AppCompatActivity {

    RecyclerView rv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stage);
        rv = findViewById(R.id.rv);
        rv.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        rv.addItemDecoration(new RecyclerView.ItemDecoration() {
            @Override
            public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
                super.getItemOffsets(outRect, view, parent, state);
                outRect.set(1,1,1,1);
            }
        });
        rv.setAdapter(new StageAdapter(this, new StageAdapter.OnItemClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(StageActivity.this, "点击pos：" + pos, Toast.LENGTH_SHORT).show();
            }
        }, new StageAdapter.OnItemLongClickListener() {
            @Override
            public void onClick(int pos) {
                Toast.makeText(StageActivity.this, "长按pos：" + pos, Toast.LENGTH_SHORT).show();
            }
        }));
    }
}
