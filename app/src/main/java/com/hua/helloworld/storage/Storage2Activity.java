package com.hua.helloworld.storage;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hua.helloworld.R;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Storage2Activity extends AppCompatActivity {

    private EditText editText;
    private TextView tv;
    private Button save, display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage2);
        editText = findViewById(R.id.et);
        tv = findViewById(R.id.tv);
        save = findViewById(R.id.save);
        display = findViewById(R.id.display);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fileOutputStream = null;
                try {
                    fileOutputStream = openFileOutput("test", MODE_PRIVATE);
                    fileOutputStream.write(editText.getText().toString().getBytes());
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        fileOutputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        });

        display.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileInputStream fileInputStream = null;
                String string = null;
                try {
                    fileInputStream = openFileInput("test");
                    byte[] buffer = new byte[1024];
                    StringBuffer stringBuffer = new StringBuffer("");
                    while (fileInputStream.read(buffer) > 0) {
                        stringBuffer.append(new String(buffer));
                    }
                    string = stringBuffer.toString().trim();
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        fileInputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                tv.setText(string);
            }
        });
    }
}
