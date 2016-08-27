package com.chengguo.zhy.base.impl;


import android.app.Activity;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;

import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.Toast;


import com.chengguo.zhy.R;
import com.chengguo.zhy.adapter.simpleAdapter;
import com.chengguo.zhy.base.BasePager;
import com.chengguo.zhy.views.DividerItemDecoration;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;
import java.util.List;

/**
 * ��ҳ
 * @author Administrator
 *  首页
 */
public class HomePager extends BasePager {
    @ViewInject(R.id.rv)
	private RecyclerView mRecyclerView;

	private List<String> mData;
	private simpleAdapter mAdapter;

	public HomePager(Activity activity) {
		super(activity);
	}
   
	@Override
	public void initData() {

		View view=View.inflate(mActivity, R.layout.home_pager,null);
		ViewUtils.inject(this,view);
		mData=new ArrayList<>();
		for (int i = 'A'; i <'z' ; i++) {
			mData.add(""+(char)i);
		}
		init();
		flContent.addView(view);
		
	}
	public void init(){
		mAdapter=new simpleAdapter(mActivity,mData);
		System.out.println("!!!!!!!!!!!!!!!  "+mData.size());

			mRecyclerView.setAdapter(mAdapter);
			//-------------------listview 样式
			//设置布局管理
//			mRecyclerView.setLayoutManager(new LinearLayoutManager(mActivity,LinearLayoutManager.VERTICAL,false));
		    //设置分割线
//			mRecyclerView.addItemDecoration(new DividerItemDecoration(mActivity,DividerItemDecoration.VERTICAL_LIST));

		//----------------------gridview样式
//		mRecyclerView.setLayoutManager(new GridLayoutManager(mActivity,3));
		//----------------------gridview水平样式
		mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.HORIZONTAL));

		mAdapter.setOnItemClickListener(new simpleAdapter.OnItemClickListener() {
			@Override
			public void onItemClick(View view, int position) {
//				System.out.print("!!!!!!!!!!!!!!!!! +"+position);
				Toast.makeText(mActivity,""+position,Toast.LENGTH_LONG).show();
			}

			@Override
			public void onItemLongClick(View view, int position) {

			}
		});

	}


	
}
