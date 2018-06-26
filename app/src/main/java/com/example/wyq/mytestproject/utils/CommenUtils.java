package com.example.wyq.mytestproject.utils;

import android.content.Context;
import android.content.res.AssetManager;

import com.example.wyq.mytestproject.beans.MainItemInfo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.List;

/**
 * Created by wyq on 2018/6/22.
 */

public class CommenUtils {

    //获取assets下面的item.json文件的内容
    public static String getMainItemInfo(Context context){
        StringBuffer stringBuffer = new StringBuffer();
        AssetManager assets = context.getAssets();
        try {
            InputStream open = assets.open("item.json");
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(open));
            String line;
            while ((line = bufferedReader.readLine())!=null){
                stringBuffer.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return stringBuffer.toString();
    }
}
