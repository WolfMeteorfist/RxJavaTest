package com.example.administrator.rxjavatest.model;

import com.example.administrator.rxjavatest.utils.Url;
import com.example.administrator.rxjavatest.viewModel.Today;

import org.reactivestreams.Subscriber;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainModel implements IMainModel {

    private Retrofit mRetrofit;

    @Override
    public void requestData(String key, String date, final OnRequestListener listener) {

        mRetrofit = new Retrofit.Builder()
                .baseUrl(Url.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();

        Map<String, Object> map = new HashMap<>(2);
        map.put("key", "fb931e88c84f2ae93fcefbfb84ee213e");
        map.put("date", "1/1");

        MainRequest_Interface request = mRetrofit.create(MainRequest_Interface.class);
        request.getData(map)
                .subscribeOn(Schedulers.io())
                .unsubscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Today>() {
                    Disposable mDisposable;

                    @Override
                    public void onSubscribe(Disposable d) {
                        mDisposable = d;
                    }

                    @Override
                    public void onNext(Today today) {
                        listener.onReceive(today);
                    }

                    @Override
                    public void onError(Throwable e) {
                        mDisposable.dispose();
                        listener.onFailed(e.getMessage());
                    }

                    @Override
                    public void onComplete() {
                        mDisposable.dispose();
                        listener.onSucceed();
                    }
                });
    }

}
