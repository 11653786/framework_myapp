package com.yt.android;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.yt.android.adapter.FragmentAdapter;
import com.yt.android.adapter.ViewPagerAdapter;
import com.yt.android.contains.Contains;
import com.yt.android.fragment.HomeFragment;
import com.yt.android.fragment.MyFragment2;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 第一个activity
 */
public class HelloAndroidActivity extends FragmentActivity implements RadioGroup.OnCheckedChangeListener, View.OnTouchListener {


    //轮播图相关
    private ViewPager lunbo;
    private ArrayList<ImageView> imageViews;
    private int previousSelectPosition = 0;
    private boolean toRight = true;
    //是否向左开始自动播放
    private boolean toLeft = false;
    private int lunbopos = 0;
    //定时器控制自动轮播
    ImageTimer task = null;

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
     * 初始化轮播图方法
     */
    private void initLunbo() {
        lunbo = (ViewPager) findViewById(R.id.lunbotu);
        imageViews = Contains.setImageViews(getApplicationContext());
        lunbo.setAdapter(new ViewPagerAdapter(imageViews));
        lunbo.setOnTouchListener(this);
        // 自动切换页面功能
        task = new ImageTimer();
        timer.schedule(task, 1000, 2000); // 1s后执行task,经过1s再次执行
    }


    /**
     * 获取要展示的Fragment
     *
     * @return
     */
    private List<Fragment> getFragments() {
        HomeFragment homeFragment = new HomeFragment();
        MyFragment2 fragment2 = new MyFragment2();
        List<Fragment> fragments = new ArrayList<Fragment>();
        fragments.add(homeFragment);
        fragments.add(fragment2);
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


    /**
     * 点击屏幕轮播图暂停
     *
     * @param view
     * @param motionEvent
     * @return
     */
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        switch (motionEvent.getAction()) {
            case MotionEvent.ACTION_DOWN:
                task.setTrue(false);
                break;
            case MotionEvent.ACTION_UP:
                task.setTrue(true);
                break;
            case MotionEvent.ACTION_MOVE:
                task.setTrue(false);
                break;
            default:
                break;
        }
        return true;
    }


    //轮播图相关的定时器
    Handler handler = new Handler() {
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                //设置轮播图必须放在这里
                if (lunbo != null) {
                    lunbo.setCurrentItem(lunbopos);
                }
            }
        }

        ;
    };
    Timer timer = new Timer();


    class ImageTimer extends TimerTask {

        private boolean isTrue = true;

        @Override
        public void run() {
            //轮播
            lunbo(isTrue);
            //发送消息
            Message message = new Message();
            message.what = 1;
            handler.sendMessage(message);
        }

        public void setTrue(boolean isTrue) {
            this.isTrue = isTrue;
        }
    }

    ;

    /**
     * 轮播运转方法,根据状态来左右轮播
     */
    public void lunbo(boolean isTrue) {
        if (isTrue) {
            if (lunbopos <= 4) {
                if (lunbopos == 4) {
                    toRight = false;
                    toLeft = true;
                }
                if (lunbopos == 0) {
                    toRight = true;
                    toLeft = false;
                }

                if (toRight) {
                    lunbopos++;
                }
                if (toLeft) {
                    lunbopos--;
                }
            }
        }

    }


}


