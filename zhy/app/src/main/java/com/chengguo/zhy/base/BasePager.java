package com.chengguo.zhy.base;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.chengguo.zhy.R;


/**
 * Created by Administrator on 2016/5/20.
 *       主页下五个子页面的父类
 */
public class BasePager {
    public Activity mActivity;
    public View mRootView;

    public TextView tvTitle;//标题
    public FrameLayout flContent;


    public BasePager(Activity activity) {
        mActivity = activity;
        initViews();
    }

    /**
     * 初始化布局
     *    一些固定的控件在此初始化
     */
    public void initViews() {
        mRootView=View.inflate(mActivity, R.layout.base_pager,null);
        tvTitle=(TextView) mRootView.findViewById(R.id.tv_title);
        flContent=(FrameLayout) mRootView.findViewById(R.id.fl_contents);


    }
    /**
     * 初始化数据
     */
    public void initData() {


    }

}
