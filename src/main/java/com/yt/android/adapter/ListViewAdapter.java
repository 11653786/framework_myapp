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
import com.yt.android.util.DateUtil;

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
            convertView = mInflater.inflate(R.layout.item_news, null);
        }
        Attachment attachment = list.get(position);

        holder = new ViewHolder();
        holder.id = (TextView) convertView.findViewById(R.id.id);
        holder.title = (TextView) convertView.findViewById(R.id.title);
        holder.image = (ImageView) convertView.findViewById(R.id.image);
        holder.desc = (TextView) convertView.findViewById(R.id.desc);
        holder.newstime = (TextView) convertView.findViewById(R.id.newstime);

        setView(attachment, holder.id, holder.title, holder.image, holder.desc, holder.newstime);

        return convertView;
    }


    private void setView(Attachment attachment, TextView id, TextView title, ImageView image, TextView desc, TextView newTime) {
        id.setText(String.valueOf(attachment.getId()));
        if (attachment.getTitle() != null) {
            title.setText(attachment.getTitle());
        }

        if (attachment.getImage() != 0) {
            image.setBackgroundResource(attachment.getImage());
        }

        if (attachment.getContent() != null) {
            desc.setText(attachment.getContent());
        }

        if (attachment.getCreateDate() != null) {
            newTime.setText(DateUtil.DateFormatter(attachment.getCreateDate(), DateUtil.formatter));
        }

    }

    /**
     * viewHolder,listView的性能优化
     */
    static class ViewHolder {
        TextView id;        //id
        TextView title;     //标题
        ImageView image;    //图片
        TextView desc;      //内容
        TextView newstime;  //创建时间
    }
}
