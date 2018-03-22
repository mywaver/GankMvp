package com.hooray.myapplication.presenter;

import android.os.Handler;

import com.hooray.myapplication.BaseNewBean;
import com.hooray.myapplication.GankNewsListener;
import com.hooray.myapplication.model.GankModel;
import com.hooray.myapplication.view.IMainView;

import java.util.List;

/**
 * Created by ximei on 2018/3/21.
 */

public class MainPresenter {
    private IMainView mainView;
    private GankModel gankModel;
    private Handler handler = new Handler();

    public MainPresenter(IMainView view) {
        this.mainView = view;
        this.gankModel = new GankModel();
    }

    public void getNews() {
        gankModel.getGankNews("http://gank.io/api/day/2018/1/23", new GankNewsListener() {
            @Override
            public void onSuccess(final List<BaseNewBean> baseNewBeen ) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mainView.addNews(baseNewBeen);
                    }
                });

            }

            @Override
            public void onFailure() {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mainView.showFailToast();
                    }
                });
            }
        });
    }
}
