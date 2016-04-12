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


    private LayoutInflater mInflater = null;
    private List<String> list;

    public ListViewAdapter(Context context, List<String> list) {
        this.list = list;
        this.mInflater = LayoutInflater.from(context);

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
            convertView = mInflater.inflate(R.layout.item_news, null);
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.image = (ImageView) convertView.findViewById(R.id.image);
            holder.desc = (TextView) convertView.findViewById(R.id.desc);
        }
        return convertView;
    }

    /**
     * viewHolder,listView的性能优化
     */
    static class ViewHolder {
        TextView title;
        ImageView image;
        TextView desc;
    }
}
