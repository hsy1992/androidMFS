package me.jessyan.mvparms.hsy.mvp.eventbus;

import java.util.List;

import me.jessyan.mvparms.hsy.mvp.model.entity.ChooseRank;

/**
 * Created by haosiyuan on 2017/5/14.
 * 净化适配器选择
 */

public class ChooseRankChangeEvent {

    private List<ChooseRank> chooseList;

    public ChooseRankChangeEvent(List<ChooseRank> chooseList) {
        this.chooseList = chooseList;
    }

    public int getChooseNum(){
        int chooseNum = 0;
        for (int i = 0; i < chooseList.size(); i++) {
            if (chooseList.get(i).isCheck()){
                chooseNum++;
            }
        }
        return chooseNum;
    }

}
