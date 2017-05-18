package me.jessyan.mvparms.demo.mvp.presenter;

import android.app.Application;
import android.content.Intent;
import android.widget.TextView;

import com.jess.arms.base.DefaultAdapter;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.AppManager;
import com.jess.arms.mvp.BasePresenter;
import com.jess.arms.widget.autolayout.AutoAppBarLayout;

import org.simple.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import me.jessyan.mvparms.demo.mvp.contract.ChooseRankContract;
import me.jessyan.mvparms.demo.mvp.eventbus.ChooseRankChangeEvent;
import me.jessyan.mvparms.demo.mvp.model.entity.ChooseRank;
import me.jessyan.mvparms.demo.mvp.ui.activity.WeiBoManagerActivity;
import me.jessyan.mvparms.demo.mvp.ui.adapter.ChooseRankAdapter;
import me.jessyan.mvparms.demo.mvp.ui.contact.ChooseRankSelectView;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

/**
 * Created by haosiyuan on 2017/5/11.
 * 选择净化词
 */
@ActivityScope
public class ChooseRankPresenter extends BasePresenter<ChooseRankContract.Model,ChooseRankContract.View> {

    private RxErrorHandler mErrorHandler;
    private AppManager mAppManager;
    private Application mApplication;

    private DefaultAdapter<ChooseRank> adapter;
    private List<ChooseRank> list = new ArrayList<>();
    private Intent intent_weibo;

    @Inject
    public ChooseRankPresenter(ChooseRankContract.Model model, ChooseRankContract.View rootView, RxErrorHandler handler
            , AppManager appManager, Application application) {
        super(model, rootView);
        this.mApplication = application;
        this.mErrorHandler = handler;
        this.mAppManager = appManager;
    }

    //设置标题
    public void initToolBar(TextView tvTitle, TextView tvLeft, TextView tvRight) {
        tvTitle.setText("选择净化词");
        tvLeft.setText("取消");
        tvRight.setText("规则");
    }

    //标题左侧点击
    public void AppBarLeftClick(){
        mRootView.killMyself();
    }

    //标题右侧点击
    public void AppBarRightClick(){
    }

    //微博账号管理
    public void WeiBoManager(){
        intent_weibo = new Intent(mApplication.getApplicationContext(), WeiBoManagerActivity.class);
        mRootView.launchActivity(intent_weibo);
    }

    //全选净化
    public void ChooseAll(boolean isCheck){
        for (int i = 0; i < list.size(); i++) {
            if (isCheck){
                list.get(i).setCheck(true);
            }else{
                list.get(i).setCheck(false);
            }
        }
        EventBus.getDefault().post(new ChooseRankChangeEvent(list));
        adapter.notifyDataSetChanged();
    }

    //设置adapter
    public void requestAPI(){
        for (int i = 0; i < 9; i++) {
            list.add(new ChooseRank(false));
        }
        adapter = new ChooseRankAdapter(list);
        mRootView.setAdapter(adapter);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mErrorHandler = null;
        mAppManager = null;
        mApplication = null;
        adapter = null;
        list = null;
        intent_weibo = null;
    }
}
