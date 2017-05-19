package me.jessyan.mvparms.hsy.mvp.ui.holder;

import android.content.Context;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.jess.arms.base.BaseHolder;

import org.simple.eventbus.EventBus;

import java.util.List;

import butterknife.BindView;
import me.jessyan.mvparms.hsy.R;
import me.jessyan.mvparms.hsy.app.utils.ViewSizeUtil;
import me.jessyan.mvparms.hsy.mvp.eventbus.WeiBoManagerCancleEvent;
import me.jessyan.mvparms.hsy.mvp.model.entity.WeiBoManager;

/**
 * 微博账号
 */
public class WeiBoItemHolder extends BaseHolder<WeiBoManager> {

    private Context mContext;
    private View itemView;
    private List<WeiBoManager> mInfos;
    @BindView(R.id.tv_account)
    TextView tvAccount;
    @BindView(R.id.tv_jiebang)
    TextView tvJiebang;
    @BindView(R.id.ll_weiboitem)
    LinearLayout llWeiboItem;

    public WeiBoItemHolder(View itemView, List<WeiBoManager> mInfos) {
        super(itemView);
        this.itemView = itemView;
        this.mInfos = mInfos;
    }

    @Override
    public void setData(WeiBoManager data, int position) {

        if (position == 0){
            ViewSizeUtil.AdaptationMargin(itemView,0,30,0,30);
        }

        tvAccount.setText(data.getAccount());
        tvJiebang.setOnClickListener(v -> {
            EventBus.getDefault().post(new WeiBoManagerCancleEvent(position));
        });
    }


    @Override
    protected void onRelease() {
        mContext = null;
    }
}
