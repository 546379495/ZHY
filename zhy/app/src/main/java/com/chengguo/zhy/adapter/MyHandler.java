package com.chengguo.zhy.adapter;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;


import com.chengguo.zhy.utils.BackgroundTask;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Administrator on 2016/6/7.
 */
public abstract class MyHandler extends Handler {

        private Context mContext;

    public MyHandler(Context Context){
        mContext=Context;

    }
    @Override
    public void handleMessage(Message msg) {
        switch (msg.what){

            case BackgroundTask.SUCCESS:{
                Bundle bundle = msg.getData();
                if (bundle != null){

                    Log.e("result", bundle.getString("result"));

                    try {
                        JSONObject jsonObject = new JSONObject(bundle.getString("result"));

                            initData(jsonObject);

                    } catch (JSONException e) {
                        e.printStackTrace();
                        Toast.makeText(mContext, "数据解析失败", Toast.LENGTH_SHORT).show();
                    }
                }
            }
            break;
            case BackgroundTask.FAILURE:{
//
                Toast.makeText(mContext, "数据解析失败", Toast.LENGTH_SHORT).show();
            }

            break;
        }
    }

    public abstract void initData(JSONObject jsonObject) throws JSONException ;


}
