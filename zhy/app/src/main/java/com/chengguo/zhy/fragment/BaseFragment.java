package com.chengguo.zhy.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Administrator on 2016/5/20.
 */
public abstract class BaseFragment extends Fragment {
    public Activity mActivity;

    //Fragment 创建
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivity=getActivity();
    }

    //处理Fragment 布局
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle
            savedInstanceState) {
        return initViews();
    }

    //依附Activity 创建完成
    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    /**
     * 子类必须实现 初始化布局的方法
     * @return 布局文件
     */
    public abstract View initViews();

    /**
     * 初始化数据的方法 可不实现
     */
    public void initData(){

    }
}
