package com.chengguo.zhy.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

/**
 * Created by Administrator on 2016/5/28.
 */
public abstract class CommonAdapter<T> extends BaseAdapter {
    //上下文
    protected Context mContext;
    //数据源
    protected List<T> mDatas;

    protected LayoutInflater mInflater;
    //布局文件id
    private  int layoutId;

    public CommonAdapter(Context context, List<T> datas,int layoutId) {
        this.mContext = context;
        mInflater = LayoutInflater.from(context);
        this.mDatas = datas;
        this.layoutId=layoutId;
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Override
    public T getItem(int position) {
        return mDatas.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder=ViewHolder.get(mContext,convertView,parent,layoutId,position);
        convert(holder, getItem(position),position);

        return holder.getConvertView();

    }

    /**
     * getView 实体内容设置方法
     * @param holder  ViewHolder对象
     * @param t 当前行数据源对象
     */
    public abstract void convert(ViewHolder holder,T t,int position);
}
