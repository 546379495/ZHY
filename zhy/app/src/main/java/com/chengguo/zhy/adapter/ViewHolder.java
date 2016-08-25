package com.chengguo.zhy.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Administrator on 2016/5/27.
 *     ViewHolder 抽取类
 */
public class ViewHolder {
     //存放布局文件中不同控件的集合  ViewHolder 复用
     private SparseArray<View> mViews;
    //行数索引
    private int mPosition;
    //内存中的引用
    private View mConvertView;

    /**
     *  构造方法
     * @param context 山下文
     * @param parent ViewGroup
     * @param layoutId 布局文件id
     * @param position 索引
     */
    public ViewHolder(Context context,ViewGroup parent,int layoutId,int position){
        this.mPosition=position;
        this.mViews=new SparseArray<View>();
        mConvertView= LayoutInflater.from(context).inflate(layoutId,parent,false);
        mConvertView.setTag(this);

    }

    /**
     *  入口方法
     * @param context 上下文
     * @param convertView view
     * @param parent      viewGroup
     * @param layoutId 布局文件id
     * @param position 索引
     * @return   ViewHolder
     */
    public static ViewHolder get(Context context,View convertView,ViewGroup parent,int layoutId,int position){
        if (convertView==null) {
            return new ViewHolder(context,parent,layoutId,position);
        }else{
            ViewHolder holder= (ViewHolder) convertView.getTag();
            holder.mPosition=position;//复用时更新 position
            return holder;
        }
    }


    public View getConvertView(){
        return mConvertView;
    }

    /***
     *  同过 viewID 获取控件
     * @param viewId 控件id
     * @param <T>
     * @return 控件对象
     */
    public <T extends View> T getView(int viewId){
        View view=mViews.get(viewId);
        if(view==null){
          view=mConvertView.findViewById(viewId);
            mViews.put(viewId,view);
        }
        return (T)view;
    }

    /**
     * 为TextView设置Text
     * @param viewId 控件id
     * @param text   文本内容
     * @return 本类对象
     */
    public ViewHolder setText(int viewId,String text){
        TextView tv=getView(viewId);
        tv.setText(text);
        return this;
    }

    /**
     * 为ImageView设置 图片
     * @param viewId 控件id
     * @param drawableId 资源文件id
     * @return 本类对象
     */
    public ViewHolder setImgeSrc(int viewId,int drawableId){
        ImageView image=getView(viewId);
        image.setImageResource(drawableId);
        return this;
    }


}
