package com.yt.android.activity.subject;

import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.yt.android.R;
import com.yt.android.adapter.ListViewAdapter;
import com.yt.android.base.BaseActivity;
import com.yt.android.listview.RefreshListView;
import com.yt.android.task.RefreshAsyncTask;

import java.util.ArrayList;
import java.util.List;

/**
 * 特色专业
 *
 * @author zhangsan
 * @version 1.0
 * @package com.yt.android.activity.subject
 * @date 2016/4/12 0012 14:03
 * @descption: 疯狂的王麻子团队!
 */
public class SubjectActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener, RefreshListView.OnRefreshListener {


    private Button returnbutton;
    //数据表格
    private RefreshListView listview;
    //title设置
    private TextView title;
    ListViewAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        initView();
        adapter = new ListViewAdapter(getApplicationContext(), list());
        listview.setAdapter(adapter);
    }

    public void initView() {
        listview = (RefreshListView) findViewById(R.id.listview);
        returnbutton = (Button) findViewById(R.id.returnbutton);
        title = (TextView) findViewById(R.id.title);
        title.setText("特色专业");
        returnbutton.setOnClickListener(this);
        listview.setOnItemClickListener(this);
        listview.setonRefreshListener(this);
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

    /**
     * listView滑动事件
     *
     * @param parent
     * @param view
     * @param i
     * @param l
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        ListView itemListView = (ListView) parent;
        TextView title = (TextView) itemListView.findViewById(R.id.title);
        Toast.makeText(getApplicationContext(), title.getText(), Toast.LENGTH_LONG).show();
    }

    /**
     * 下拉刷新的恢复
     */
    @Override
    public void onRefresh() {
        RefreshAsyncTask asyncTask = new RefreshAsyncTask(adapter, listview, getApplicationContext());
        asyncTask.execute(null, null, null);
    }
}