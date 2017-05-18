package me.jessyan.mvparms.demo.di.module.login;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.mvp.IModel;
import com.jess.arms.mvp.IView;

import dagger.Module;
import dagger.Provides;
import me.jessyan.mvparms.demo.mvp.contract.UserContract;
import me.jessyan.mvparms.demo.mvp.model.UserModel;
import me.jessyan.mvparms.demo.mvp.model.login.WelcomeModel;

/**
 * Created by jess on 9/4/16 11:10
 * Contact with jess.yan.effort@gmail.com
 */
@Module
public class WelcomeModule {
    private IView view;

    /**
     * 构建WelcomeModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     * @param view
     */
    public WelcomeModule(IView view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    IView provideWelcomeView(){
        return this.view;
    }

    @ActivityScope
    @Provides
    IModel provideWelcomeModel(WelcomeModel model){
        return model;
    }
}
