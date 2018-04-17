package com.example.administrator.rxjavatest.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.administrator.rxjavatest.R;
import com.example.administrator.rxjavatest.bean.Food;
import com.example.administrator.rxjavatest.presenter.MainPresenter;
import com.example.administrator.rxjavatest.viewModel.Today;
import com.google.gson.Gson;

public class ScrollingActivity extends AppCompatActivity implements IMainView {

    MainPresenter presenter = new MainPresenter(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        presenter.requestData();
    }

    private void initData() {
        Gson gson = new Gson();
        Food food = new Food("鸡儿", "贼大", "30");
        String jsonFood = gson.toJson(food);
        System.out.println("jsonFood: " + jsonFood + "\n");

        String json = "{\"name\":\"chick baby\",\"id\":\"small guy\", \"price\":\"0\"}";
        Food food1 = gson.fromJson(json, Food.class);
        System.out.println("food1: " + food1 + "\n");
    }

    @Override
    public void updateData(Today today) {

    }

    @Override
    public void showDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public String getKey() {
        return null;
    }

    @Override
    public String getId() {
        return null;
    }

    @Override
    public String getDate() {
        return null;
    }
}
