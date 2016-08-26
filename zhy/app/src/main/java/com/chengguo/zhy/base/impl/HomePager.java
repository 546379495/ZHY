package com.chengguo.zhy.base.impl;


import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.TextView;

import com.chengguo.zhy.base.BasePager;

/**
 * ��ҳ
 * @author Administrator
 *  首页
 */
public class HomePager extends BasePager {

	public HomePager(Activity activity) {
		super(activity);
	}
   
	@Override
	public void initData() {

		tvTitle.setText("首页");
		TextView text=new TextView(mActivity);
		text.setText("首页");
		text.setTextSize(25);
		text.setTextColor(Color.RED);
		text.setGravity(Gravity.CENTER);
		flContent.addView(text);
		
	}
	
	
	
}
