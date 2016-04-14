package com.yt.android;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import com.baidu.mapapi.SDKInitializer;
import com.yt.android.adapter.FragmentAdapter;
import com.yt.android.adapter.ViewPagerAdapter;
import com.yt.android.contains.Contains;
import com.yt.android.fragment.ApplicationFragment;
import com.yt.android.fragment.HomeFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 第一个activity
 */
public class HelloAndroidActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener, View.OnTouchListener {

    private static final String LTAG = HelloAndroidActivity.class.getSimpleName();
    //中间的5个按钮
    private ViewPager viewpager;
    //我的,地图,首页
    private RadioGroup radioGroup;
    private RadioButton tabHome, tabMap, tabMy;
    //轮播图pageView
    private ViewPager lunbo = null;
    private AtomicInteger what1 = new AtomicInteger(0);
    private boolean isContinue1 = true;

    //校园空按钮
    private ImageView[] radioButtons = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        requestWindowFeature(Window.FEATURE_NO_TITLE);// 填充标题栏
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

    }

    private void initView() {
        //百度地图的初始化
        initMap();
        //轮播图
        initLunbo();
        viewpager = (ViewPager) findViewById(R.id.tabHost);
        //底部导航菜单
        radioGroup = (RadioGroup) findViewById(R.id.radiogroup);
        tabHome = (RadioButton) findViewById(R.id.tabHome);
        tabMap = (RadioButton) findViewById(R.id.tabMap);
        tabMy = (RadioButton) findViewById(R.id.tabMy);
        List<Fragment> fragments = getFragments();
        //fragmentAdapter初始化
        FragmentAdapter adapter = new FragmentAdapter(getSupportFragmentManager(), fragments);
        viewpager.setAdapter(adapter);
        radioGroup.setOnCheckedChangeListener(this);
        viewpager.setCurrentItem(0);
    }


    /**
     * 获取要展示的Fragment
     *
     * @return
     */
    private List<Fragment> getFragments() {
        //首页
        HomeFragment homeFragment = new HomeFragment();
        //应用
        ApplicationFragment applicationFragment = new ApplicationFragment();
        List<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(homeFragment);
        fragments.add(applicationFragment);
        return fragments;
    }


    /**
     * 底部导航菜单变更方法
     *
     * @param radioGroup
     * @param i
     */
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

    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
            case MotionEvent.ACTION_MOVE:
                isContinue1 = false;
                break;
            case MotionEvent.ACTION_UP:
                isContinue1 = true;
                break;
            default:
                isContinue1 = true;
                break;
        }
        return false;
    }


    ;


    /**
     * 百度地图相关的东西
     * 构造广播监听类，监听 SDK key 验证以及网络异常广播
     */
    public class SDKReceiver extends BroadcastReceiver {
        public void onReceive(Context context, Intent intent) {
            String s = intent.getAction();
            Log.d(LTAG, "action: " + s);
            if (s.equals(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR)) {
                Toast.makeText(getApplicationContext(), "key wrong!", Toast.LENGTH_LONG).show();
            } else if (s
                    .equals(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_OK)) {
                Toast.makeText(getApplicationContext(), "key right!", Toast.LENGTH_LONG).show();
            } else if (s
                    .equals(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR)) {
                Toast.makeText(getApplicationContext(), "net wrong!", Toast.LENGTH_LONG).show();
            }
        }
    }

    private SDKReceiver mReceiver;


    public void initMap() {
        // 注册 SDK 广播监听者
        IntentFilter iFilter = new IntentFilter();
        iFilter.addAction(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_OK);
        iFilter.addAction(SDKInitializer.SDK_BROADTCAST_ACTION_STRING_PERMISSION_CHECK_ERROR);
        iFilter.addAction(SDKInitializer.SDK_BROADCAST_ACTION_STRING_NETWORK_ERROR);
        mReceiver = new SDKReceiver();
        registerReceiver(mReceiver, iFilter);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        // 取消监听 SDK 广播
        unregisterReceiver(mReceiver);
    }

    /**
     * 初始化轮播图
     */
    private void initLunbo() {
        lunbo = (ViewPager) findViewById(R.id.adv_pager);
        ViewGroup group = (ViewGroup) findViewById(R.id.viewGroup);
        //轮播图
        List<ImageView> advPics = Contains.setImageViews(this);
        //添加小圆孔
        radioButtons = Contains.addRadioButton(advPics, this, group);
        lunbo.setAdapter(new ViewPagerAdapter(advPics));
        lunbo.setOnPageChangeListener(new GuidePageChangeListener());
        lunbo.setOnTouchListener(this);
        //开始轮播
        new Thread(new picThread()).start();
    }


    private class picThread implements Runnable {
        @Override
        public void run() {
            while (true) {
                if (isContinue1) {
                    viewHandler.sendEmptyMessage(what1.get());
                    whatOption();
                }
            }
        }
    }


    private void whatOption() {
        what1.incrementAndGet();
        if (what1.get() > radioButtons.length - 1) {
            what1.getAndAdd(-4);
        }
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {

        }
    }

    private final Handler viewHandler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            lunbo.setCurrentItem(msg.what);
            super.handleMessage(msg);
        }
    };

    private final class GuidePageChangeListener implements ViewPager.OnPageChangeListener {

        @Override
        public void onPageScrollStateChanged(int arg0) {

        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2) {

        }

        @Override
        public void onPageSelected(int arg0) {
            what1.getAndSet(arg0);
            for (int i = 0; i < radioButtons.length; i++) {
                radioButtons[arg0]
                        .setBackgroundResource(R.drawable.banner_dian_focus);
                if (arg0 != i) {
                    radioButtons[i]
                            .setBackgroundResource(R.drawable.banner_dian_blur);
                }
            }
        }

    }

}


