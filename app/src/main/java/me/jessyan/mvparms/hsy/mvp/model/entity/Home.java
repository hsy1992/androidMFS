package me.jessyan.mvparms.hsy.mvp.model.entity;

/**
 * Created by haosiyuan on 2017/5/10.
 * 首页
 */

public class Home {

    private String RankName;
    private String Rank;
    private String FireValue;

    public Home(String rankName, String rank, String fireValue) {
        RankName = rankName;
        Rank = rank;
        FireValue = fireValue;
    }

    public String getRankName() {
        return RankName;
    }

    public void setRankName(String rankName) {
        RankName = rankName;
    }

    public String getRank() {
        return Rank;
    }

    public void setRank(String rank) {
        Rank = rank;
    }

    public String getFireValue() {
        return FireValue;
    }

    public void setFireValue(String fireValue) {
        FireValue = fireValue;
    }
}
