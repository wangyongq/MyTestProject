package com.example.wyq.mytestproject.retrofit;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.TextSwitcher;
import android.widget.TextView;

import com.example.wyq.mytestproject.R;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by wyq on 2018/6/6.
 */

public class ReProFitActivity extends Activity {

    private TextView tv_net_body;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reprofit);
        initView();
        initData();
    }

    private void initView() {
        tv_net_body = (TextView) this.findViewById(R.id.tv_net_body);
    }

    public void initData(){
        HttpHelper.getReTroFitData(new HttpHelper.DataCabackListener() {
            @Override
            public void calback(String response) {
                tv_net_body.setText(response);
            }
        });
    }
}
