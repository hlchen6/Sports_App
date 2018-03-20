package com.example.hlchen.sports_app.Fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hlchen.sports_app.R;

import static com.example.hlchen.sports_app.R.layout.fra;

/**
 * Created by Hlchen on 2018/3/6.
 */

public class BaseFragment extends Fragment {
    TextView textView ;
    String ms;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(fra, container, false);
        textView = (TextView)view.findViewById(R.id.text1);
        textView.setText(ms);
        return view;
    }
    public void setTextView(String st){
        ms = st;
    }


}
