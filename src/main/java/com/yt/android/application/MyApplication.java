package com.yt.android.application;


import android.app.Application;
import com.baidu.mapapi.SDKInitializer;

/**
 * 百度地图初始化服务
 */
public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        // 在使用 SDK 各组间之前初始化 context 信息，传入 ApplicationContext
        SDKInitializer.initialize(this);
    }

}