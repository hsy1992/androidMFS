package me.jessyan.mvparms.hsy.mvp.contract;


import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;

import me.jessyan.mvparms.hsy.mvp.ui.adapter.HomeAdapter;

/**
 * Created by haosiyuan on 2017/5/5.
 */

public interface HomeContract {

    interface View extends IView{
        void setToolBar(String title);
        void setAdapter(HomeAdapter adapter);
    }

    interface Model extends IModel {

    }
}
