package me.jessyan.mvparms.hsy.mvp.model.login;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;
import com.jess.arms.mvp.IModel;

import javax.inject.Inject;

/**
 * Created by haosiyuan on 2017/5/3.
 */
@ActivityScope
public class WelcomeModel extends BaseModel implements IModel{

    @Inject
    public WelcomeModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }
}
