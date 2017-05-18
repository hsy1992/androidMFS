package me.jessyan.mvparms.demo.di.module;

import com.jess.arms.di.scope.ActivityScope;

import dagger.Module;
import dagger.Provides;
import me.jessyan.mvparms.demo.mvp.contract.ChooseRankContract;
import me.jessyan.mvparms.demo.mvp.contract.ChooseRankRunningContract;
import me.jessyan.mvparms.demo.mvp.model.ChooseRankModel;
import me.jessyan.mvparms.demo.mvp.model.ChooseRankRunningModel;

/**
 * Created by jess on 9/4/16 11:10
 * Contact with jess.yan.effort@gmail.com
 */
@Module
public class ChooseRankRunningModule {

    private ChooseRankRunningContract.View view;

    /**
     * 构建UserModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     * @param view
     */
    public ChooseRankRunningModule(ChooseRankRunningContract.View view) {
        this.view = view;
    }

    @ActivityScope
    @Provides
    ChooseRankRunningContract.View provideUserView(){
        return this.view;
    }

    @ActivityScope
    @Provides
    ChooseRankRunningContract.Model provideUserModel(ChooseRankRunningModel model){
        return model;
    }
}
