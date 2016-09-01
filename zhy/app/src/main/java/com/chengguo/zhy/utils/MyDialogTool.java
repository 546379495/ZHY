package com.chengguo.zhy.utils;

import android.content.Context;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

import com.chengguo.zhy.R;

import cn.pedant.SweetAlert.SweetAlertDialog;


/**
 * Created by Administrator on 2016/9/1.
 */
public class MyDialogTool {

    /**
     *   等待弹窗
     * @param context 上下文
     * @param hint    提示内容
     * @return        对话框对象
     */
      public static SweetAlertDialog DengDai(Context context, String hint){
          SweetAlertDialog pDialog=null;
          pDialog = new SweetAlertDialog(context, SweetAlertDialog.PROGRESS_TYPE);
          pDialog.getProgressHelper().setBarColor(context.getResources().getColor(R.color.alertDialog_Progress_Color));
          pDialog.getProgressHelper().setBarWidth(5);
          pDialog.getProgressHelper().setCircleRadius(80);
          pDialog.getProgressHelper().setRimColor(context.getResources().getColor(R.color.alertDialog_Progress_hintColor));
          pDialog.getProgressHelper().setRimWidth(5);
          pDialog.setTitleText(hint);
          pDialog.setCancelable(true);

          return pDialog;
      }


    public static AlertDialog.Builder TiShi(Context context, String title, String hint, DialogInterface.OnClickListener onClickListener){
        AlertDialog.Builder ab=new AlertDialog.Builder(context);
        ab.setTitle(title).
                setMessage(hint).
                setNegativeButton("取消",null)
                .setPositiveButton("确定", onClickListener)
                .create();

        return ab;
    }


}
