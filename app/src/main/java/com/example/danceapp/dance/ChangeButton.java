package com.example.danceapp.dance;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

/**
 * 音乐播放暂停按钮
 */
public class ChangeButton extends LinearLayout {

    private static String NAMESPACE = "http://schemas.android.com/apk/res/com.example.danceapp.dance";

    //存放第一张图片在R文件中的Int值，默认为0
    protected int startImage = 0;

    //存放第二张图片在R文件中的Int值，默认为0
    public int stopImage = 0;

    //判断处于哪个状态，默认为false
    private boolean isStart = false;

    //三个构造函数
    public ChangeButton(Context context) {
        super(context);
        initView();
    }

    public ChangeButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }

    public ChangeButton(Context context, AttributeSet attrs) {
        super(context, attrs);
        // 获取图片的Int值
        startImage = attrs.getAttributeResourceValue(NAMESPACE,"play",R.mipmap.play);
        stopImage = attrs.getAttributeResourceValue(NAMESPACE, "stop", R.mipmap.stop);
        initView();
    }

    public boolean isStart(){
        return isStart;
    }

    private void initView(){
        View.inflate(getContext(), R.layout.music_control_button, this);
        this.setClickable(true);
        if(stopImage == 0){
            return ;
        }else{
            setIsStart(isStart);
        }
    }
    /**
     * 通过传进一个boolean值，设置按钮的状态
     * @param isStart 设置开始或者暂停的状态
     */
    public void setIsStart(boolean isStart){
        this.isStart = isStart;
        //如果当前按钮是播放状态，则改为暂停状态
        if(isStart){
            this.setBackgroundResource(stopImage);
        }
        //如果当前按钮是暂停状态，则改为播放状态
        else{
            this.setBackgroundResource(startImage);
        }
    }
}
