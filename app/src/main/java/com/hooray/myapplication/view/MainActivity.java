package com.hooray.myapplication.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.hooray.myapplication.BaseNewBean;
import com.hooray.myapplication.GankListAdapter;
import com.hooray.myapplication.presenter.MainPresenter;
import com.hooray.myapplication.R;

import java.util.List;

public class MainActivity extends AppCompatActivity implements IMainView {
    private ListView gank_list;
    private GankListAdapter adapter;
    private MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gank_list = (ListView) findViewById(R.id.gank_list);
        adapter = new GankListAdapter(MainActivity.this);
        gank_list.setAdapter(adapter);
        presenter = new MainPresenter(this);
        presenter.getNews();
    }

    @Override
    public void showFailToast() {
        Toast.makeText(MainActivity.this, "getMessageFailed", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void addNews(List<BaseNewBean> newBeen) {
        Toast.makeText(MainActivity.this, "getMessageSuccess", Toast.LENGTH_SHORT).show();
        adapter.addNews(newBeen);
        adapter.notifyDataSetChanged();
    }
}
