package com.jess.arms.widget.ui.navigation;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.support.annotation.Px;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jess.arms.utils.IdiUtils;
import com.jess.arms.widget.autolayout.AutoTabLayout;
import com.zhy.autolayout.AutoRelativeLayout;
import com.zhy.autolayout.utils.AutoUtils;

import java.util.Timer;
import java.util.TimerTask;


/**
 * Created by haosiyuan on 2017/5/4.
 * 导航栏
 */

public class NavigationView extends AutoRelativeLayout {

    private Context mContext;
    private ViewPager viewPager;
    private TabLayout tabLayout;
    private RelativeLayout.LayoutParams lp;
    private RelativeLayout.LayoutParams lpPager;
    private AttributeSet attrs;
    private Timer timer = new Timer();


    public NavigationView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.mContext = context;
        this.attrs = attrs;
        initView();
    }

    private void initView() {
        tabLayout = new AutoTabLayout(mContext,attrs);
        tabLayout.setId(IdiUtils.generateViewId());
        viewPager = new ViewPager(mContext);
        viewPager.setId(IdiUtils.generateViewId());

        lpPager = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);

    }


    private Drawable buildDrawable(int normalPic , int checkPic){
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int []{android.R.attr.state_selected},
                getResources().getDrawable(checkPic));
        stateListDrawable.addState(new int []{},
                getResources().getDrawable(normalPic));
        return stateListDrawable;
    }

    public void setData(NavigationModel navigationModel, FragmentManager fragmentManager) {

        lp = new RelativeLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, AutoUtils.getPercentHeightSize(navigationModel.tabHeight));

        //设置方向
        if (navigationModel.direction == NavigationManager.DIRECTION_BOTTOM){
            lp.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);
            lpPager.addRule(RelativeLayout.ABOVE,tabLayout.getId());
        }else{
            lp.addRule(RelativeLayout.ALIGN_PARENT_TOP);
            lpPager.addRule(RelativeLayout.BELOW,tabLayout.getId());
        }

        viewPager.setLayoutParams(lpPager);
        //设置viewpager
        viewPager.setAdapter(new FragmentPagerAdapter(fragmentManager) {
            @Override
            public Fragment getItem(int position) {
                return navigationModel.list.get(position).getFragment();
            }

            @Override
            public int getCount() {
                return navigationModel.list.size();
            }

            @Override
            public CharSequence getPageTitle(int position) {
                return navigationModel.list.get(position).getText();
            }
        });

        //设置tablayout
        tabLayout.setLayoutParams(lp);
        tabLayout.setTabMode(TabLayout.MODE_FIXED);
        tabLayout.setSelectedTabIndicatorColor(navigationModel.tabLineColor);
        tabLayout.setTabTextColors(navigationModel.colorNormal,navigationModel.colorCheck);
        tabLayout.setupWithViewPager(viewPager);

        //设置tab
        for (int i = 0; i < navigationModel.list.size(); i++) {
            TabModel model = navigationModel.list.get(i);
            tabLayout.getTabAt(i).setIcon(buildDrawable(model.getPicNormal(),model.getPicCheck()));

            ViewGroup tabGroup = (ViewGroup) tabLayout.getChildAt(0);
            ViewGroup tabContainer = (ViewGroup) tabGroup.getChildAt(i);

            ImageView icon = (ImageView) tabContainer.getChildAt(0);
            icon.setScaleType(ImageView.ScaleType.FIT_XY);
            icon.setLayoutParams(new LinearLayout.LayoutParams(AutoUtils.getPercentWidthSize(270),
                    AutoUtils.getPercentHeightSize(90)));

        }

        this.addView(viewPager);
        this.addView(tabLayout);
    }
}
