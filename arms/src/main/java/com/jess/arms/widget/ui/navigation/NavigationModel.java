package com.jess.arms.widget.ui.navigation;


import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by haosiyuan on 2017/5/4.
 * 导航栏model
 */

public class NavigationModel{

    public int direction;
    public int colorNormal;
    public int colorCheck;
    public int textSize;
    public int tabHeight;
    public int tabLineColor;
    public List<TabModel> list = new ArrayList<>();

    public NavigationModel(int direction, int colorNormal, int colorCheck, int textSize, int tabHeight, int tabLineColor, List<TabModel> list) {
        this.direction = direction;
        this.colorNormal = colorNormal;
        this.colorCheck = colorCheck;
        this.textSize = textSize;
        this.tabHeight = tabHeight;
        this.tabLineColor = tabLineColor;
        this.list = list;
    }

    public static class Builder{

        private int direction;
        private int colorNormal;
        private int colorCheck;
        private int textSize;
        private int tabHeight;
        private int tabLineColor;
        private List<TabModel> list = new ArrayList<>();

        public Builder(){
        }

        public Builder setDirection(int direction) {
            this.direction = direction;
            return this;
        }
        public Builder addTab(TabModel tab){
            list.add(tab);
            return this;
        }

        public Builder setColorNormal(int colorNormal) {
            this.colorNormal = colorNormal;
            return this;
        }

        public Builder setColorCheck(int colorCheck) {
            this.colorCheck = colorCheck;
            return this;
        }

        public Builder setTextSize(int textSize) {
            this.textSize = textSize;
            return this;
        }

        public Builder setTabHeight(int tabHeight) {
            this.tabHeight = tabHeight;
            return this;
        }

        public NavigationModel build(){
            return new NavigationModel(direction,colorNormal,colorCheck,textSize,tabHeight,tabLineColor,list);
        }
    }


}
