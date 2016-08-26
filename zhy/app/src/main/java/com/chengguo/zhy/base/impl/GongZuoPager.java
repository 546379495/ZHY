package com.chengguo.zhy.base.impl;


import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.chengguo.zhy.base.BasePager;

/**
 * ��ҳ
 * @author Administrator
 *  工作
 */
public class GongZuoPager extends BasePager {

	public GongZuoPager(Activity activity) {
		super(activity);
	}
   
	@Override
	public void initData() {

		tvTitle.setText("工作");
		TextView text=new TextView(mActivity);
		text.setText("工作");
		text.setTextSize(25);
		text.setTextColor(Color.RED);
		text.setGravity(Gravity.CENTER);
		flContent.addView(text);
		
	}
	
	
	
}
