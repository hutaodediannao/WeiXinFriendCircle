package com.app.demo;

import android.content.Context;

import java.util.List;

public class ModelAdapter extends AbstractAdapter<ImgModel> {

    public ModelAdapter(List<ImgModel> mList, Context mContext) {
        super(mList, mContext);
    }

    @Override
    void bindHolder(ImgViewHolder holder, int position, ImgModel imgModel) {
        holder.setTextView(R.id.tv, imgModel.getTitlleName())
        .setDesignImgRecyclerView(R.id.designImgRecyclerView, imgModel.getImgList());
    }

    @Override
    int getItemLayout() {
        return R.layout.item_layout;
    }
}
