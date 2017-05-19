package me.jessyan.mvparms.hsy.di.module;

import com.jess.arms.di.scope.FragmentScope;

import dagger.Module;
import dagger.Provides;
import me.jessyan.mvparms.hsy.mvp.contract.MeContract;
import me.jessyan.mvparms.hsy.mvp.model.MeModel;

/**
 * Created by jess on 9/4/16 11:10
 * Contact with jess.yan.effort@gmail.com
 */
@Module
public class MeModule {
    private MeContract.View view;

    /**
     * 构建UserModule时,将View的实现类传进来,这样就可以提供View的实现类给presenter
     * @param view
     */
    public MeModule(MeContract.View view) {
        this.view = view;
    }

    @FragmentScope
    @Provides
    MeContract.View provideUserView(){
        return this.view;
    }

    @FragmentScope
    @Provides
    MeContract.Model provideUserModel(MeModel model){
        return model;
    }
}
