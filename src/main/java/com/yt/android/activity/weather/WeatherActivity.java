package com.yt.android.activity.weather;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import com.yt.android.R;
import com.yt.android.base.BaseActivity;
import com.yt.android.util.HttpUtil;
import com.yt.android.util.HttpUtils;

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

    TextView aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        initView();
        WeatherAsyncTask weatherAsyncTask = new WeatherAsyncTask();
        weatherAsyncTask.execute(weatherUrL, "", HttpUtil.CONTENT_TYPE_HTML);
    }


    public void initView() {
        aa = (TextView) findViewById(R.id.aa);
    }


    private class WeatherAsyncTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... strings) {
            return HttpUtils.doGet(weatherUrL);
        }

        @Override
        protected void onPostExecute(String s) {
            aa.setText(s);
            super.onPostExecute(s);
        }
    }
}
