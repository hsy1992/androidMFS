package me.jessyan.mvparms.hsy.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;
import me.jessyan.mvparms.hsy.di.module.ChooseRankRunningModule;
import me.jessyan.mvparms.hsy.mvp.ui.activity.ChooseRankRunningActivity;

/**
 * Created by haosiyuan on 2017/5/5.
 */
@ActivityScope
@Component(modules = ChooseRankRunningModule.class,dependencies = AppComponent.class)
public interface ChooseRankRunningComponent {
    void inject(ChooseRankRunningActivity activity);
}
