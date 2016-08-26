package com.chengguo.zhy.views;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by Administrator on 2016/5/20.
 */
public class NoScrolViewPager extends ViewPager {
    public NoScrolViewPager(Context context) {
        super(context);
    }
    public NoScrolViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    //表示是否拦截事件
    @Override
    public boolean onInterceptTouchEvent(MotionEvent arg0) {
        return false;
    }
    /*  拦截滑动
     * @see android.support.v4.view.ViewPager#onTouchEvent(android.view.MotionEvent)
     */
    @Override
    public boolean onTouchEvent(MotionEvent arg0) {
        return false;
    }
}
