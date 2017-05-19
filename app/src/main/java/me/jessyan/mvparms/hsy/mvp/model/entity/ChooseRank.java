package me.jessyan.mvparms.hsy.mvp.model.entity;

/**
 * Created by haosiyuan on 2017/5/14.
 * 净化
 */

public class ChooseRank {

    private String RankName;
    private String RankHistory;
    private String RankNow;
    private String RankHistoryMingCi;
    private String RankNowMingCi;
    private String Fire;
    private boolean isCheck;

    public ChooseRank(boolean isCheck) {
        this.isCheck = isCheck;
    }

    public boolean isCheck() {
        return isCheck;
    }

    public void setCheck(boolean check) {
        isCheck = check;
    }
}
