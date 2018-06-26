package com.example.wyq.mytestproject.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;

import com.alibaba.fastjson.JSON;
import com.example.wyq.mytestproject.R;
import com.example.wyq.mytestproject.adapter.MainRecycleAdapter;
import com.example.wyq.mytestproject.beans.MainItemInfo;
import com.example.wyq.mytestproject.retrofit.ReProFitActivity;
import com.example.wyq.mytestproject.utils.CommenUtils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView main_recycle;
    private List<MainItemInfo> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }
    //初始化
    private void initView() {
        main_recycle = (RecyclerView) this.findViewById(R.id.main_recycle);
    }
    //初始化数据
    private void initData(){

        String itemMsg = CommenUtils.getMainItemInfo(this);
        if (!TextUtils.isEmpty(itemMsg)){
            List<MainItemInfo> mainItemInfoList =  JSON.parseArray(itemMsg, MainItemInfo.class);
            list.addAll(mainItemInfoList);
        }else {
            list = new ArrayList<>();
        }

        MainRecycleAdapter adapter = new MainRecycleAdapter(this,R.layout.adapter_main_layout,list);
        //添加分割线
        main_recycle.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        main_recycle.setLayoutManager(manager);
        main_recycle.setAdapter(adapter);

        //处理条目点击事件
        adapter.setMainRecycleItemClickListener(new MainRecycleAdapter.OnMainRecycleItemClickListener() {
            @Override
            public void itemClick(MainItemInfo mainItemInfo) {
                if (mainItemInfo.getId().equals("0")){
                    //跳转到bufferknife

                }else if (mainItemInfo.getId().equals("1")){
                    //跳转到retrofit
                    Intent intent = new Intent(MainActivity.this, ReProFitActivity.class);
                    startActivity(intent);
                }
            }
        });
    }
}
