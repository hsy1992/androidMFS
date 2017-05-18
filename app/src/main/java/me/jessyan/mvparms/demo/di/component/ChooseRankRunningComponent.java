package me.jessyan.mvparms.demo.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;
import me.jessyan.mvparms.demo.di.module.ChooseRankModule;
import me.jessyan.mvparms.demo.di.module.ChooseRankRunningModule;
import me.jessyan.mvparms.demo.mvp.ui.activity.ChooseRankActivity;
import me.jessyan.mvparms.demo.mvp.ui.activity.ChooseRankRunningActivity;

/**
 * Created by haosiyuan on 2017/5/5.
 */
@ActivityScope
@Component(modules = ChooseRankRunningModule.class,dependencies = AppComponent.class)
public interface ChooseRankRunningComponent {
    void inject(ChooseRankRunningActivity activity);
}
