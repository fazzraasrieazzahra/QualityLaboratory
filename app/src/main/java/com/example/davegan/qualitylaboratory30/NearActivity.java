package com.example.davegan.qualitylaboratory30;


import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.davegan.qualitylaboratory30.Tab.MyAdapter;
import com.example.davegan.qualitylaboratory30.Tab.SlidingTabLayout;

public class NearActivity extends AppCompatActivity {

    private SlidingTabLayout mSlidingTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_near);

        mViewPager=(ViewPager)findViewById(R.id.vp_tab);
        mViewPager.setAdapter(new MyAdapter(getSupportFragmentManager(),this));

        mSlidingTabLayout=(SlidingTabLayout)findViewById(R.id.stl_tabs);
        mSlidingTabLayout.setDistributeEvenly(true);
        mSlidingTabLayout.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
        mSlidingTabLayout.setSelectedIndicatorColors(getResources().getColor(R.color.colorAccent));
        mSlidingTabLayout.setCustomTabView(R.layout.tab_view,R.id.tv_tab);
        mSlidingTabLayout.setViewPager(mViewPager);


    }
}
