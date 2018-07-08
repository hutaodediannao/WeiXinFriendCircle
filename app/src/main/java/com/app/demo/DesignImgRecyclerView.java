package com.app.demo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;

import java.util.List;

public class DesignImgRecyclerView extends RecyclerView {

    private AbstractAdapter imgAdapter;
    private List<String> mList;
    private GridLayoutManager gridLayoutManager;

    public DesignImgRecyclerView(@NonNull Context context) {
        this(context, null);
    }

    public DesignImgRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView() {
        gridLayoutManager = new GridLayoutManager(getContext(), 3);
        this.setLayoutManager(gridLayoutManager);
    }

    public void updateUI(List<String> list) {
        this.mList = list;
        switch (list.size()) {
            case 1:
                gridLayoutManager.setSpanCount(1);
                break;
            case 2:
                gridLayoutManager.setSpanCount(2);
                break;
            default:
                gridLayoutManager.setSpanCount(3);
                break;
        }
        imgAdapter = new ImgAdapter(list, getContext());
        this.setAdapter(imgAdapter);
    }

    private class ImgAdapter extends AbstractAdapter<String> {

        public ImgAdapter(List<String> mList, Context mContext) {
            super(mList, mContext);
        }

        @Override
        void bindHolder(ImgViewHolder holder, int position, String s) {
            ImageView iv = holder.getView(R.id.childIv);
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) iv.getLayoutParams();
            int displayWidth = DisplayUtil.getResultWidth(getContext());
            switch (mList.size()) {
                case 1:
                    layoutParams.width = displayWidth;
                    break;
                case 2:
                    layoutParams.width = displayWidth / 2;
                    layoutParams.height = displayWidth / 2;
                    break;
                default:
                    layoutParams.width = displayWidth / 3;
                    layoutParams.height = displayWidth / 3;
                    break;
            }
            iv.setLayoutParams(layoutParams);
            holder.setImageView(R.id.childIv, s, layoutParams.width, layoutParams.height, mList.size());
        }

        @Override
        int getItemLayout() {
            return R.layout.item_img_layout;
        }
    }
}
