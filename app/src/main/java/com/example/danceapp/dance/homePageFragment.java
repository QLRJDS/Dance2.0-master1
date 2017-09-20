package com.example.danceapp.dance;

import android.app.Fragment;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

//主页
/**
 * 主页
 */
public class homePageFragment extends Fragment implements View.OnClickListener{

    private RelativeLayout tuijian,jianshencao,minzuwu,jiewu,xiandaiwu;
    private ImageView vptuijian,vpjianshencao,vpminzuwu,vpjiewu,vpxiandaiwu;
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.homepage, container, false);

        tuijian=(RelativeLayout)view.findViewById(R.id.tuijian);
        tuijian.setOnClickListener(this);
        jianshencao=(RelativeLayout)view.findViewById(R.id.jianshencao);
        jianshencao.setOnClickListener(this);
        minzuwu=(RelativeLayout)view.findViewById(R.id.minzuwu);
        minzuwu.setOnClickListener(this);
        jiewu=(RelativeLayout)view.findViewById(R.id.jiewu);
        jiewu.setOnClickListener(this);
        xiandaiwu=(RelativeLayout)view.findViewById(R.id.xiandaiwu);
        xiandaiwu.setOnClickListener(this);

        vptuijian=(ImageView)view.findViewById(R.id.vptuijian);
        vptuijian.setOnClickListener(this);
        vpjianshencao=(ImageView)view.findViewById(R.id.vpjianshencao);
        vpjianshencao.setOnClickListener(this);
        vpminzuwu=(ImageView)view.findViewById(R.id.vpminzuwu);
        vpminzuwu.setOnClickListener(this);
        vpjiewu=(ImageView)view.findViewById(R.id.vpjiewu);
        vpjiewu.setOnClickListener(this);
        vpxiandaiwu=(ImageView)view.findViewById(R.id.vpxiandaiwu);
        vpxiandaiwu.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tuijian://调用回调函数，进行数据处理
                VedioListCallback tuijian_list = (VedioListCallback) getActivity();
                tuijian_list.getVedioList("tuijian");
                break;
            case R.id.jianshencao://调用回调函数，进行数据处理
                VedioListCallback jianshencao_list = (VedioListCallback) getActivity();
                jianshencao_list.getVedioList("jianshencao");
                break;
            case R.id.minzuwu://调用回调函数，进行数据处理
                VedioListCallback minzuwu_list = (VedioListCallback) getActivity();
                minzuwu_list.getVedioList("minzuwu");
                break;
            case R.id.jiewu://调用回调函数，进行数据处理
                VedioListCallback jiewu_list = (VedioListCallback) getActivity();
                jiewu_list.getVedioList("jiewu");
                break;
            case R.id.xiandaiwu://调用回调函数，进行数据处理
                VedioListCallback xiandaiwu_list = (VedioListCallback) getActivity();
                xiandaiwu_list.getVedioList("xiandaiwu");
                break;


            case R.id.vptuijian:
                VedioCallback callback1=(VedioCallback) getActivity();
                callback1.getVedio("test");
                break;
            case R.id.vpjianshencao:
                VedioCallback callback2=(VedioCallback) getActivity();
                callback2.getVedio("test");
                break;
            case R.id.vpminzuwu:
                VedioCallback callback3=(VedioCallback) getActivity();
                callback3.getVedio("test");
                break;
            case R.id.vpjiewu:
                VedioCallback callback4=(VedioCallback) getActivity();
                callback4.getVedio("test");
                break;
            case R.id.vpxiandaiwu:
                VedioCallback callback5=(VedioCallback) getActivity();
                callback5.getVedio("test");
                break;

        }
    }
    //数据处理的回调函数
    public interface VedioListCallback {
        public void getVedioList(String data);
    }
    //数据处理的回调函数
    public interface VedioCallback {
        public void getVedio(String data);
    }
}

