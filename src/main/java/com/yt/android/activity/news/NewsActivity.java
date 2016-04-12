package com.yt.android.activity.news;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import com.yt.android.R;
import com.yt.android.adapter.ListViewAdapter;
import com.yt.android.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * 新闻
 *
 * @author zhangsan
 * @version 1.0
 * @package com.yt.android.activity.calculator
 * @date 2016/4/12 0012 12:34
 * @descption: 疯狂的王麻子团队!
 */
public class NewsActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener {

    private Button returnbutton;
    //数据表格
    private ListView listview;
    //title设置
    private TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        initView();
        ListViewAdapter adapter = new ListViewAdapter(getApplicationContext(), list());
        listview.setAdapter(adapter);
    }


    public void initView() {
        listview = (ListView) findViewById(R.id.listview);
        returnbutton = (Button) findViewById(R.id.returnbutton);
        title = (TextView) findViewById(R.id.title);
        returnbutton.setOnClickListener(this);
    }

    public List<String> list() {
        List<String> list = new ArrayList<String>();
        list.add("hehe");
        list.add("hehe");
        list.add("hehe");
        list.add("hehe");
        list.add("hehe");
        return list;
    }


    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.returnbutton) {
            this.finish();
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
    }
}
