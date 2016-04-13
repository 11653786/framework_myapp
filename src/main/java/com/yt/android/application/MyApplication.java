package com.yt.android.application;


import android.app.Application;
import com.baidu.mapapi.SDKInitializer;
import com.iflytek.cloud.SpeechUtility;
import com.yt.android.R;

/**
 * 百度地图，科大讯飞初始化服务
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        //科大讯飞
        SpeechUtility.createUtility(MyApplication.this, "appid=" + getString(R.string.app_id));
        super.onCreate();
        // 在使用 SDK 各组间之前初始化 context 信息，传入 ApplicationContext
        SDKInitializer.initialize(this);
    }

}