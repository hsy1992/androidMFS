package me.jessyan.mvparms.hsy.di.component;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.FragmentScope;

import dagger.Component;
import me.jessyan.mvparms.hsy.di.module.MeModule;
import me.jessyan.mvparms.hsy.mvp.ui.fragment.MeFragment;

/**
 * Created by haosiyuan on 2017/5/5.
 */
@FragmentScope
@Component(modules = MeModule.class,dependencies = AppComponent.class)
public interface MeComponent {
    void inject(MeFragment meFragment);
}
