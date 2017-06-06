package com.sung.viewswitcher;

import android.content.Context;
import android.support.v4.widget.TextViewCompat;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sung on 2017/6/6.
 */

public class MainAdapter extends RecyclerView.Adapter implements View.OnClickListener{
    public List<String> items = new ArrayList<>();
    private Context mContext;
    private LayoutInflater mInflater;
    private onItemClickListener onItemClickListener;

    public MainAdapter(List<String> items, Context mContext) {
        if (items!=null) {
            this.items.clear();
            this.items.addAll(items);
        }
        this.mContext = mContext;
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.layout_item,parent,false);
        return new MainHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MainHolder item = (MainHolder) holder;
        item.item.setText(items.get(position).toString());
        item.item.setOnClickListener(this);
        item.item.setTag(position);
    }

    @Override
    public int getItemCount() {
        Log.e("MainAdapter", "getItemCount: "+items.size() );
        return items.size();
    }

    public void addData(List list, boolean clear) {
        if (clear) {
            items.clear();
        }
        if (list != null) {
            items.addAll(list);
        }
        notifyDataSetChanged();
    }

    @Override
    public void onClick(View view) {
        if (view instanceof TextView){
            TextView tv = (TextView) view;
            this.onItemClickListener.onItemClick(tv.getText().toString(),(int)tv.getTag());
        }
    }

    class MainHolder extends RecyclerView.ViewHolder{
        public TextView item;

        public MainHolder(View itemView) {
            super(itemView);
            item = (TextView) itemView.findViewById(R.id.tv_item);
        }
    }

    public interface onItemClickListener{
        void onItemClick(String string, int position);
    }

    public void addItemClickListener(onItemClickListener onItemClickListener){
        if (onItemClickListener == null)
            return;

        this.onItemClickListener = onItemClickListener;
    }
}
