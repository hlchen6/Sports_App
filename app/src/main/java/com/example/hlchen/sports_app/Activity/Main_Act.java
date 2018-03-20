package com.example.hlchen.sports_app.Activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.ashokvarma.bottomnavigation.BottomNavigationBar;
import com.ashokvarma.bottomnavigation.BottomNavigationItem;
import com.example.hlchen.sports_app.Adapter.SectionsPagerAdapter;
import com.example.hlchen.sports_app.Fragment.BaseFragment;
import com.example.hlchen.sports_app.Fragment.Sports_V1_Fra;
import com.example.hlchen.sports_app.Fragment.Sports_V2_Fra;
import com.example.hlchen.sports_app.R;


import java.util.ArrayList;
import java.util.List;

public class Main_Act extends AppCompatActivity implements BottomNavigationBar
        .OnTabSelectedListener, ViewPager.OnPageChangeListener {

    private ViewPager viewPager;
    private BottomNavigationBar bottomNavigationBar;
    private List<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_);

        initView();
    }

    private void initView() {
        initBottomNavigationBar();
        initViewPager();
    }

    private void initBottomNavigationBar() {
        bottomNavigationBar = (BottomNavigationBar) findViewById(R.id.bottom_navigation_bar);
        bottomNavigationBar.setTabSelectedListener(this);
        bottomNavigationBar.clearAll();
        bottomNavigationBar.setMode(BottomNavigationBar.MODE_FIXED);
        bottomNavigationBar.setBackgroundStyle(BottomNavigationBar.BACKGROUND_STYLE_STATIC);
        bottomNavigationBar
                .addItem(new BottomNavigationItem(R.drawable.zhuye,"1")
                        .setInactiveIconResource(R.drawable.zhuye)
                        .setActiveColorResource(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.drawable.zhuye,"1")
                        .setInactiveIconResource(R.drawable.zhuye)
                        .setActiveColorResource(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.drawable.zhuye,"1")
                        .setInactiveIconResource(R.drawable.zhuye)
                        .setActiveColorResource(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.drawable.zhuye,"1")
                        .setInactiveIconResource(R.drawable.zhuye)
                        .setActiveColorResource(R.color.colorAccent))
                .addItem(new BottomNavigationItem(R.drawable.zhuye,"1")
                        .setInactiveIconResource(R.drawable.zhuye)
                        .setActiveColorResource(R.color.colorAccent))
                .initialise();
    }

    private void initViewPager() {
        viewPager = (ViewPager) findViewById(R.id.view_pager);

        fragments = new ArrayList<Fragment>();

        Sports_V1_Fra b1 = new Sports_V1_Fra();
        Sports_V2_Fra b2 = new Sports_V2_Fra();

        BaseFragment b3 = new BaseFragment();
        b3.setTextView("3");
        BaseFragment b4 = new BaseFragment();
        b4.setTextView("4");
        fragments.add(b1);
        fragments.add(b2);
        fragments.add(b3);
        fragments.add(b4);


//        fragments.add(new CatagoryFragment());
//        fragments.add(new DiscoverFragment());
//        fragments.add(new UserCentralFragment());

        viewPager.setAdapter(new SectionsPagerAdapter(getSupportFragmentManager(), fragments));
        viewPager.addOnPageChangeListener(this);
        viewPager.setCurrentItem(0);
    }

    @Override
    public void onTabSelected(int position) {
        viewPager.setCurrentItem(position);
    }

    @Override
    public void onTabUnselected(int position) {

    }

    @Override
    public void onTabReselected(int position) {

    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        bottomNavigationBar.selectTab(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}


