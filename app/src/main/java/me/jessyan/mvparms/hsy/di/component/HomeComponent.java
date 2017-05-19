package me.jessyan.mvparms.hsy.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.FragmentScope;

import dagger.Component;
import me.jessyan.mvparms.hsy.di.module.HomeModule;
import me.jessyan.mvparms.hsy.mvp.ui.fragment.HomeFragment;

/**
 * Created by haosiyuan on 2017/5/5.
 */
@FragmentScope
@Component(modules = HomeModule.class,dependencies = AppComponent.class)
public interface HomeComponent {
    void inject(HomeFragment homeFragment);
}
