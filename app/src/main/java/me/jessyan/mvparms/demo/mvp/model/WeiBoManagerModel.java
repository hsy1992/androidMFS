package me.jessyan.mvparms.demo.mvp.model;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;

import me.jessyan.mvparms.demo.mvp.contract.WeiBoManagerContract;

@ActivityScope
public class WeiBoManagerModel extends BaseModel implements WeiBoManagerContract.Model {

    @Inject
    public WeiBoManagerModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }


}
