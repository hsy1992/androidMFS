package me.jessyan.mvparms.hsy.mvp.model;

import com.jess.arms.di.scope.ActivityScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;

import me.jessyan.mvparms.hsy.mvp.contract.ChooseRankContract;

/**
 * Created by haosiyuan on 2017/5/11.
 * 搜索排行
 */
@ActivityScope
public class ChooseRankModel extends BaseModel implements ChooseRankContract.Model{
    @Inject
    public ChooseRankModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }
}
