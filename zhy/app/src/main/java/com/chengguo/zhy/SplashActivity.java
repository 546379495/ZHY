package com.chengguo.zhy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.ScaleAnimation;
import android.widget.LinearLayout;

import com.chengguo.zhy.utils.PrefUtils;


/**
 * Created by Administrator on 2016/5/19.
 *
 *  欢迎界面Activity
 */
public class SplashActivity extends Activity {

    LinearLayout mLinearLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
          setContentView(R.layout.activity_splash);
        init();
        startAnim();
    }
    public void init(){
        mLinearLayout= (LinearLayout) findViewById(R.id.splash_ll);
    }
    /**
     * 启动动画的方法
     */
    private void startAnim() {
        //动画效果同事进行创建
        AnimationSet set=new AnimationSet(false);

        // 创建旋转动画 懂0的位置开始 旋转360度 自身旋转 0.5f（基于zhongxindian）
//        RotateAnimation rotatr = new RotateAnimation(0, 360, Animation.RELATIVE_TO_SELF, 0.5f,
//                Animation.RELATIVE_TO_SELF, 0.5f);
//        rotatr.setDuration(1000);// 动画时间
//        rotatr.setFillAfter(true);// 保存动画完成后的状态

        // 创建缩放动画
        ScaleAnimation scakle = new ScaleAnimation(0, 1, 0, 1, Animation.RELATIVE_TO_SELF, 0.5f,
                Animation.RELATIVE_TO_SELF, 0.5f);
        scakle.setDuration(1000);// 动画时间
        scakle.setFillAfter(true);// 保存动画完成后的状态

        //创建渐变动画 从完全透明到不完全不透明
        AlphaAnimation alpha=new AlphaAnimation(0, 1);
        alpha.setDuration(1000);// 动画时间
        alpha.setFillAfter(true);// 保存动画完成后的状态

        //添加动画
//        set.addAnimation(rotatr);
        set.addAnimation(scakle);
        set.addAnimation(alpha);

        //设置动画监听  动画完成后跳转到 引导界面 或 主页
        set.setAnimationListener(new Animation.AnimationListener() {

            @Override
            public void onAnimationStart(Animation arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onAnimationRepeat(Animation arg0) {

            }

            @Override
            public void onAnimationEnd(Animation arg0) {

                jumpNexPage();
            }
        });

        //运行动画
        mLinearLayout.startAnimation(set);
    }

    /**
     * 页面跳转
     */
    private void jumpNexPage(){

            boolean userGuide= PrefUtils.getBoolean(this, "is_user_guide_showed", false);
//           //跳至登录页面
       startActivity(new Intent(SplashActivity.this,MainActivity.class));
//        if(!userGuide){//跳转到引导页面
//            startActivity(new Intent(SplashActivity.this,GuideActivity.class));
//        }else{//跳转到主页面
//            startActivity(new Intent(SplashActivity.this,MainActivity.class));
//        }

        finish();//销毁当前Activity
    }

}
