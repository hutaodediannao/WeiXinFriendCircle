package com.app.demo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ImgViewHolder extends RecyclerView.ViewHolder {

    private SparseArray<View> mSparseArray;
    private View mContentView;
    private Context mContext;

    public static ImgViewHolder imgViewHolderNewInstance(Context context, ViewGroup parentView, int itemViewLayoutId) {
        View itemView = LayoutInflater.from(context).inflate(itemViewLayoutId, parentView, false);
        ImgViewHolder imgViewHolder = new ImgViewHolder(context, itemView);
        return imgViewHolder;
    }

    private ImgViewHolder(Context context, View itemView) {
        super(itemView);
        this.mContext = context;
        mSparseArray = new SparseArray<>();
        this.mContentView = itemView;
    }

    public  <T> T getView(int viewId) {
        View t = mSparseArray.get(viewId);
        if (t == null) {
            t = mContentView.findViewById(viewId);
            mSparseArray.put(viewId, t);
        }
        return (T) t;
    }

    public ImgViewHolder setTextView(int viewId, String content) {
        TextView tv = getView(viewId);
        tv.setText(content);
        return this;
    }

    public ImgViewHolder setImageView(int viewId, String imgSrcUrl, int width, int height, int listSize) {
        ImageView iv = getView(viewId);
        BitmapUtil.loadImg(mContext, imgSrcUrl, iv, width, height, listSize);
        return this;
    }

    /**
     * 设置图片矩阵展示
     */
    public ImgViewHolder setDesignImgRecyclerView(int viewId, List<String> imgSrcUrlList) {
        DesignImgRecyclerView designImgRecyclerView = getView(viewId);
        designImgRecyclerView.updateUI(imgSrcUrlList);
        return this;
    }

}
