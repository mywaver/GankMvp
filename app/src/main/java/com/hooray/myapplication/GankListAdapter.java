package com.hooray.myapplication;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ximei on 2018/3/21.
 */

public class GankListAdapter extends BaseAdapter {

    private Context context;
    private LayoutInflater inflater;
    private List<BaseNewBean> newBeen = new ArrayList<>();

    public GankListAdapter(Context context) {
        this.context = context;
        this.inflater = LayoutInflater.from(context);
    }

    public void addNews(List<BaseNewBean> beans) {
        newBeen.clear();
        newBeen.addAll(beans);
    }

    @Override
    public int getCount() {
        return newBeen == null ? 0 : newBeen.size();
    }

    @Override
    public Object getItem(int position) {
        return  newBeen.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }



    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            holder = new ViewHolder();
            convertView = LayoutInflater.from(context).inflate(R.layout.gank_news_item, null);
            holder.desc = convertView.findViewById(R.id.desc);
            holder.author = convertView.findViewById(R.id.author);
            convertView.setTag(convertView);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.desc.setText(newBeen.get(position).desc);
        holder.author.setText(newBeen.get(position).who);
        Log.e("getview","newBeen.get(position).desc"+newBeen.get(position).desc);
        return convertView;
    }

    class ViewHolder {
        private TextView desc;
        private TextView author;
    }
}
