package com.yt.android.fragment;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.yt.android.R;
import com.yt.android.adapter.ViewPagerAdapter;
import com.yt.android.contains.Contains;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 首页fragment
 *
 * @author zhangsan
 * @version 1.0
 * @package com.yt.android.fragment
 * @date 2016/4/8 0008 17:43
 * @descption: 疯狂的王麻子团队!
 */
public class HomeFragment extends Fragment implements View.OnTouchListener {


    private ViewPager viewpager;
    private ArrayList<ImageView> imageViews;
    private int previousSelectPosition = 0;
    private boolean toRight = true;
    //是否向左开始自动播放
    private boolean toLeft = false;
    private int lunbopos = 0;
    ImageTimer task = null;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 第一个参数是这个Fragment将要显示的界面布局,第二个参数是这个Fragment所属的Activity,第三个参数是决定此fragment是否附属于Activity
        View view = inflater.inflate(R.layout.activity_main, container, false);
        initView(view);
        viewpager.setAdapter(new ViewPagerAdapter(imageViews));
        viewpager.setOnTouchListener(this);
        // 自动切换页面功能
        task = new ImageTimer();
        timer.schedule(task, 1000, 2000); // 1s后执行task,经过1s再次执行
        return view;
    }

    private void initView(View view) {
        viewpager = (ViewPager) view.findViewById(R.id.viewPager);
        imageViews = Contains.setImageViews(getActivity().getApplicationContext());
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
                if (viewpager != null) {
                    viewpager.setCurrentItem(lunbopos);
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
     * 轮播运转方法
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
