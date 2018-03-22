package com.hooray.myapplication;

import java.util.List;

/**
 * Created by ximei on 2018/3/20.
 */

public interface GankNewsListener {
    void onSuccess(List<BaseNewBean> baseNewBeen );

    void onFailure();
}
