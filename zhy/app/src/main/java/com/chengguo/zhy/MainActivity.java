package com.chengguo.zhy;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;

import com.lidroid.xutils.ViewUtils;



public class MainActivity extends FragmentActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewUtils.inject(this);


//        initFragment();
    }


    //    public void initFragment(){
//        FragmentManager fm=getSupportFragmentManager();
//        FragmentTransaction transaction= fm.beginTransaction();//开启事务
//        transaction.replace(R.id.fl_content, new ConrentFragment());
//        transaction.commit();//提交事务
//    }


}
