package com.chengguo.zhy.adapter;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.chengguo.zhy.R;

import java.util.List;

/**
 * Created by Administrator on 2016/8/26.
 */
public class simpleAdapter extends RecyclerView.Adapter<MyViewHolder> {

    private LayoutInflater mInflater;
    private Context mContext;
    private Activity mActivity;
    private  List<String> mDatas;

    public interface OnItemClickListener{
        void onItemClick(View view,int position);
        void onItemLongClick(View view,int position);

    }
private OnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(OnItemClickListener listener){
        this.mOnItemClickListener=listener;
    }


    public simpleAdapter(Activity Activity, List<String> datas){
        this.mActivity=Activity;
        this.mDatas=datas;
        this.mInflater=LayoutInflater.from(mActivity);

    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
         holder.tv.setText(mDatas.get(position));


            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    mOnItemClickListener.onItemClick(holder.itemView,position);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View view) {
                    mOnItemClickListener.onItemLongClick(holder.itemView,position);
                    return false;
                }
            });






    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=mInflater.inflate(R.layout.text_tiem,parent, false);
        MyViewHolder viewHolder=new MyViewHolder(view);


        return viewHolder;
    }
}
class MyViewHolder extends RecyclerView.ViewHolder{

     TextView tv;

    public MyViewHolder(View v){
        super(v);
        tv= (TextView) v.findViewById(R.id.tv);
    }
}