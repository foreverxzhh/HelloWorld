package com.hua.helloworld.fragment;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.hua.helloworld.R;

public class ContainerActivity extends AppCompatActivity implements AFragment.ICommunity {

    AFragment fa;
    BFragment fb;
    Button btn;
    int count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_container);
        count = 0;
        btn = findViewById(R.id.Button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count++;
                if(count%2 == 0)
                {
                    getFragmentManager().beginTransaction().replace(R.id.container,fa).commitAllowingStateLoss();
                }
                else
                {
                    if(fb == null)
                        fb = BFragment.getInstance("测试B");
                    getFragmentManager().beginTransaction().replace(R.id.container,fb).commitAllowingStateLoss();
                }
            }
        });
        fa = AFragment.getInstance("测试A");
        getFragmentManager().beginTransaction().add(R.id.container,fa, "a").commitAllowingStateLoss();
    }

    @Override
    public void setButtonText(String string) {
        btn.setText(string);
    }
}
