package me.jessyan.mvparms.hsy.di.component.login;

import com.jess.arms.di.component.AppComponent;
import com.jess.arms.di.scope.ActivityScope;

import dagger.Component;
import me.jessyan.mvparms.hsy.di.module.login.WelcomeModule;
import me.jessyan.mvparms.hsy.mvp.ui.activity.login.WelcomeActivity;

/**
 * Created by jess on 9/4/16 11:17
 * Contact with jess.yan.effort@gmail.com
 */
@ActivityScope
@Component(modules = WelcomeModule.class,dependencies = AppComponent.class)
public interface WelcomeComponent {
    void inject(WelcomeActivity activity);
}
