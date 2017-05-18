package me.jessyan.mvparms.demo.mvp.model;

import com.jess.arms.di.scope.FragmentScope;
import com.jess.arms.integration.IRepositoryManager;
import com.jess.arms.mvp.BaseModel;

import javax.inject.Inject;

import me.jessyan.mvparms.demo.mvp.contract.HomeContract;
import me.jessyan.mvparms.demo.mvp.contract.MeContract;

/**
 * Created by haosiyuan on 2017/5/5.
 */
@FragmentScope
public class MeModel extends BaseModel implements MeContract.Model {

    @Inject
    public MeModel(IRepositoryManager repositoryManager) {
        super(repositoryManager);
    }
}
