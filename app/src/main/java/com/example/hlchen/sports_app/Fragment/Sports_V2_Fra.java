package com.example.hlchen.sports_app.Fragment;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.hlchen.sports_app.Adapter.Game_Data_Rec_Adapter;
import com.example.hlchen.sports_app.Adapter.Tyq_rec_Adapter;
import com.example.hlchen.sports_app.Class.Game_Data_Class;
import com.example.hlchen.sports_app.Manage.ScrollLinearLayoutManager;
import com.example.hlchen.sports_app.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hlchen on 2018/3/15.
 */

public class Sports_V2_Fra extends Fragment {
    public SwipeRefreshLayout swipeRefreshLayout;
    private List<Game_Data_Class> mlist = new ArrayList<>();
    RecyclerView Game_Data_recyclerView;
    Game_Data_Rec_Adapter Game_Data_adapter;
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sports_v2, container, false);
        Game_Data_recyclerView = (RecyclerView)view.findViewById(R.id.Sp_V2_Game_Rec);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        Game_Init();
        ScrollLinearLayoutManager scrollLinearLayoutManager = new ScrollLinearLayoutManager(getContext());
        scrollLinearLayoutManager.setScrollEnabled(false);
        Game_Data_recyclerView.setLayoutManager(scrollLinearLayoutManager);
        Game_Data_recyclerView.setNestedScrollingEnabled(false);
        Game_Data_adapter = new Game_Data_Rec_Adapter(mlist);
        Game_Data_recyclerView.setAdapter(Game_Data_adapter);
        super.onActivityCreated(savedInstanceState);
    }
    public void Game_Init(){
        if(mlist.size()!=0){
            mlist.clear();
        }
        Resources res = getResources();
        Bitmap bmp = BitmapFactory.decodeResource(res, R.drawable.user_ui);
        mlist.add(new Game_Data_Class(bmp,"牛逼战队","3-15","农大"));
        mlist.add(new Game_Data_Class(bmp,"牛逼战队","3-15","农大"));
    }
}
