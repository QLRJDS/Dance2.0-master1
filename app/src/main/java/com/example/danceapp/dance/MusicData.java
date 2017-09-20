package com.example.danceapp.dance;

/**
 * Created by Jinya LIANG on 2017/8/9.
 */
public class MusicData {

    public MusicData(String song,String singer)
    {
        this.song=song;
        this.singer=singer;
    }

    //消息内容
    private String song;
    private String singer;

    //获取内容
    public String getSong() {
        return song;
    }
    public String getSinger() {
        return singer;
    }
    //设置内容
    public void setContent(String song,String singer) {
        this.song=song;
        this.singer=singer;
    }
}
