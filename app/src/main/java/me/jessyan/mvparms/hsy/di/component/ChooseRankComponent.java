package me.jessyan.mvparms.hsy.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;
import me.jessyan.mvparms.hsy.di.module.ChooseRankModule;
import me.jessyan.mvparms.hsy.mvp.ui.activity.ChooseRankActivity;

/**
 * Created by haosiyuan on 2017/5/5.
 */
@ActivityScope
@Component(modules = ChooseRankModule.class,dependencies = AppComponent.class)
public interface ChooseRankComponent {
    void inject(ChooseRankActivity activity);
}
