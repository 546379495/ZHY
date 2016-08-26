package com.chengguo.zhy.base.impl;


import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.chengguo.zhy.base.BasePager;

/**
 * ��ҳ
 * @author Administrator
 *  发现
 */
public class FaXianPager extends BasePager {

	public FaXianPager(Activity activity) {
		super(activity);
	}
   
	@Override
	public void initData() {

		tvTitle.setText("发现");
		TextView text=new TextView(mActivity);
		text.setText("发现");
		text.setTextSize(25);
		text.setTextColor(Color.RED);
		text.setGravity(Gravity.CENTER);
		flContent.addView(text);
		
	}
	
	
	
}
