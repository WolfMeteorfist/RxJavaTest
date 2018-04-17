package com.example.administrator.rxjavatest.model;

import com.example.administrator.rxjavatest.viewModel.Today;

/**
 * @author  月愁
 */
public interface IMainModel {

    void requestData(String key, String date, OnRequestListener listener);

    interface OnRequestListener {

        void onReceive(Today today);

        void onSucceed();

        void onFailed(String e);
    }
}
