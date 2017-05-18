package me.jessyan.mvparms.demo.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;
import me.jessyan.mvparms.demo.mvp.contract.MainContract;
import me.jessyan.mvparms.demo.mvp.contract.WeiBoManagerContract;
import me.jessyan.mvparms.demo.mvp.model.MainModel;
import me.jessyan.mvparms.demo.mvp.model.WeiBoManagerModel;

/**
 * Created by jess on 9/4/16 11:10
 * Contact with jess.yan.effort@gmail.com
 * 微博账号管理
 */
@Module
public class WeiBoManagerModule {

    private WeiBoManagerContract.View view;

    /**
     * 构建UserModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     * @param view
     */
    public WeiBoManagerModule(WeiBoManagerContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    WeiBoManagerContract.View provideUserView(){
        return this.view;
    }

    @ActivityScope
    @Provides
    WeiBoManagerContract.Model provideUserModel(WeiBoManagerModel model){
        return model;
    }
}
