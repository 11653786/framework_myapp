package com.yt.android.activity.weather;

import android.os.AsyncTask;
import android.os.Bundle;
import com.yt.android.R;
import com.yt.android.base.BaseActivity;
import com.yt.android.util.HttpUtil;

/**
 * 天气activity
 *
 * @author zhangsan
 * @version 1.0
 * @package com.yt.android.activity.weather
 * @date 2016/5/9 0009 15:24
 * @descption: 疯狂的王麻子团队!
 */
public class WeatherActivity extends BaseActivity {

    //上海的天气查询code
    private String shanghaiCode = "101020100";
    //获取天气的url
    private String weatherUrL = "http://www.weather.com.cn/data/sk/" + shanghaiCode + ".html";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        WeatherAsyncTask weatherAsyncTask = new WeatherAsyncTask();
        weatherAsyncTask.execute(weatherUrL, "", HttpUtil.CONTENT_TYPE_HTML);
    }

    private class WeatherAsyncTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            String postUrl = strings[0];
            String jsonStr = strings[1];
            String contentType = strings[2];
            return HttpUtil.SendRequest(postUrl, jsonStr, contentType);
        }

        @Override
        protected void onPostExecute(String s) {
            System.out.println(s);
            super.onPostExecute(s);
        }
    }
}
