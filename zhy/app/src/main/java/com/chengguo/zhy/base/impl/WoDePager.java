package com.chengguo.zhy.base.impl;


import android.app.Activity;
import android.view.View;
import android.widget.TextView;

import com.chengguo.zhy.R;
import com.chengguo.zhy.base.BasePager;
import com.chengguo.zhy.utils.MyDialogTool;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import cn.pedant.SweetAlert.SweetAlertDialog;

/**
 * ��ҳ
 * @author Administrator
 *  我的
 */
public class WoDePager extends BasePager {

	@ViewInject(R.id.shezhi)
     private TextView shezhi;

	public WoDePager(Activity activity) {
		super(activity);
	}
   
	@Override
	public void initData() {

		tvTitle.setText("我的");
		View view=View.inflate(mActivity, R.layout.wode_pager,null);
		ViewUtils.inject(this,view);
		shezhi.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				SweetAlertDialog sweetAlertDialog= MyDialogTool.DengDai(mActivity,"");
				sweetAlertDialog.show();

			}
		});
		flContent.addView(view);
		
	}
	
	
	
}
