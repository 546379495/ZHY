package com.chengguo.zhy.base.impl;


import android.app.Activity;
import android.view.View;
import com.chengguo.zhy.R;
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
		View view=View.inflate(mActivity, R.layout.wode_pager,null);


		flContent.addView(view);
		
	}
	
	
	
}
