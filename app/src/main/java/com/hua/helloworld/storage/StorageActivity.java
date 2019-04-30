package com.hua.helloworld.storage;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hua.helloworld.R;

public class StorageActivity extends AppCompatActivity {

    private EditText editText;
    private TextView tv;
    private Button save, display;

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage);
        editText = findViewById(R.id.et);
        tv = findViewById(R.id.tv);
        save = findViewById(R.id.save);
        display = findViewById(R.id.display);
        sharedPreferences = getSharedPreferences("data", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editor.putString("content", editText.getText().toString());
                editor.apply();
            }
        });

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText(sharedPreferences.getString("content", ""));
            }
        });
    }
}
