package com.app.demo;

import java.util.List;

public class ImgModel {

    private String titlleName;
    private List<String> imgList;

    public ImgModel(String titlleName,List<String> imgList) {
        this.titlleName = titlleName;
        this.imgList = imgList;
    }

    public String getTitlleName() {
        return titlleName;
    }

    public void setTitlleName(String titlleName) {
        this.titlleName = titlleName;
    }

    public List<String> getImgList() {
        return imgList;
    }

    public void setImgList(List<String> imgList) {
        this.imgList = imgList;
    }
}
