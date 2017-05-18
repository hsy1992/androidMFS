package me.jessyan.mvparms.demo.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.di.scope.FragmentScope;

import dagger.Component;
import me.jessyan.mvparms.demo.di.module.HomeModule;
import me.jessyan.mvparms.demo.di.module.WeiBoManagerModule;
import me.jessyan.mvparms.demo.mvp.ui.activity.WeiBoManagerActivity;
import me.jessyan.mvparms.demo.mvp.ui.fragment.HomeFragment;

/**
 * Created by haosiyuan on 2017/5/5.
 */
@ActivityScope
@Component(modules = WeiBoManagerModule.class,dependencies = AppComponent.class)
public interface WeiBoManagerComponent {
    void inject(WeiBoManagerActivity weiBoManagerActivity);
}
