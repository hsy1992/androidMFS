package me.jessyan.mvparms.demo.mvp.listener;

import android.support.v7.widget.RecyclerView;

/**
 * Created by haosiyuan on 2017/5/17
 * recyclerview 的滑动监听
 */

public abstract class RecyclerViewOnScroll extends RecyclerView.OnScrollListener{

    @Override
    public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
        super.onScrolled(recyclerView, dx, dy);
        if (!recyclerView.canScrollVertically(-1)) {
            onUp();
        } else {
            onDown();
        }
    }
    protected abstract void onDown();
    protected abstract void onUp();
}
