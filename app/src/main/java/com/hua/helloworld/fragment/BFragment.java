package com.hua.helloworld.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.hua.helloworld.R;

public class BFragment extends Fragment {

    TextView tv;

    public static BFragment getInstance(String string) {
        BFragment bFragment = new BFragment();
        Bundle bundle = new Bundle();
        bundle.putString("title", string);
        bFragment.setArguments(bundle);
        return bFragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_b, null);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        tv = view.findViewById(R.id.tv);
        if (getArguments() != null)
            tv.setText(getArguments().getString("title"));
    }
}
