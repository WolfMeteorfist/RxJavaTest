package com.example.administrator.rxjavatest.presenter;

import com.example.administrator.rxjavatest.model.IMainModel;
import com.example.administrator.rxjavatest.model.MainModel;
import com.example.administrator.rxjavatest.view.IMainView;
import com.example.administrator.rxjavatest.viewModel.Today;

/**
 * @author 大神愁
 */
public class MainPresenter implements IMainPresenter {

    private IMainView mMainView;
    private MainModel mModel;

    public MainPresenter(IMainView mainView) {
        mMainView = mainView;
        mModel = new MainModel();
    }

    @Override
    public void requestData() {
        mModel.requestData(mMainView.getKey(), mMainView.getId(), new IMainModel.OnRequestListener() {
            @Override
            public void onReceive(Today today) {
                mMainView.updateData(today);
            }

            @Override
            public void onSucceed() {
                mMainView.dismissDialog();
            }

            @Override
            public void onFailed(String e) {
                mMainView.dismissDialog();
            }
        });
    }

    @Override
    public void clickItem() {

    }
}
