package com.yt.android;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.yt.android.adapter.ViewPagerAdapter;
import com.yt.android.contains.Contains;

import java.util.ArrayList;

public class HelloAndroidActivity extends FragmentActivity {

    private ViewPager viewpager;
    private ArrayList<ImageView> imageViews;
    private int previousSelectPosition = 0;
    private boolean toRight = true;
    //是否向左开始自动播放
    private boolean toLeft = false;
    private int lunbopos = 0;
    //底部菜单
    //我的,地图,首页
    private RadioGroup radioGroup;
    private RadioButton tabHome, tabMap, tabMy;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);
        initView();
    }

    private void initView() {
        viewpager = (ViewPager) findViewById(R.id.tabHost);
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        tabHome = (RadioButton) findViewById(R.id.tabHome);
        tabMap = (RadioButton) findViewById(R.id.tabMap);
        tabMy = (RadioButton) findViewById(R.id.tabMy);
    }
}


