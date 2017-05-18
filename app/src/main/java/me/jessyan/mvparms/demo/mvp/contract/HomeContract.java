package me.jessyan.mvparms.demo.mvp.contract;


import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;

import me.jessyan.mvparms.demo.mvp.ui.adapter.HomeAdapter;

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
