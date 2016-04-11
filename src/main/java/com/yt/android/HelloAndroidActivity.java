package com.yt.android;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.yt.android.adapter.FragmentAdapter;
import com.yt.android.fragment.HomeFragment;
import com.yt.android.fragment.MyFragment2;

import java.util.ArrayList;
import java.util.List;

/**
 * 第一个activity
 */
public class HelloAndroidActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener {

    private ViewPager viewpager;
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
        List<Fragment> fragments = getFragments();
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        viewpager.setAdapter(adapter);
        radioGroup.setOnCheckedChangeListener(this);
        viewpager.setCurrentItem(0);
    }


    private List<Fragment> getFragments() {
        HomeFragment homeFragment = new HomeFragment();
        MyFragment2 fragment2 = new MyFragment2();
        List<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(homeFragment);
        fragments.add(fragment2);
        return fragments;
    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.tabHome:
                tabHome.setChecked(true);
                tabMap.setChecked(false);
                tabMy.setChecked(false);
                viewpager.setCurrentItem(0);
                break;
            case R.id.tabMap:
                tabHome.setChecked(false);
                tabMap.setChecked(true);
                tabMy.setChecked(false);
                viewpager.setCurrentItem(1);
                break;
            case R.id.tabMy:
                tabHome.setChecked(false);
                tabMap.setChecked(false);
                tabMy.setChecked(true);
                viewpager.setCurrentItem(2);
                break;
        }
    }
}


