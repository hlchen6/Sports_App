package com.example.hlchen.sports_app.Fragment;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.hlchen.sports_app.Adapter.Tyq_rec_Adapter;
import com.example.hlchen.sports_app.Class.Tyq_Class;
import com.example.hlchen.sports_app.Manage.ScrollLinearLayoutManager;
import com.example.hlchen.sports_app.R;

import java.util.ArrayList;
import java.util.List;

import static com.example.hlchen.sports_app.R.layout.fra;

/**
 * Created by Hlchen on 2018/3/7.
 */

public class Sports_V1_Fra extends Fragment {
    private ViewPager Top_VP;
    private List<View> viewList;
    private RecyclerView recyclerView;
    private Tyq_rec_Adapter Tyq_Adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private List<Tyq_Class> mlist = new ArrayList<>();
    public final static int REFRE = 2;
    private Handler handler = new Handler(){
        public void handleMessage(Message msg){
            switch(msg.what){
                case 1:
                 //   parseJSON((String)msg.obj);
                    //respon_txt.setText((String)msg.obj);
                    break;
                case REFRE:{
                    Init_Rec_List();
                    swipeRefreshLayout.setRefreshing(false);

                    break;
                }
                default:break;

            }
        }
    };
    @Nullable
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.sports_v1, container, false);
        Top_VP = (ViewPager)view.findViewById(R.id.V1_Top_VP);
        recyclerView = (RecyclerView) view.findViewById(R.id.Tyq_Rec);
        swipeRefreshLayout= (SwipeRefreshLayout)view.findViewById(R.id.Main_Refer);
        swipeRefreshLayout.setColorSchemeResources(R.color.colorPrimary);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener(){
            @Override
            public void onRefresh() {
                refer();
            }
        });
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        viewList = new ArrayList<View>();
        initViewPager();
        Init_Rec_List();
        ScrollLinearLayoutManager scrollLinearLayoutManager = new ScrollLinearLayoutManager(getContext());//重写LinerlayoutManager 解决scroll冲突
        scrollLinearLayoutManager.setScrollEnabled(false);
        recyclerView.setLayoutManager(scrollLinearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
        Tyq_Adapter = new Tyq_rec_Adapter(mlist);
        recyclerView.setAdapter(Tyq_Adapter);
        super.onActivityCreated(savedInstanceState);
    }

    public void initViewPager(){

        ImageView img0 = new ImageView(getContext());
        img0.setImageResource(R.drawable.test);
        viewList.add(img0);
        ImageView img1 = new ImageView(getContext());
        img1.setImageResource(R.drawable.test);
        viewList.add(img1);
        ImageView img2 = new ImageView(getContext());
        img2.setImageResource(R.drawable.test);
        viewList.add(img2);
        ImageView img3 = new ImageView(getContext());
        img3.setImageResource(R.drawable.test);
        viewList.add(img3);
//        ImageView img1 = new ImageView(this);
//        img1.setImageResource(R.drawable.p1);
//        viewList.add(img1);
        Top_VP.setAdapter(new MyPagerAdapter());
        //监听ViewPager滑动效果
        Top_VP.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            //页卡被选中的方法
            @Override
            public void onPageSelected(int arg0) {
                //如果是第三个页面
            }
            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
            }
        });
    }
    class MyPagerAdapter extends PagerAdapter {
        @Override
        public int getCount() {
            return viewList.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        //初始化item实例方法
        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(viewList.get(position));
            return viewList.get(position);
        }

        //item销毁的方法
        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            // 注销父类销毁item的方法，因为此方法并不是使用此方法
//          super.destroyItem(container, position, object);
            container.removeView(viewList.get(position));
        }
    }
    private void Init_Rec_List(){
        if(mlist.size()!=0){
            mlist.clear();
        }
        Resources res = getResources();
        Bitmap bmp = BitmapFactory.decodeResource(res, R.drawable.user_ui);
        mlist.add(new Tyq_Class(bmp,"用户",bmp,"test","3-15"));
        mlist.add(new Tyq_Class(bmp,"用户",bmp,"test","3-15"));
    }
    public void refer(){

        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(1000);
                    Message msg = new Message();
                    msg.what=REFRE;
                    handler.sendMessage(msg);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }



            }
        }).start();
    }
}
