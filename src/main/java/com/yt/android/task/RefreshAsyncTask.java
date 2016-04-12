package com.yt.android.task;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;
import com.yt.android.adapter.ListViewAdapter;
import com.yt.android.listview.RefreshListView;

/**
 * 专门用来刷新自定义listView的线程
 *
 * @author zhangsan
 * @version 1.0
 * @package com.yt.android.task
 * @date 2016/4/12 0012 13:49
 * @descption: 疯狂的王麻子团队!
 */
public class RefreshAsyncTask extends AsyncTask<Void, Void, Void> {


    private ListViewAdapter adapter;
    private RefreshListView refreshListView;
    private Context context;

    public RefreshAsyncTask(ListViewAdapter adapter, RefreshListView refreshListView, Context context) {
        this.adapter = adapter;
        this.refreshListView = refreshListView;
        this.context = context;
    }

    protected Void doInBackground(Void... params) {
        try {
            Thread.sleep(1000);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        adapter.notifyDataSetChanged();
        refreshListView.onRefreshComplete();
        Toast.makeText(context, "延迟1秒刷新数据!", Toast.LENGTH_SHORT).show();
    }
}


