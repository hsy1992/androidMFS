package me.jessyan.mvparms.demo.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.FragmentScope;

import dagger.Component;
import me.jessyan.mvparms.demo.di.module.HomeModule;
import me.jessyan.mvparms.demo.di.module.MeModule;
import me.jessyan.mvparms.demo.mvp.ui.fragment.HomeFragment;
import me.jessyan.mvparms.demo.mvp.ui.fragment.MeFragment;

/**
 * Created by haosiyuan on 2017/5/5.
 */
@FragmentScope
@Component(modules = MeModule.class,dependencies = AppComponent.class)
public interface MeComponent {
    void inject(MeFragment meFragment);
}
