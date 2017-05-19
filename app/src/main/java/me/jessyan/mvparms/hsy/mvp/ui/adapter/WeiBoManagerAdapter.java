package me.jessyan.mvparms.hsy.mvp.ui.adapter;

import android.view.View;

import com.jess.arms.base.BaseHolder;
import com.jess.arms.base.DefaultAdapter;

import java.util.List;

import me.jessyan.mvparms.hsy.R;
import me.jessyan.mvparms.hsy.mvp.model.entity.WeiBoManager;
import me.jessyan.mvparms.hsy.mvp.ui.holder.WeiBoAddHolder;
import me.jessyan.mvparms.hsy.mvp.ui.holder.WeiBoItemHolder;

/**
 * Created by jess on 9/4/16 12:57
 * Contact with jess.yan.effort@gmail.com
 * weibo管理适配器
 */
public class WeiBoManagerAdapter extends DefaultAdapter<WeiBoManager> {

    private int WEIBOACCOUNTADD = 0;
    private int WEIBOACCOUNTITEM = 1;

    public WeiBoManagerAdapter(List<WeiBoManager> infos) {
        super(infos);
    }

    @Override
    public BaseHolder<WeiBoManager> getHolder(View v, int viewType) {
        if (viewType == WEIBOACCOUNTADD) {
            return new WeiBoAddHolder(v, mInfos);
        }
        return new WeiBoItemHolder(v, mInfos);
    }

    @Override
    public int getLayoutId(int viewType) {
        if (viewType == WEIBOACCOUNTADD) {
            return R.layout.recycle_weibomanager_add;
        }
        return R.layout.recycle_weibomanager_item;
    }

    @Override
    public int getItemCount() {
        return super.getItemCount() + 1;
    }

    @Override
    public int getItemViewType(int position) {
        if (position == mInfos.size()) {
            return WEIBOACCOUNTADD;
        }
        return WEIBOACCOUNTITEM;
    }

    //重构
    @Override
    public void onBindViewHolder(BaseHolder<WeiBoManager> holder, int position) {
        if (position != mInfos.size()){
            holder.setData(mInfos.get(position), position);
        }else {
            holder.setData(null, position);

        }
    }
}
