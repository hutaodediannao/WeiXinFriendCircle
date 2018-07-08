package com.app.demo;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.request.RequestOptions;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.transition.Transition;

import static android.support.constraint.Constraints.TAG;

public class BitmapUtil {

    public static void loadImg(Context context, String imgSrcUrl, final ImageView imageView, final int width, int height, int listSize) {

        RequestOptions options = new RequestOptions()
                .placeholder(R.mipmap.ic_launcher)    //加载成功之前占位图
                .error(R.mipmap.ic_launcher)    //加载错误之后的错误图
                .override(width, height)    //指定图片的尺寸
                //指定图片的缩放类型为fitCenter （等比例缩放图片，宽或者是高等于ImageView的宽或者是高。）
//                .fitCenter()
//                .centerInside()
                //指定图片的缩放类型为centerCrop （等比例缩放图片，直到图片的狂高都大于等于ImageView的宽度，然后截取中间的显示。）
//                .centerCrop()
//                .circleCrop()//指定图片的缩放类型为centerCrop （圆形）
                .skipMemoryCache(false)    //跳过内存缓存
//                .diskCacheStrategy(DiskCacheStrategy.ALL)	//缓存所有版本的图像
//                .diskCacheStrategy(DiskCacheStrategy.NONE)	//跳过磁盘缓存
//                .diskCacheStrategy(DiskCacheStrategy.DATA)	//只缓存原来分辨率的图片
                .diskCacheStrategy(DiskCacheStrategy.RESOURCE)    //只缓存最终的图片
                ;

        switch (listSize) {
            case 1:
                Glide.with(context)
                        .asBitmap()
                        .load(imgSrcUrl)
                        .apply(options)
                        .into(new SimpleTarget<Bitmap>() {
                            @Override
                            public void onResourceReady(@NonNull Bitmap bitmap, @Nullable Transition<? super Bitmap> transition) {
                                int bitmapWidth = bitmap.getWidth();
                                int bitmapHeight = bitmap.getHeight();
                                FrameLayout.LayoutParams l = (FrameLayout.LayoutParams) imageView.getLayoutParams();
                                l.height = bitmapHeight * width / bitmapWidth;
                                imageView.setImageBitmap(bitmap);
                            }
                        });
                break;
            default:
                Glide.with(context)
                        .asBitmap()
                        .load(imgSrcUrl)
                        .apply(options)
                        .into(imageView);
                break;
        }
    }

}
