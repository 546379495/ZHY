package com.chengguo.zhy.base.impl;


import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.chengguo.zhy.base.BasePager;

/**
 * ��ҳ
 * @author Administrator
 *  我的
 */
public class WoDePager extends BasePager {

	public WoDePager(Activity activity) {
		super(activity);
	}
   
	@Override
	public void initData() {

		tvTitle.setText("我的");
		TextView text=new TextView(mActivity);
		text.setText("我的");
		text.setTextSize(25);
		text.setTextColor(Color.RED);
		text.setGravity(Gravity.CENTER);
		flContent.addView(text);
		
	}
	
	
	
}
