package com.app.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private List<ImgModel> modelList = new ArrayList<>();
    private ModelAdapter modelAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerView);
        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);


        List<String> srcList0 = new ArrayList<>();
        List<String> srcList1 = new ArrayList<>();
        List<String> srcList2 = new ArrayList<>();
        List<String> srcList3 = new ArrayList<>();
        srcList0.add("http://image.uczzd.cn/3970765567858067563.jpg?id=0&from=export&height=140&width=270");

        srcList1.add("http://image.uczzd.cn/13927551119661439887.jpg?id=0&from=export&height=140&width=270");
        srcList1.add("http://image.uczzd.cn/16947129860896615085.jpg?id=0&from=export&height=140&width=270");

        srcList2.add("http://image.uczzd.cn/12475765069416858410.jpg?id=0&from=export&height=140&width=270");
        srcList2.add("http://image.uczzd.cn/14052128931440175372.jpg?id=0&from=export&height=140&width=270");
        srcList2.add("http://image.uczzd.cn/17850551527919978648.jpg?id=0&from=export&height=140&width=270");

        srcList3.add("http://image.uczzd.cn/13976478598995002471.jpg?id=0&from=export&height=140&width=270");
        srcList3.add("http://image.uczzd.cn/12173917882181183582.jpg?id=0&from=export&height=140&width=270");
        srcList3.add("http://image.uczzd.cn/14461851206410029322.jpg?id=0&from=export&height=140&width=270");
        srcList3.add("http://image.uczzd.cn/18159293670677601116.jpg?id=0&from=export&height=140&width=270");

        srcList3.add("https://img.alicdn.com/bao/uploaded/TB1vej2ApGWBuNjy0FbSuv4sXXa.jpg");
        srcList3.add("https://img.alicdn.com/bao/uploaded/i8/TB128X1bQZmBKNjSZPiTKJFNVXa_035141.jpg_b.jpg");
        srcList3.add("https://img.alicdn.com/bao/uploaded/i6/TB1yw0qmDlYBeNjSszc_pTwhFXa_113910.jpg_b.jpg");
        srcList3.add("https://img.alicdn.com/bao/uploaded/i6/TB1CHAmRXXXXXcyXXXXXdRcFpXX_090005.jpg_b.jpg");
        srcList3.add("https://img.alicdn.com/bao/uploaded/i6/TB1Ewwzn4GYBuNjy0Fnn_B5lpXa_050424.jpg_b.jpg");

        ImgModel i0 = new ImgModel("它搭载高通骁龙845处理器，配备4/6/8GB内存+64/128/256GB存储，后置1200万+800万像素双摄像头，前置摄像头为800万像素，运行Android 8.0系统。\n" +
                "\n" +
                "至于价格，华硕ZenFone 5Z在中国台湾的起售价是14990新台币（6GB+64GB版，约合人民币3200元）。因此，国行起售价可能在3000元左右。", srcList0);
        ImgModel i1 = new ImgModel("2018年7月3日晚，距离WPS“云·AI未来办公大会”还有30分钟开始，在北京奥林匹克塔(俗称钉子塔)场馆内挤满了来自全国各地的媒体人、用户代表和嘉宾合作伙伴。作为中国互联网行业唯一的一款持续运营达到30年的办公产品，堪称国民办公软件，有理由受到这样的对待。", srcList1);
        ImgModel i2 = new ImgModel("【PConline 单机评测】先不就刚刚为大家带来了华硕的飞行堡垒这款产品的评测，搭载的是i7-8750H处理器以及GTX 1050Ti独立显卡。而这次我将为大家带来GTX 1060独立显卡的版本，让我们一起来看看在搭载了性能更强劲的显卡后，这款电脑会给大家带来怎样的体验吧！", srcList2);
        ImgModel i3 = new ImgModel("昨天有人问小编，看中一款游戏主板，细问原因，主要是RGB信仰灯太酷了，不过小伙伴似乎对游戏主板的其他方面并不了解。正好小编今天就借机和大家说说这个比较火的主板类型，究竟值得不值得。", srcList3);

        modelList.add(i0);
        modelList.add(i1);
        modelList.add(i2);
        modelList.add(i3);

        modelList.add(i0);
        modelList.add(i1);
        modelList.add(i2);
        modelList.add(i3);

        modelList.add(i0);
        modelList.add(i1);
        modelList.add(i2);
        modelList.add(i3);

        modelList.add(i0);
        modelList.add(i1);
        modelList.add(i2);
        modelList.add(i3);

        modelAdapter = new ModelAdapter(modelList, this);
        recyclerView.setAdapter(modelAdapter);
    }
}
