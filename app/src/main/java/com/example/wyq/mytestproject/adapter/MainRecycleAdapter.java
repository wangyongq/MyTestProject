package com.example.wyq.mytestproject.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wyq.mytestproject.R;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by wyq on 2018/6/6.
 */

public class MainRecycleAdapter extends RecyclerView.Adapter {

    private Context context;
    private int layoutId ;
    private List<String> list;
    private OnMainRecycleItemClickListener mMainRecycleItemClickListener = null;

    public MainRecycleAdapter(Context context,int layoutId,List<String> list){
        this.context = context;
        this.layoutId = layoutId;
        this.list = list;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(context).inflate(this.layoutId,parent,false));
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        ((ViewHolder)holder).item_adapter_main.setText(list.get(position));
    }

    @Override
    public int getItemCount() {
        return this.list.size()==0?0:this.list.size();
    }

     class ViewHolder extends RecyclerView.ViewHolder {

         private final TextView item_adapter_main;

         public ViewHolder(View itemView) {
             super(itemView);
             item_adapter_main = itemView.findViewById(R.id.item_adapter_main);
             itemView.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View v) {
                     mMainRecycleItemClickListener.itemClick(item_adapter_main.getText().toString());
                 }
             });
         }
     }

    public interface OnMainRecycleItemClickListener{
        void itemClick(String content);
    }

    public void setMainRecycleItemClickListener(OnMainRecycleItemClickListener mMainRecycleItemClickListener){
        this.mMainRecycleItemClickListener = mMainRecycleItemClickListener;
    }
}
