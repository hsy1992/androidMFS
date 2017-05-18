package me.jessyan.mvparms.demo.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;
import me.jessyan.mvparms.demo.mvp.contract.ChooseRankContract;
import me.jessyan.mvparms.demo.mvp.model.ChooseRankModel;

/**
 * Created by jess on 9/4/16 11:10
 * Contact with jess.yan.effort@gmail.com
 */
@Module
public class ChooseRankModule {
    private ChooseRankContract.View view;

    /**
     * 构建UserModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     * @param view
     */
    public ChooseRankModule(ChooseRankContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    ChooseRankContract.View provideUserView(){
        return this.view;
    }

    @ActivityScope
    @Provides
    ChooseRankContract.Model provideUserModel(ChooseRankModel model){
        return model;
    }
}
