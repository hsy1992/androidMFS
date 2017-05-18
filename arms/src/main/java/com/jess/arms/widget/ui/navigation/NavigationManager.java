package com.jess.arms.widget.ui.navigation;


import android.support.v4.app.FragmentManager;

import org.simple.eventbus.EventBus;


/**
 * Created by haosiyuan on 2017/5/4.
 * 导航栏控制器
 */

public class NavigationManager {
    //方向
    public static int DIRECTION_TOP = 0;
    public static int DIRECTION_BOTTOM = 1;

    public NavigationModel navigationModel;
    public FragmentManager fragmentManager;


    public NavigationManager() {
    }

    public NavigationManager addTab(NavigationModel navigationModel){
        this.navigationModel = navigationModel;
        return this;
    }

    public NavigationManager addFragmentManager(FragmentManager fragmentManager){
        this.fragmentManager = fragmentManager;
        return this;
    }

    public void build(NavigationView navigationView){
        navigationView.setData(navigationModel,fragmentManager);
    }
}
