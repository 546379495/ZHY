package com.chengguo.zhy;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;


import com.chengguo.zhy.utils.PrefUtils;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/19.
 *     引导页面Activity
 */
public class GuideActivity extends Activity implements ViewPager.OnPageChangeListener {
     private ViewPager mViewPager;
    //图片数组
    private  final int[] mImageIds = { R.mipmap.guide_1, R.mipmap.guide_2, R.mipmap.guide_3 };

    private ArrayList<ImageView> mImageViewList;
    //立即进入按钮
    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        init();
        initViews();

     }
    public void init(){
        mViewPager= (ViewPager) findViewById(R.id.guide_vp);
        mButton= (Button) findViewById(R.id.guide_btn);
        mButton.setVisibility(View.INVISIBLE);
    }

    /**
     *
     * 初始化视图
     */
    private void initViews() {
        mImageViewList = new ArrayList<>();
        for (int i = 0; i < mImageIds.length; i++) {
            ImageView image = new ImageView(this);
            image.setBackgroundResource(mImageIds[i]);
            mImageViewList.add(image);
        }
        mViewPager.setAdapter(new GuideAdapter());
        mViewPager.setOnPageChangeListener(this);

        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                  //更新SP
                PrefUtils.setBoolean(GuideActivity.this, "is_user_guide_showed", true);

                //跳转主页面，销毁当前页面
                startActivity(new Intent(GuideActivity.this,SplashActivity.class));
                finish();

            }
        });
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        System.out.println("!!!!!!!!!!!!!!!!!!!1+ " + position);
        if(position==mImageIds.length-1){
            mButton.setVisibility(View.VISIBLE);
        }else{
            mButton.setVisibility(View.INVISIBLE);
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {


    }

    /**
     * ViewPager 适配器
     */
    class GuideAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return mImageIds.length;
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0 == arg1;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            container.addView(mImageViewList.get(position));
            return mImageViewList.get(position);
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View) object);
        }

    }
}
