package me.jessyan.mvparms.demo.mvp.ui.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.AppBarLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jess.arms.base.BaseFragment;
import com.jess.arms.base.DefaultAdapter;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.UiUtils;
import com.jess.arms.widget.autolayout.AutoAppBarLayout;
import com.jess.arms.widget.autolayout.AutoToolbar;

import butterknife.BindView;
import de.hdodenhof.circleimageview.CircleImageView;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.di.component.DaggerHomeComponent;
import me.jessyan.mvparms.demo.di.module.HomeModule;
import me.jessyan.mvparms.demo.mvp.contract.HomeContract;
import me.jessyan.mvparms.demo.mvp.listener.AppBarStateChangeListener;
import me.jessyan.mvparms.demo.mvp.presenter.HomePresenter;
import me.jessyan.mvparms.demo.mvp.ui.adapter.HomeAdapter;

/**
 * Created by haosiyuan on 2017/5/5.
 * 主页
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements HomeContract.View {

    @BindView(R.id.img_bg)
    ImageView imgBg;
    @BindView(R.id.img_head)
    CircleImageView imgHead;
    @BindView(R.id.toolbar)
    AutoToolbar toolbar;
    @BindView(R.id.appbar)
    AutoAppBarLayout appbar;
    @BindView(R.id.tv_title)
    TextView tvTitle;
    @BindView(R.id.tv_name)
    TextView tvName;
    @BindView(R.id.tv_value)
    TextView tvValue;
    @BindView(R.id.tv_fans)
    TextView tvFans;
    @BindView(R.id.img_msg)
    ImageView imgMsg;
    @BindView(R.id.img_head_small)
    CircleImageView imgHeadSmall;
    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;
    @BindView(R.id.scrollView)
    NestedScrollView scrollView;

    @Override
    protected void setupFragmentComponent(AppComponent appComponent) {
        DaggerHomeComponent
                .builder()
                .appComponent(appComponent)
                .homeModule(new HomeModule(this))
                .build()
                .inject(this);
    }


    @Override
    protected View initView(LayoutInflater inflater, ViewGroup container) {
        return inflater.inflate(R.layout.fragment_home, null);
    }

    @Override
    protected void initData() {
        mPresenter.requestApi();
        //给Activity设置标题
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
    }

    //设置标题
    @Override
    public void setToolBar(String title) {
        tvTitle.setText(title);
        //设置appbar监听
        appbar.addOnOffsetChangedListener(new AppBarStateChangeListener() {
            @Override
            public void onStateChanged(AppBarLayout appBarLayout, State state) {
                if (state == State.EXPANDED) {
                    //展开状态
                    tvTitle.setVisibility(View.GONE);
                } else if (state == State.COLLAPSED) {
                    //折叠状态
                    tvTitle.setVisibility(View.VISIBLE);
                } else {
                    //中间状态
                    tvTitle.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    public void setAdapter(HomeAdapter adapter) {
        recyclerView.setAdapter(adapter);
        initRecycleView();
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
    }

    /**
     * 初始化RecycleView
     */
    private void initRecycleView() {
        UiUtils.configRecycleView(recyclerView, new LinearLayoutManager(mActivity.getApplicationContext()));
    }

    @Override
    public void onDestroy() {
        DefaultAdapter.releaseAllHolder(recyclerView);//super.onDestroy()之后会unbind,所有view被置为null,所以必须在之前调用
        super.onDestroy();
    }

}
