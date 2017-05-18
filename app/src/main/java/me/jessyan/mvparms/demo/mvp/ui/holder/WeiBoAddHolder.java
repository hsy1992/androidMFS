package me.jessyan.mvparms.demo.mvp.ui.holder;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.jess.arms.base.BaseHolder;

import org.simple.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import me.jessyan.mvparms.demo.R;
import me.jessyan.mvparms.demo.app.utils.ViewSizeUtil;
import me.jessyan.mvparms.demo.mvp.eventbus.ChooseRankChangeEvent;
import me.jessyan.mvparms.demo.mvp.eventbus.WeiBoManagerAddEvent;
import me.jessyan.mvparms.demo.mvp.model.entity.ChooseRank;
import me.jessyan.mvparms.demo.mvp.model.entity.WeiBoManager;
import me.jessyan.mvparms.demo.mvp.ui.contact.ChooseRankSelectView;
import me.jessyan.mvparms.demo.mvp.ui.dialog.WeiBoAddAccountDialog;

/**
 * 微博添加账号
 */
public class WeiBoAddHolder extends BaseHolder<WeiBoManager> {

    private Context mContext;
    private View itemView;
    private List<WeiBoManager> mInfos;

    @BindView(R.id.ll_addweibo)
    LinearLayout llAddWeiBo;

    public WeiBoAddHolder(View itemView, List<WeiBoManager> mInfos) {
        super(itemView);
        this.itemView = itemView;
        this.mInfos = mInfos;
    }

    @Override
    public void setData(WeiBoManager data, int position) {
        if (mInfos.size() == 0){
            ViewSizeUtil.AdaptationMargin(itemView,0,30,0,0);
        }

        itemView.setOnClickListener(v -> {
            Log.e(TAG,">>>>>>>>>>>>");
            EventBus.getDefault().post(new WeiBoManagerAddEvent());
        });
    }

    @Override
    protected void onRelease() {
        mContext = null;
        itemView = null;
    }
}
