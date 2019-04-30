package com.hua.helloworld.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hua.helloworld.R;

public class RecyclerActivity extends AppCompatActivity {

    private Button linear, horlinear, stage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        linear = findViewById(R.id.linear);
        linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerActivity.this, LinearActivity.class);
                startActivity(intent);
            }
        });
        horlinear = findViewById(R.id.linear_hor);
        horlinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerActivity.this, HorLinearActivity.class);
                startActivity(intent);
            }
        });
        stage = findViewById(R.id.stage);
        stage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(RecyclerActivity.this, StageActivity.class);
                startActivity(intent);
            }
        });
    }
}
