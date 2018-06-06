package com.example.wyq.mytestproject.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.wyq.mytestproject.R;
import com.example.wyq.mytestproject.adapter.MainRecycleAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView main_recycle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }
    //初始化
    private void initView() {
        main_recycle = this.findViewById(R.id.main_recycle);
    }
    //初始化数据
    private void initData(){
        List<String> list = new ArrayList<>();
        for (int i=0;i<1;i++){
            list.add("retrofit测试");
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
            public void itemClick(String content) {

            }
        });
    }
}
