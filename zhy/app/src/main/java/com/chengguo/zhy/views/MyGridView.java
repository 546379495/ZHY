package com.chengguo.zhy.views;

import android.widget.GridView;

/**
 * Created by Administrator on 2016/6/3.
 */
public class MyGridView extends GridView {

    public MyGridView(android.content.Context context,
                      android.util.AttributeSet attrs)
    {
        super(context, attrs);
    }

    /**
     * 设置不滚动
     */
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec)
    {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);

    }
}
