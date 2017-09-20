package com.example.danceapp.dance;

/**
 * vedio
 */
public class VedioData {
    public VedioData(String path,String title)
    {
        this.path=path;
        this.title=title;
    }

    //消息内容
    private String path;//视频的图片
    private String title;//视频的名称

    //获取内容
    public String getImgId() {
        return path;
    }
    public String getContent() {
        return title;
    }
    //设置内容
    public void setContent(String path,String title) {
        this.path = path;
        this.title=title;
    }
}