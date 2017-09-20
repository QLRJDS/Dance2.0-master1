package com.example.danceapp.dance;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
//房间
/**
 * Created by Jinya LIANG on 2017/7/24.
 */
public class roomFragment extends Fragment {

    RadioGroup num;
    RadioButton num1;
    Button add,decrease;
    //EditText time;
    public View onCreateView(LayoutInflater inflater,ViewGroup container,Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.room, container, false);
        //time=(EditText)view.findViewById(R.id.time);
        num= (RadioGroup)view.findViewById(R.id.num);
        //获取第一个单选按钮，并设置其为选中状态
        num1 = (RadioButton)view.findViewById(R.id.num1);
        num1.setChecked(true);

        //点击创建房间按钮
        view.findViewById(R.id.newroom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean enter=true;//判断是否进入
                if(enter) {
                    SharedPreferences.Editor editor = getActivity().getSharedPreferences("data", Context.MODE_PRIVATE).edit();
                    editor.putString("name","text1");
                    System.out.println("fffffff");
                    editor.commit();
                    Intent intent = new Intent(getActivity(), roomActivity.class);
                    startActivity(intent);
                }
            }
        });

        //点击加入房间按钮
        view.findViewById(R.id.enterroom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean enter=true;//判断是否进入
                if(enter) {
                    Intent intent = new Intent(getActivity(), roomActivity.class);
                    startActivity(intent);
                }
            }
        });
        return view;
    }
}

