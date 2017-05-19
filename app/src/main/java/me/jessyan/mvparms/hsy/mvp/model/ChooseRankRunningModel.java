package me.jessyan.mvparms.hsy.mvp.model;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;

import me.jessyan.mvparms.hsy.mvp.contract.ChooseRankRunningContract;

/**
 * Created by haosiyuan on 2017/5/11.
 * 搜索排行
 */
@ActivityScope
public class ChooseRankRunningModel extends BaseModel implements ChooseRankRunningContract.Model{
    @Inject
    public ChooseRankRunningModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }
}
