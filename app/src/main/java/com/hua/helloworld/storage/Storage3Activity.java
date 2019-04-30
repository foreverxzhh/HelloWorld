package com.hua.helloworld.storage;

import android.os.Bundle;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.hua.helloworld.R;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Storage3Activity extends AppCompatActivity {

    private EditText editText;
    private TextView tv;
    private Button save, display;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_storage3);
        editText = findViewById(R.id.et);
        tv = findViewById(R.id.tv);
        save = findViewById(R.id.save);
        display = findViewById(R.id.display);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FileOutputStream fileOutputStream = null;
                try {
                    File dir = new File(Environment.getExternalStorageDirectory(), "hua");
                    if (!dir.exists()) {
                        dir.mkdirs();
                    }
                    File file = new File(dir, "child.txt");
                    if (!file.exists()) {
                        file.createNewFile();
                    }
                    fileOutputStream = new FileOutputStream(file);
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
                    File file = new File(Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "hua", "child.txt");
                    fileInputStream = new FileInputStream(file);
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
