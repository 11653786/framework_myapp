package com.yt.android.activity.school;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.yt.android.R;
import com.yt.android.activity.detail.DetailActivity;
import com.yt.android.adapter.ListViewAdapter;
import com.yt.android.base.BaseActivity;
import com.yt.android.entity.Attachment;
import com.yt.android.help.DataBaseHelper;
import com.yt.android.listview.RefreshListView;
import com.yt.android.task.RefreshAsyncTask;
import com.yt.android.util.IntentUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * 校园风采
 *
 * @author zhangsan
 * @version 1.0
 * @package com.yt.android.activity.school
 * @date 2016/4/12 0012 13:23
 * @descption: 疯狂的王麻子团队!
 */
public class SchoolActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener, RefreshListView.OnRefreshListener {

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
        SchoolAsyncTask schoolAsyncTask = new SchoolAsyncTask();
        schoolAsyncTask.execute("");
    }

    public void initView() {
        listview = (RefreshListView) findViewById(R.id.listview);
        returnbutton = (Button) findViewById(R.id.returnbutton);
        title = (TextView) findViewById(R.id.title);
        title.setText("校园风采");
        returnbutton.setOnClickListener(this);
        listview.setOnItemClickListener(this);
        listview.setonRefreshListener(this);
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
    public void onItemClick(AdapterView<?> parent, View currentitem, int i, long l) {
        TextView id = (TextView) currentitem.findViewById(R.id.id);
        IntentUtil.clickButtonActivity(this, DetailActivity.class, "id", id.getText().toString(), "actions", "新闻");
    }

    /**
     * 下拉刷新的恢复
     */
    @Override
    public void onRefresh() {
        RefreshAsyncTask asyncTask = new RefreshAsyncTask(adapter, listview, getApplicationContext());
        asyncTask.execute(null, null, null);
    }

    private class SchoolAsyncTask extends AsyncTask<String, Integer, List<Attachment>> {

        @Override
        protected List<Attachment> doInBackground(String... strings) {
            initView();
            //获取游标
            return DataBaseHelper.getAttachmentList(DataBaseHelper.getCursor(getApplicationContext(), DataBaseHelper.getListByType, "3"));
        }


        @Override
        protected void onPostExecute(List<Attachment> attachments) {
            super.onPostExecute(attachments);
            adapter = new ListViewAdapter(getApplicationContext(), attachments);
            listview.setAdapter(adapter);
        }
    }
}
