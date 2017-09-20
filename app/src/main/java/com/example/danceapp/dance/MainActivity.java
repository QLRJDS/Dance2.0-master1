package com.example.danceapp.dance;

import android.app.ActionBar;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        RadioGroup.OnCheckedChangeListener,
        homePageFragment.VedioListCallback,homePageFragment.VedioCallback{

    private RadioGroup rg_tab_bar;
    private RadioButton rb_homepage;//首页按钮

    homePageFragment fg1;//主页
    public roomFragment fg2;//房间页
    private mineFragment fg3;//个人页
    private FragmentManager fManager=getFragmentManager();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rg_tab_bar = (RadioGroup) findViewById(R.id.rg_tab_bar);
        rg_tab_bar.setOnCheckedChangeListener(this);
        //获取第一个单选按钮，并设置其为选中状态，即刚开始显示主页页面
        rb_homepage = (RadioButton)findViewById(R.id.rb_homepage);
        rb_homepage.setChecked(true);
    }

    //页面在“主页”“房间”“个人”的切换
    public void onCheckedChanged(RadioGroup group,int checkedId){
        FragmentTransaction fTransaction = fManager.beginTransaction();
        hideAllFragment(fTransaction);
        switch(checkedId){
            case R.id.rb_homepage:
                if(fg1==null){
                    fg1=new homePageFragment();
                    fTransaction.add(R.id.ly_content,fg1);
                }
                else
                    fTransaction.show(fg1);
                break;
            case R.id.rb_room:
                if(fg2==null){
                    fg2=new roomFragment();
                    fTransaction.add(R.id.ly_content, fg2);
                }
                else
                    fTransaction.show(fg2);
                break;
            case R.id.rb_mine:
                if(fg3==null){
                    fg3=new mineFragment();
                    fTransaction.add(R.id.ly_content, fg3);
                }
                else
                    fTransaction.show(fg3);
                break;
        }
        fTransaction.commit();

    }
    //隐藏所有Fragment
    private void hideAllFragment(FragmentTransaction fTransaction) {
        if (fg1 != null)fTransaction.hide(fg1);
        if (fg2 != null)fTransaction.hide(fg2);
        if (fg3 != null)fTransaction.hide(fg3);
    }
    //实现DataCallBack接口，对创建房间时的数据进行处理。
    public void getData(String data) {

        //此处为数据处理


        //跳转到房间activity
        Intent intent=new Intent(MainActivity.this, roomActivity.class);
        startActivity(intent);
    }

    //实现DataCallBack接口，对视屏列表的数据进行处理。
    public void getVedioList(String data) {
        //此处为数据处理
        //跳转到视频列表activity
        Intent intent=new Intent(MainActivity.this, VedioListActivity.class);
        startActivity(intent);
    }
    //实现DataCallBack接口，对需要观看的视频数据进行处理。
    public void getVedio(String data) {
        //此处为数据处理

        //跳转到视频播放activity

        Intent intent=new Intent(MainActivity.this, vedioActivity.class);
        startActivity(intent);
    }
}