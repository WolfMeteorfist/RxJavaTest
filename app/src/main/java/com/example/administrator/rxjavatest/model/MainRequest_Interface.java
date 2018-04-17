package com.example.administrator.rxjavatest.model;

import com.example.administrator.rxjavatest.viewModel.Today;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface MainRequest_Interface {

    @FormUrlEncoded
    @POST("queryEvent.php")
    Observable<Today> getData(@FieldMap Map<String, Object> map);

}
