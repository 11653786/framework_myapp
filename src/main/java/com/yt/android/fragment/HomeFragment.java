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
public class HomeFragment extends Fragment {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // 第一个参数是这个Fragment将要显示的界面布局,第二个参数是这个Fragment所属的Activity,第三个参数是决定此fragment是否附属于Activity
        View view = inflater.inflate(R.layout.activity_main, container, false);
        // initLunbo(view);
        return view;
    }


}
