package com.chengguo.zhy.fragment;


import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.chengguo.zhy.R;
import com.chengguo.zhy.base.BasePager;
import com.chengguo.zhy.base.impl.FaXianPager;
import com.chengguo.zhy.base.impl.GongZuoPager;
import com.chengguo.zhy.base.impl.HomePager;
import com.chengguo.zhy.base.impl.RenMaiPager;
import com.chengguo.zhy.base.impl.WoDePager;
import com.lidroid.xutils.ViewUtils;
import com.lidroid.xutils.view.annotation.ViewInject;

import java.util.ArrayList;

/**
 * Created by Administrator on 2016/5/20.
 *      主界面
 */
public class ConrentFragment extends BaseFragment {
   @ViewInject(R.id.rg_group)
   private RadioGroup mGroup;
    @ViewInject(R.id.vp_content)
    private ViewPager mViewPager;




   public ArrayList<BasePager> mPagerList;//记录子布局的集合



    @Override
    public View initViews() {
        View view=View.inflate(mActivity, R.layout.fragment_content,null);

        ViewUtils.inject(this,view);

        return view;
    }


    @Override
    public void initData() {
        mGroup.check(R.id.rb_shouye);
        mPagerList=new ArrayList();

        mPagerList.add(new HomePager(mActivity));
        mPagerList.add(new RenMaiPager(mActivity));
        mPagerList.add(new GongZuoPager(mActivity));
        mPagerList.add(new FaXianPager(mActivity));
        mPagerList.add(new WoDePager(mActivity));
        mViewPager.setAdapter(new ContentAtapter());
        mPagerList.get(0).initData();
        mGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i){
                    case R.id.rb_shouye:
                        mViewPager.setCurrentItem(0,false);
                        break;
                    case R.id.rb_renmai:
                        mViewPager.setCurrentItem(1,false);
                        break;
                    case R.id.rb_gongzuo:
                        mViewPager.setCurrentItem(2,false);
                        break;
                    case R.id.rb_faxian:
                        mViewPager.setCurrentItem(3,false);
                        break;
                    case R.id.rb_wode:
                        mViewPager.setCurrentItem(4,false);
                        break;
                }
            }
        });

        mViewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {

                    mPagerList.get(position).initData();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    class ContentAtapter extends PagerAdapter{
        @Override
        public int getCount() {
            return mPagerList.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            return arg0==arg1;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView((View)object);
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            BasePager pager=mPagerList.get(position);
            container.addView(pager.mRootView);
//			pager.initData();
            return mPagerList.get(position).mRootView;
        }

    }


}
