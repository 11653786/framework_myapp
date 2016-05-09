package com.yt.android.activity.weather;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.TextView;
import com.google.gson.Gson;
import com.yt.android.R;
import com.yt.android.base.BaseActivity;
import com.yt.android.entity.WeatherInfo;
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
    //这个不显示最高和最低温度
    // /http://www.weather.com.cn/data/sk/101020100.html
    //获取天气的url,这个url显示最高和最低问题的
    private String weatherUrL = "http://www.weather.com.cn/data/cityinfo/" + shanghaiCode + ".html";

    TextView aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather);
        initView();
        WeatherAsyncTask weatherAsyncTask = new WeatherAsyncTask();
        weatherAsyncTask.execute("");
    }


    public void initView() {
        aa = (TextView) findViewById(R.id.aa);
    }

    /**
     * 调用天气接口
     */
    private class WeatherAsyncTask extends AsyncTask<String, String, String> {
        @Override
        protected String doInBackground(String... params) {
            return HttpUtils.doGet(weatherUrL);
        }

        @Override
        protected void onPostExecute(String result) {
            super.onPostExecute(result);
            if (result != null && !result.equals("")) {
                //转json
                Gson gson = new Gson();
                WeatherInfo weatherInfo = gson.fromJson(result, WeatherInfo.class);
                aa.setText(result);
            }

        }
    }
}
