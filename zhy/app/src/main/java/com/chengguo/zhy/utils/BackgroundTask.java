package com.chengguo.zhy.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.Toast;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;



/**
 * Created by Administrator on 2016/5/25.
 */
public class BackgroundTask {
    public static final int SUCCESS = 0x01;
    public static final int FAILURE = 0x02;

    Context context;
    String address;
    Handler handler;
    int type = 0;


    public BackgroundTask(Context context, String address, Handler handler) {
        this.context = context;
        this.address = address;
        this.handler = handler;



    }
    //数据请求
    public void doInBackground() {

        final Message message = new Message();
        message.arg1 = this.type;
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.configCurrentHttpCacheExpiry(1000 * 0);
        // 设置超时时间
        httpUtils.configTimeout(5 * 1000);
        httpUtils.configSoTimeout(5 * 1000);
        httpUtils.configCurrentHttpCacheExpiry(0);// 设置缓存0秒,5秒内直接返回上次成功请求的结果。HttpRequest.HttpMethod.GET
        httpUtils.send(HttpRequest.HttpMethod.GET, address,
                new RequestCallBack<String>() {
                    @Override
                    public void onSuccess(ResponseInfo<String> responseInfo) {
                        message.what = SUCCESS;
                        Bundle bundle = new Bundle();
                        bundle.putString("result", responseInfo.result);
                        message.setData(bundle);
                        handler.sendMessage(message);
                    }

                    @Override
                    public void onFailure(HttpException error, String msg) {
                        message.what = FAILURE;
                        Bundle bundle = new Bundle();
                        bundle.putString("result", msg);
                        message.setData(bundle);
                        handler.sendMessage(message);
                    }
                }
        );

    }


    public void OkHttpGet(){

             //网络判断
        if (!isNetworkAvailable(context)){
            Toast.makeText(context,"当前网络不可用",Toast.LENGTH_LONG).show();

            return;
        }



        final Message message = new Message();
        message.arg1 = this.type;

        OkHttpClient okHttpClient=new OkHttpClient();
        final Request request=new Request.Builder().url(address).build();
        Call call=okHttpClient.newCall(request);

        //请求加入调度
        call.enqueue(new Callback() {
            //失败回调
            @Override
            public void onFailure(Request request, IOException e) {
                message.what = FAILURE;
                Bundle bundle = new Bundle();
                bundle.putString("result", e.toString());
                message.setData(bundle);
                handler.sendMessage(message);
            }

            //成功回调
            @Override
            public void onResponse(Response response) throws IOException {
                message.what =SUCCESS;
                Bundle bundle = new Bundle();
                bundle.putString("result", response.body().string());
                message.setData(bundle);
                handler.sendMessage(message);
            }
        });


    }




    public boolean isNetworkAvailable(Context context)
    {
        //需要在清单文件中 添加以下权限： <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE"/>
//        Context context = activity.getApplicationContext();
        // 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理）
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);

        if (connectivityManager == null)
        {
            return false;
        }
        else
        {
            // 获取NetworkInfo对象
//            NetworkInfo[] networkInfo = connectivityManager.getAllNetworkInfo();
            NetworkInfo[] networkInfo=connectivityManager.getAllNetworkInfo();

            if (networkInfo != null && networkInfo.length > 0)
            {
                for (int i = 0; i < networkInfo.length; i++)
                {
                    System.out.println(i + "===状态===" + networkInfo[i].getState());
                    System.out.println(i + "===类型===" + networkInfo[i].getTypeName());
                    // 判断当前网络状态是否为连接状态
                    if (networkInfo[i].getState() == NetworkInfo.State.CONNECTED)
                    {
                        return true;
                    }
                }
            }
        }
        return false;
    }

}
