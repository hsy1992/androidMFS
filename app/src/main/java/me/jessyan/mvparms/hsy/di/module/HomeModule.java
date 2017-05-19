package me.jessyan.mvparms.hsy.di.module;

import com.jess.arms.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;
import me.jessyan.mvparms.hsy.mvp.contract.HomeContract;
import me.jessyan.mvparms.hsy.mvp.model.HomeModel;

/**
 * Created by haosiyuan on 2017/5/5.
 */
@Module
public class HomeModule {
    private HomeContract.View view;

    /**
     * 构建UserModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     * @param view
     */
    public HomeModule(HomeContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    HomeContract.View provideUserView(){
        return this.view;
    }

    @FragmentScope
    @Provides
    HomeContract.Model provideUserModel(HomeModel model){
        return model;
    }
}
