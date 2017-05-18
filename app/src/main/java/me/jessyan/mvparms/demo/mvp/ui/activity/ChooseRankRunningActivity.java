package me.jessyan.mvparms.demo.mvp.ui.activity;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
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
import com.jess.arms.widget.autolayout.AutoAppBarLayout;
import com.jess.arms.widget.autolayout.AutoToolbar;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.di.component.DaggerChooseRankRunningComponent;
import me.jessyan.mvparms.demo.di.module.ChooseRankRunningModule;
import me.jessyan.mvparms.demo.mvp.contract.ChooseRankRunningContract;
import me.jessyan.mvparms.demo.mvp.presenter.ChooseRankRunningPresenter;

/**
 * Created by haosiyuan on 2017/5/16.
 * 净化开始
 */

public class ChooseRankRunningActivity extends BaseActivity<ChooseRankRunningPresenter> implements ChooseRankRunningContract.View {


    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
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

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerChooseRankRunningComponent
                .builder()
                .chooseRankRunningModule(new ChooseRankRunningModule(this))
                .appComponent(appComponent)
                .build()
                .inject(this);
    }

    @Override
    protected View initView() {
        return LayoutInflater.from(this).inflate(R.layout.activity_chooserankrunning, null);
    }

    @Override
    protected void setStatusBar() {
        StatusBarUtil.setTransparentForImageView(this, null);
    }

    @Override
    protected void initData() {
        //初始化标题
        mPresenter.initTitle(tvLeft, tvTitle, tvRight);
        setSupportActionBar(appbar);
        recyclerView.addOnScrollListener(mPresenter.getOnScrollChangeListener(appbar));
        //请求数据
        mPresenter.requestAPI();
    }

    @Override
    public void setAdapter(DefaultAdapter adapter) {
        recyclerView.setAdapter(adapter);
        initRecycleView();
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


    @OnClick({R.id.ll_left, R.id.ll_right})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.ll_left:
                //标题左侧
                mPresenter.AppBarLeftClick();
                break;
            case R.id.ll_right:
                //标题右侧
                mPresenter.AppBarRightClick();
                break;
        }
    }

    //销毁
    @Override
    protected void onDestroy() {
        DefaultAdapter.releaseAllHolder(recyclerView);//super.onDestroy()之后会unbind,所有view被置为null,所以必须在之前调用
        super.onDestroy();
    }
}
