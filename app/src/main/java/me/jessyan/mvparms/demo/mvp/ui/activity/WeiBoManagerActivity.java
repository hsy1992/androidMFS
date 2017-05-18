package me.jessyan.mvparms.demo.mvp.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jaeger.library.StatusBarUtil;
import com.jess.arms.base.BaseActivity;
import com.jess.arms.base.DefaultAdapter;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.UiUtils;
import com.jess.arms.widget.autolayout.AutoToolbar;

import butterknife.BindView;
import butterknife.OnClick;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.di.component.DaggerWeiBoManagerComponent;
import me.jessyan.mvparms.demo.di.module.WeiBoManagerModule;
import me.jessyan.mvparms.demo.mvp.contract.WeiBoManagerContract;
import me.jessyan.mvparms.demo.mvp.presenter.WeiBoManagerPresenter;

/**
 * Created by haosiyuan on 2017/5/14.
 * 微博账号管理
 */

public class WeiBoManagerActivity extends BaseActivity<WeiBoManagerPresenter> implements WeiBoManagerContract.View {

    @BindView(R.id.tv_left)
    TextView tvLeft;
    @BindView(R.id.ll_left)
    LinearLayout llLeft;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_right)
    TextView tvRight;
    @BindView(R.id.ll_right)
    LinearLayout llRight;
    @BindView(R.id.appbar)
    AutoToolbar appbar;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerWeiBoManagerComponent
                .builder()
                .weiBoManagerModule(new WeiBoManagerModule(this))
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    protected View initView() {
        return LayoutInflater.from(this).inflate(R.layout.activity_weibomanager, null, false);
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setTransparentForImageView(this, null);
    }

    @Override
    protected void initData() {
        //初始化标题
        mPresenter.initTitle(tvLeft,tvTitle,tvRight);
        //请求数据
        mPresenter.requestAPI();
    }

    @Override
    public void setAdapter(DefaultAdapter adapter) {
        recyclerView.setAdapter(adapter);
        initRecycleView();
    }

    @Override
    public Context getContext() {
        return this;
    }

    /**
     * 初始化RecycleView
     */
    private void initRecycleView() {
        UiUtils.configRecycleView(recyclerView, new LinearLayoutManager(this));
    }

    @Override
    public void showLoading() {

    }

    @Override
    public void hideLoading() {

    }

    @Override
    public void showMessage(String message) {
        UiUtils.SnackbarText(message);
    }

    @Override
    public void launchActivity(Intent intent) {
        UiUtils.startActivity(intent);
    }

    @Override
    public void killMyself() {
        finish();
    }

    @OnClick(R.id.ll_left)
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.ll_left:
                //左侧返回
                killMyself();
                break;
        }
    }
}
