package com.example.danceapp.dance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

/**
 * 音乐播放页面  音乐进度的控制
 */
public class MusicActivity extends Activity implements View.OnClickListener{
    private Button back_to_room,last,next;
    private ChangeButton music_control_btn;//音乐播放暂停按钮;
    private SeekBar seekbar;
    private RelativeLayout music_list_bar;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.music_item);

        //滑动区域
        final TextView result=(TextView)findViewById(R.id.textView1);
        seekbar=(SeekBar)findViewById(R.id.music_seekBar);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            //当用户结束滑动拖动条的时候执行的方法
            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MusicActivity.this, "结束滑动", Toast.LENGTH_SHORT).show();
            }

            //当用户开始滑动拖动条的时候执行的方法
            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
                Toast.makeText(MusicActivity.this, "开始滑动", Toast.LENGTH_SHORT).show();
            }

            //当用户正在滑动拖动条的时候执行的方法(参数progress就是目前拖动条的进度)
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                result.setText("当前值：" + progress);
            }
        });
        initView();
    }
    private void initView()//初始化控件
    {
        back_to_room= (Button) findViewById(R.id.back_to_room);
        back_to_room.setOnClickListener(this);

        music_control_btn = (ChangeButton) findViewById(R.id.music_control_btn);
        music_control_btn.setOnClickListener(this) ;

        music_list_bar=(RelativeLayout)findViewById(R.id.music_list_bar);
        music_list_bar.setOnClickListener(this);

        last=(Button)findViewById(R.id.last);
        last.setOnClickListener(this);

        next=(Button)findViewById(R.id.next);
        next.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.back_to_room://返回上一页
                finish();
                break;
            case R.id.music_list_bar://点击播放列表跳转到播放列表页面
                Intent intent = new Intent(MusicActivity.this, MusicListActivity.class);
                MusicActivity.this.startActivity(intent);
                break;
            case R.id.music_control_btn://音乐开始暂停播放
                music_control_btn.setIsStart(!music_control_btn.isStart());
                if(music_control_btn.isStart())
                    Toast.makeText(getApplicationContext(), "开始播放",
                            Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(getApplicationContext(), "暂停播放",
                            Toast.LENGTH_SHORT).show();
            case R.id.last:
                //上一首
                Toast.makeText(getApplicationContext(), "上一首",//测试数据
                        Toast.LENGTH_SHORT).show();
                break;
            case R.id.next:
                //下一首
                Toast.makeText(getApplicationContext(), "下一首",//测试数据
                        Toast.LENGTH_SHORT).show();
                break;
        }
    }
}
