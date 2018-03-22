package com.hooray.myapplication.model;


import android.util.Log;

import com.google.gson.Gson;
import com.google.gson.JsonParseException;
import com.hooray.myapplication.BaseNewBean;
import com.hooray.myapplication.GankBean;
import com.hooray.myapplication.GankNewsListener;
import com.squareup.okhttp.Call;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.util.List;

/**
 * Created by ximei on 2018/3/20.
 */

public class GankModel {
    public void getGankNews(final String url, final GankNewsListener listener) {

        new Thread(new Runnable() {
            @Override
            public void run() {
                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder()
                        .url(url)
                        .build();
                Call call = client.newCall(request);
                try {
                    Response response = call.execute();
                    Gson gson = new Gson();
//                    Log.e("response",response.body().string());
                    GankBean bean = gson.fromJson(response.body().string(), GankBean.class);
                    List<BaseNewBean> baseNewBeen = bean.getResults().getAndroid();
                    listener.onSuccess(baseNewBeen);
                } catch (IOException e) {
                    e.printStackTrace();
                    listener.onFailure();
                }
            }
        }).start();

    }
}
