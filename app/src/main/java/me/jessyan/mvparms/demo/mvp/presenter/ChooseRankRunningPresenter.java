package me.jessyan.mvparms.demo.mvp.presenter;

import android.app.Application;
import android.app.LauncherActivity;
import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.AppManager;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.utils.UiUtils;
import com.jess.arms.widget.autolayout.AutoAppBarLayout;
import com.jess.arms.widget.autolayout.AutoToolbar;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.app.utils.ViewSizeUtil;
import me.jessyan.mvparms.demo.mvp.contract.ChooseRankRunningContract;
import me.jessyan.mvparms.demo.mvp.listener.AppBarStateChangeListener;
import me.jessyan.mvparms.demo.mvp.listener.RecyclerViewOnScroll;
import me.jessyan.mvparms.demo.mvp.model.entity.ChooseRank;
import me.jessyan.mvparms.demo.mvp.ui.activity.WeiBoManagerActivity;
import me.jessyan.mvparms.demo.mvp.ui.adapter.ChooseRankRunningAdapter;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

/**
 * Created by haosiyuan on 2017/5/16.
 * 开始净化
 */
@ActivityScope
public class ChooseRankRunningPresenter extends BasePresenter<ChooseRankRunningContract.Model,ChooseRankRunningContract.View> {

    private RxErrorHandler mErrorHandler;
    private AppManager mAppManager;
    private Application mApplication;
    private AnimationDrawable anim;
    private ChooseRankRunningAdapter adapter;
    private List<ChooseRank> list = new ArrayList<>();
    private RecyclerViewOnScroll scrollListener;
    private Intent intent;

    @Inject
    public ChooseRankRunningPresenter(ChooseRankRunningContract.Model model, ChooseRankRunningContract.View rootView, RxErrorHandler handler
            , AppManager appManager, Application application) {
        super(model, rootView);
        this.mApplication = application;
        this.mErrorHandler = handler;
        this.mAppManager = appManager;
    }

    //初始化标题
    public void initTitle(TextView tvLeft, TextView tvTitle, TextView tvRight) {
        tvLeft.setBackgroundResource(R.mipmap.back_white);
        ViewSizeUtil.AdaptationSize(tvLeft,26,62);
        tvTitle.setText("净化提升");
        tvRight.setBackgroundResource(R.mipmap.left_setting);
        ViewSizeUtil.AdaptationSize(tvRight,60,60);
    }

    public void requestAPI() {
        for (int i = 0; i < 5; i++) {
            list.add(new ChooseRank(true));
        }
        adapter = new ChooseRankRunningAdapter(list);
        mRootView.setAdapter(adapter);
    }

    //左侧返回
    public void AppBarLeftClick() {
        mRootView.killMyself();
    }

    //右侧设置
    public void AppBarRightClick() {
        intent = new Intent(mApplication.getApplicationContext(), WeiBoManagerActivity.class);
        mRootView.launchActivity(intent);
    }

    //recycleview 滑动监听
    public RecyclerViewOnScroll getOnScrollChangeListener(AutoToolbar appbar) {
        scrollListener = new RecyclerViewOnScroll() {
            @Override
            protected void onDown() {
                //不是顶部
                appbar.setBackgroundResource(R.color.tab_text_se);
            }

            @Override
            protected void onUp() {
                //顶部时候
                appbar.setBackgroundResource(R.color.transparent);
            }
        };
        return scrollListener;
    }

    //销毁
    @Override
    public void onDestroy() {
        super.onDestroy();
        mErrorHandler = null;
        mAppManager = null;
        mApplication = null;
        anim = null;
        adapter = null;
        list = null;
        scrollListener = null;
        intent = null;
    }

}
