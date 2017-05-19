package me.jessyan.mvparms.hsy.mvp.ui.holder;

import android.content.Context;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.jess.arms.base.BaseHolder;

import org.simple.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import me.jessyan.mvparms.hsy.R;
import me.jessyan.mvparms.hsy.app.utils.ViewSizeUtil;
import me.jessyan.mvparms.hsy.mvp.eventbus.WeiBoManagerAddEvent;
import me.jessyan.mvparms.hsy.mvp.model.entity.WeiBoManager;

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
