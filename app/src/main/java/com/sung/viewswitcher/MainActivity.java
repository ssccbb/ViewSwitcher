package com.sung.viewswitcher;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.sung.viewswitcher.image.IamgeFragment;
import com.sung.viewswitcher.text.TextFragment;
import com.sung.viewswitcher.view.ViewFragment;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainAdapter.onItemClickListener{
    private RecyclerView mlist;
    private MainAdapter mAdapter;
    private List<String> strings = new ArrayList<>();
    private String[] str = {
            "Image Switcher",
            "Text Switcher",
            "View Switcher" };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        addData();
    }

    private void initView(){
        mlist = (RecyclerView) findViewById(R.id.rc_list);
        mlist.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        mAdapter = new MainAdapter(strings, MainActivity.this);
        mAdapter.addItemClickListener(this);
        mlist.setAdapter(mAdapter);
    }

    private void addData(){
        for (int i = 0; i < str.length; i++) {
            strings.add(str[i]);
        }
        Log.e("addData", "addData: "+strings.toString());
        mAdapter.addData(strings,true);
    }

    @Override
    public void onItemClick(String string, int position) {
        Intent next = new Intent(MainActivity.this, DemoActivity.class);
        if (string.equals(str[0])){
            next.putExtra(DemoActivity.GO_TO, IamgeFragment.TAG);
        }else if (string.equals(str[1])){
            next.putExtra(DemoActivity.GO_TO, TextFragment.TAG);
        }else if (string.equals(str[2])){
            next.putExtra(DemoActivity.GO_TO, ViewFragment.TAG);
        }
        startActivity(next);
    }
}
