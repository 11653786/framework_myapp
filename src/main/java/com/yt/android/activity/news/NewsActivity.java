package com.yt.android.activity.news;

import android.database.Cursor;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.*;
import com.yt.android.R;
import com.yt.android.adapter.ListViewAdapter;
import com.yt.android.base.BaseActivity;
import com.yt.android.entity.Attachment;
import com.yt.android.help.DataBaseHelper;
import com.yt.android.listview.RefreshListView;
import com.yt.android.task.RefreshAsyncTask;

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
public class NewsActivity extends BaseActivity implements View.OnClickListener, AdapterView.OnItemClickListener, RefreshListView.OnRefreshListener {

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
        //使用异步加载android性能提升
        NewsAsyncTask task = new NewsAsyncTask();
        task.execute("");
    }


    public void initView() {
        listview = (RefreshListView) findViewById(R.id.listview);
        returnbutton = (Button) findViewById(R.id.returnbutton);
        title = (TextView) findViewById(R.id.title);
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
    public void onItemClick(AdapterView<?> parent, View view, int i, long l) {
        ListView itemListView = (ListView) parent;
        TextView title = (TextView) itemListView.findViewById(R.id.title);
        Toast.makeText(getApplicationContext(), title.getText(), Toast.LENGTH_LONG).show();
    }

    @Override
    public void onRefresh() {
        RefreshAsyncTask asyncTask = new RefreshAsyncTask(adapter, listview, getApplicationContext());
        asyncTask.execute(null, null, null);
    }

    /**
     * //AsyncTask<>的参数类型由用户设定，这里设为三个String
     * //第一个String代表输入到任务的参数类型，也即是doInBackground()的参数类型
     * //第二个String代表处理过程中的参数类型，也就是doInBackground()执行过程中的产出参数类型，通过publishProgress()发消息
     * //传递给onProgressUpdate()一般用来更新界面
     * //第三个String代表任务结束的产出类型，也就是doInBackground()的返回值类型，和onPostExecute()的参数类型
     */
    private class NewsAsyncTask extends AsyncTask<String, Integer, List<Attachment>> {

        @Override
        protected List<Attachment> doInBackground(String... strings) {
            initView();
            //获取游标
            return DataBaseHelper.getAttachmentList(DataBaseHelper.getCursor(getApplicationContext(), "1"));
        }


        @Override
        protected void onPostExecute(List<Attachment> attachments) {
            super.onPostExecute(attachments);
            adapter = new ListViewAdapter(getApplicationContext(), attachments);
            listview.setAdapter(adapter);
        }
    }

}
