package me.jessyan.mvparms.demo.mvp.ui.holder;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jakewharton.rxbinding.widget.RxTextView;
import com.jess.arms.base.App;
import com.jess.arms.base.BaseHolder;
import com.jess.arms.di.component.AppComponent;
import com.jess.arms.utils.UiUtils;
import com.jess.arms.widget.imageloader.ImageLoader;
import com.jess.arms.widget.imageloader.glide.GlideImageConfig;

import java.util.List;

import butterknife.BindView;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.mvp.model.entity.Home;
import me.jessyan.mvparms.demo.mvp.model.entity.User;
import me.jessyan.mvparms.demo.mvp.ui.activity.ChooseRankActivity;
import me.jessyan.mvparms.demo.mvp.ui.activity.ChooseRankRunningActivity;
import rx.Observable;

/**
 * Created by jess on 9/4/16 12:56
 * Contact with jess.yan.effort@gmail.com
 * 首页头部
 */
public class HomeHeadHolder extends BaseHolder<Home> {

    @BindView(R.id.tv_start)
    TextView tvStart;
    private Context mContext;
    private Intent intent;

    public HomeHeadHolder(View itemView,Context mContext) {
        super(itemView);
        this.mContext = mContext;
    }

    @Override
    public void setData(Home data, int position) {
        //净化跳页
        tvStart.setOnClickListener(v -> {
            intent = new Intent(mContext, ChooseRankRunningActivity.class);
            UiUtils.startActivity(intent);
        });
    }


    @Override
    protected void onRelease() {
        mContext = null;
        intent = null;
    }
}
