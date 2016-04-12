package com.yt.android.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import com.yt.android.R;

import java.util.List;

/**
 * @author zhangsan
 * @version 1.0
 * @package com.yt.android.adapter
 * @date 2016/4/12 0012 11:23
 * @descption: 疯狂的王麻子团队!
 */
public class ListViewAdapter extends BaseAdapter {


    private Context activityContext;
    private List<String> list;

    public ListViewAdapter(Context context, List<String> list) {
        this.activityContext = context;
        this.list = list;

    }

    @Override
    public int getCount() {
        return this.list.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;
        if (null == convertView) {
            LayoutInflater inflater = ((Activity) activityContext).getLayoutInflater();
            convertView = inflater.inflate(R.layout.item_news, null);
            holder = new ViewHolder();
            ViewHolder.title = (TextView) convertView.findViewById(R.id.image);
            ViewHolder.image = (ImageView) convertView.findViewById(R.id.image);
            ViewHolder.desc = (TextView) convertView.findViewById(R.id.image);
        }
        return convertView;
    }


    static class ViewHolder {
        static TextView title;
        static ImageView image;
        static TextView desc;
    }
}
