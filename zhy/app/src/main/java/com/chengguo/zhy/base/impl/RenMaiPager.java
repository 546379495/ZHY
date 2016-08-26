package com.chengguo.zhy.base.impl;


import android.app.Activity;
import android.graphics.Color;
import android.view.Gravity;
import android.widget.TextView;

import com.chengguo.zhy.base.BasePager;

/**
 * ��ҳ
 * @author Administrator
 *  人脉
 */
public class RenMaiPager extends BasePager {

	public RenMaiPager(Activity activity) {
		super(activity);
	}
   
	@Override
	public void initData() {

		tvTitle.setText("人脉");
		TextView text=new TextView(mActivity);
		text.setText("人脉");
		text.setTextSize(25);
		text.setTextColor(Color.RED);
		text.setGravity(Gravity.CENTER);
		flContent.addView(text);
		
	}
	
	
	
}
