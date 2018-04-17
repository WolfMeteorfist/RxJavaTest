package com.example.administrator.rxjavatest.view;

import com.example.administrator.rxjavatest.viewModel.Today;

public interface IMainView {

    void updateData(Today today);

    void showDialog();

    void dismissDialog();

    String getKey();

    String getId();

    String getDate();

}
