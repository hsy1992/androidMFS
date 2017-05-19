package me.jessyan.mvparms.hsy.mvp.presenter;

import android.app.Application;
import android.view.View;
import android.widget.TextView;

import com.jess.arms.base.DefaultAdapter;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.AppManager;
import com.jess.arms.mvp.BasePresenter;

import org.simple.eventbus.Subscriber;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import me.jessyan.mvparms.hsy.R;
import me.jessyan.mvparms.hsy.app.utils.ViewSizeUtil;
import me.jessyan.mvparms.hsy.mvp.contract.WeiBoManagerContract;
import me.jessyan.mvparms.hsy.mvp.eventbus.WeiBoManagerAddEvent;
import me.jessyan.mvparms.hsy.mvp.eventbus.WeiBoManagerCancleEvent;
import me.jessyan.mvparms.hsy.mvp.model.entity.WeiBoManager;
import me.jessyan.mvparms.hsy.mvp.ui.adapter.WeiBoManagerAdapter;
import me.jessyan.mvparms.hsy.mvp.ui.dialog.WeiBoAddAccountDialog;
import me.jessyan.rxerrorhandler.core.RxErrorHandler;

/**
 * Created by haosiyuan on 2017/5/5.
 * 微博账号管理
 */
@ActivityScope
public class WeiBoManagerPresenter extends BasePresenter<WeiBoManagerContract.Model,WeiBoManagerContract.View> {

    private RxErrorHandler mErrorHandler;
    private AppManager mAppManager;
    private Application mApplication;
    private DefaultAdapter adapter;
    private List<WeiBoManager> list = new ArrayList<>();
    private WeiBoAddAccountDialog weiBoAddAccountDialog;

    @Inject
    public WeiBoManagerPresenter(WeiBoManagerContract.Model model, WeiBoManagerContract.View rootView, RxErrorHandler handler
            , AppManager appManager, Application application) {
        super(model, rootView);
        this.mApplication = application;
        this.mErrorHandler = handler;
        this.mAppManager = appManager;
    }

    //请求数据
    public void requestAPI(){
        for (int i = 0; i < 4; i++) {
            list.add(new WeiBoManager("13333333333"));
        }
        adapter = new WeiBoManagerAdapter(list);
        mRootView.setAdapter(adapter);
    }


    //初始化标题
    public void initTitle(TextView tvLeft, TextView tvTitle, TextView tvRight) {
        tvLeft.setBackgroundResource(R.mipmap.back_white);
        ViewSizeUtil.AdaptationSize(tvLeft,26,62);
        tvTitle.setText("绑定微博账号");
        tvRight.setGravity(View.INVISIBLE);
    }

    //解绑
    @Subscriber
    public void onEventMainThread(WeiBoManagerCancleEvent event) {
        list.remove(event.getPosition());
        adapter.notifyDataSetChanged();
    }

    //添加账号
    @Subscriber
    public void onEventMainThread(WeiBoManagerAddEvent event) {
        weiBoAddAccountDialog = new WeiBoAddAccountDialog(mRootView.getContext()) {
            @Override
            public void addAccount(String account, String password) {
                list.add(new WeiBoManager(account));
            }
        };
        weiBoAddAccountDialog.show();
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mErrorHandler = null;
        mAppManager = null;
        mApplication = null;
        adapter = null;
        list = null;
        weiBoAddAccountDialog = null;
    }

}
