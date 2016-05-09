package com.yt.android.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;
import com.yt.android.R;
import com.yt.android.activity.calculator.CalculatorActivity;
import com.yt.android.activity.calender.CalenderActivity;
import com.yt.android.activity.map.MapActivity;
import com.yt.android.activity.weather.WeatherActivity;
import com.yt.android.util.IntentUtil;

/**
 * 应用
 *
 * @author zhangsan
 * @version 1.0
 * @package com.yt.android.fragment
 * @date 2016/4/8 0008 18:18
 * @descption: 疯狂的王麻子团队!
 */
public class ApplicationFragment extends Fragment implements View.OnClickListener {

    ImageView jisuanqibutton, mapbutton, weather, calendar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_application, container, false);
        initView(view);
        return view;
    }

    /**
     * 初始化地图和计算器的按钮
     *
     * @param view
     */
    public void initView(View view) {
        jisuanqibutton = (ImageView) view.findViewById(R.id.jisuanqibutton);
        mapbutton = (ImageView) view.findViewById(R.id.mapbutton);
        calendar = (ImageView) view.findViewById(R.id.calendar);
        weather = (ImageView) view.findViewById(R.id.weather);
        mapbutton.setOnClickListener(this);
        jisuanqibutton.setOnClickListener(this);
        calendar.setOnClickListener(this);
        weather.setOnClickListener(this);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    /**
     * 跳转地图和计算器
     *
     * @param view
     */
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.jisuanqibutton:
                IntentUtil.clickButtonActivity(view.getContext(), CalculatorActivity.class);
                break;
            case R.id.mapbutton:
                IntentUtil.clickButtonActivity(view.getContext(), MapActivity.class);
                break;
            case R.id.weather:
                IntentUtil.clickButtonActivity(view.getContext(), WeatherActivity.class);
                break;
            case R.id.calendar:
                IntentUtil.clickButtonActivity(view.getContext(), CalenderActivity.class);
                break;
        }

    }
}
