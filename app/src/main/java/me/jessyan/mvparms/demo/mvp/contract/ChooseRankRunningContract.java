package me.jessyan.mvparms.demo.mvp.contract;


import android.graphics.drawable.AnimationDrawable;

import com.jess.arms.base.DefaultAdapter;
import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;

/**
 * Created by haosiyuan on 2017/5/5.
 * 主页
 */

public interface ChooseRankRunningContract {

    interface View extends IView{

        void setAdapter(DefaultAdapter adapter);

    }

    interface Model extends IModel {

    }
}
