package me.jessyan.mvparms.hsy.mvp.eventbus;

/**
 * Created by haosiyuan on 2017/5/15.
 * weibo管理取消解绑
 */

public class WeiBoManagerCancleEvent {

    private int position;

    public WeiBoManagerCancleEvent(int position) {
        this.position = position;
    }

    public int getPosition(){
        return position;
    }
}
