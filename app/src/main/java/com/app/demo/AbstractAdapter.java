package com.app.demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

public abstract class AbstractAdapter<T> extends RecyclerView.Adapter<ImgViewHolder> {

    private List<T> mList;
    private Context mContext;

    public AbstractAdapter(List<T> mList, Context mContext) {
        this.mList = mList;
        this.mContext = mContext;
    }

    @Override
    public ImgViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return ImgViewHolder.imgViewHolderNewInstance(mContext, parent, getItemLayout());
    }

    @Override
    public void onBindViewHolder(ImgViewHolder holder, int position) {
        bindHolder(holder, position, mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    abstract void bindHolder(ImgViewHolder holder, int position, T t);

    abstract int getItemLayout();
}
