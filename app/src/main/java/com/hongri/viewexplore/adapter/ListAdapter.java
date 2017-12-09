package com.hongri.viewexplore.adapter;

import java.util.ArrayList;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.hongri.viewexplore.R;

/**
 * Created by zhongyao on 2017/12/8.
 */

public class ListAdapter extends BaseAdapter {
    private ArrayList<String> datas;
    private LayoutInflater inflater;
    private Context context;

    public ListAdapter(Context context, ArrayList<String> datas) {
        this.datas = datas;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public Object getItem(int position) {
        return datas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.list_item, null, false);
            holder = new ViewHolder();
            holder.tv = (TextView)convertView.findViewById(R.id.tv);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder)convertView.getTag();
        }
        holder.tv.setText(datas.get(position));
        return convertView;
    }

    class ViewHolder {
        private TextView tv;
    }
}
