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
import com.yt.android.entity.Attachment;

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
    private List<Attachment> list;

    public ListViewAdapter(Context context, List<Attachment> list) {
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
            Attachment attachment = list.get(position);
            convertView = mInflater.inflate(R.layout.item_news, null);
            holder = new ViewHolder();
            holder.title = (TextView) convertView.findViewById(R.id.title);
            holder.image = (ImageView) convertView.findViewById(R.id.image);
            holder.desc = (TextView) convertView.findViewById(R.id.desc);
            setView(attachment, holder.title, holder.image, holder.desc);
        }
        return convertView;
    }


    private void setView(Attachment attachment, TextView title, ImageView image, TextView desc) {
        if (attachment.getTitle() != null) {
            title.setText(attachment.getTitle());
        }

        if (attachment.getImage() != 0) {
            image.setBackgroundResource(attachment.getImage());
        }

        if (attachment.getContent() != null) {
            desc.setText(attachment.getContent());
        }
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
