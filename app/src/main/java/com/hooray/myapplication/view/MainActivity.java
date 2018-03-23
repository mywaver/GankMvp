package com.hooray.myapplication.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.CharacterStyle;
import android.util.Log;
import android.widget.ListView;
import android.widget.Toast;

import com.hooray.myapplication.BaseNewBean;
import com.hooray.myapplication.GankListAdapter;
import com.hooray.myapplication.presenter.MainPresenter;
import com.hooray.myapplication.R;

import java.util.ArrayList;
import java.util.HashMap;
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

    int count = 0;

    private int cal(int n) {

        int x = 0;
        int tmp1 = 0;
        int tmp2 = 0;

        if (n == 0) {
            tmp1 = 1;
            return tmp1;
        } else if (n == 1) {
            tmp2 = 1;
            return tmp2;
        } else if (n >= 2) {
//            return cal(n - 2) + cal(n - 1);

            for (int i = 0; i <= n; i++) {
                count++;
                if (i == 0) {
                    tmp1 = 1;

                } else if (i == 1) {
                    tmp2 = 1;
                } else {
                    x = tmp1 + tmp2;
                    tmp1 = tmp2;
                    tmp2 = x;
                }
            }
            return x;
        }
        return -1;
    }

    private String range(String str) {
        ArrayList<Character> characters = new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < 123 && str.charAt(i) > 64) {
                characters.add(str.charAt(i));
            }
        }
        if (characters.size() < 1) {
            return "";
        }


        HashMap<Character, Integer> hashMap = new HashMap<>();

        for (int m = 0; m < characters.size(); m++) {
            int most = 1;
            if (hashMap.get(characters.get(m)) != null) {
                continue;
            }
            for (int j = m + 1; j < characters.size(); j++) {
                if (characters.get(j) == characters.get(m)) {
                    most++;
                }
            }
            hashMap.put(characters.get(m), most);
        }

        class charval {
            char cvalue;
            int ccount;
        }

        ArrayList<charval> charval = new ArrayList<>();

        for (Character character : hashMap.keySet()) {
            charval c = new charval();
            c.ccount = hashMap.get(character);
            c.cvalue = character;
            charval.add(c);
            Log.e("charaters", String.valueOf(character) + " size " + hashMap.get(character));
        }
        charval temp;

        for (int i = 0; i < hashMap.size() - 1; i++) {
            for (int j = i + 1; j < hashMap.size(); j++) {
                if (charval.get(i).ccount < charval.get(j).ccount || (charval.get(i).ccount == charval.get(j).ccount) && charval.get(i).cvalue < charval.get(j).cvalue) {
                    temp = charval.get(i);
                    charval.set(i, charval.get(j));
                    charval.set(j, temp);
                }
            }
        }
        for (int i = 0; i < charval.size(); i++) {
            Log.e("newrange", String.valueOf(charval.get(i).cvalue) + " " + charval.get(i).ccount);
        }

        return "";
    }

}
