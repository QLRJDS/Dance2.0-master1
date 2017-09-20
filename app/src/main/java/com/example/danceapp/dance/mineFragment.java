package com.example.danceapp.dance;

import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//个人
/**
 * Created by Jinya LIANG on 2017/7/24.
 */
public class mineFragment extends Fragment {

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view= inflater.inflate(R.layout.mine, container, false);

        //为头像设置监听
        view.findViewById(R.id.head).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), HeadActivity.class);
                startActivity(intent);
            }
        });

        //为注册登陆按钮设置监听,进入登陆页面
        view.findViewById(R.id.logbt).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), LogActivity.class);
                startActivity(intent);
            }
        });
        //为收藏设置监听,进入收藏页面
        view.findViewById(R.id.collection_bar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CollectionActivity.class);
                startActivity(intent);
            }
        });
        //为历史纪录设置监听,进入历史纪录页面
        view.findViewById(R.id.cache_bar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), HistoryActivity.class);
                startActivity(intent);
            }
        });
        //为本地缓存设置监听,进入本地缓存页面
        view.findViewById(R.id.history_bar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), HistoryActivity.class);
                startActivity(intent);
            }
        });
        //进入设置页面
        view.findViewById(R.id.set_bar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), SettingActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }
}
