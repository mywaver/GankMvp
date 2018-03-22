package com.hooray.myapplication.view;

import com.hooray.myapplication.BaseNewBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ximei on 2018/3/20.
 */

public interface IMainView {
    void showFailToast();

    void addNews(List<BaseNewBean> android);
}
