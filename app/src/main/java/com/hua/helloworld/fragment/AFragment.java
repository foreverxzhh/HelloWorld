package com.hua.helloworld.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.hua.helloworld.R;

public class AFragment extends Fragment {

    TextView tv;
    Button test1,test2,test3;
    BFragment bFragment;
    ICommunity iC;

    public static AFragment getInstance(String string)
    {
        AFragment aFragment = new AFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title",string);
        aFragment.setArguments(bundle);
        return aFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        iC = (ContainerActivity)context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_a,null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv = view.findViewById(R.id.tv);
        if(getArguments() != null)
            tv.setText(getArguments().getString("title"));
        test1 = view.findViewById(R.id.test);
        test2 = view.findViewById(R.id.test2);
        test3 = view.findViewById(R.id.test3);
        test1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(bFragment == null)
                    bFragment = BFragment.getInstance("测试BFragment");
                Fragment fa = getFragmentManager().findFragmentByTag("a");//或者AFragment.this
                getFragmentManager().beginTransaction().hide(fa).addToBackStack(null).add(R.id.container,bFragment).commitAllowingStateLoss();
            }
        });
        test2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("变变变");
            }
        });
        test3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                iC.setButtonText("CQCQ");
            }
        });
    }

    public interface ICommunity
    {
        void setButtonText(String string);
    }
}
