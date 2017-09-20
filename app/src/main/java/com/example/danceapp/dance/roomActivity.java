package com.example.danceapp.dance;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * Created by Jinya LIANG on 2017/8/6.
 */
//音乐播放，聊天
public class roomActivity extends Activity
        implements View.OnClickListener {

    private TextView music_name;//音乐名称
    private RelativeLayout music_bar;
    private ChangeButton music_control_btn;//音乐播放暂停按钮
    //聊天
    private Button BtnSend, last, next;//发送，上一首、下一首
    private EditText InputBox;
    private List<ChatMessage> mData;
    private ChatAdapter mAdapter;
    public static final String IP_ADDR = "123.206.65.213";// 服务器地址
    public static final int PORT = 12346;// 服务器端口号
    String name;
    int current = 0;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.my_room);

        final ListView mListView = (ListView) findViewById(R.id.chatList);//聊天信息listview
        mData = LoadData();
        mAdapter = new ChatAdapter(this, mData);
        mListView.setAdapter(mAdapter);
        mListView.smoothScrollToPositionFromTop(mData.size(), 0);
        InputBox = (EditText) findViewById(R.id.InputBox);//输入框
        BtnSend = (Button) findViewById(R.id.BtnSend);//发送按钮
        SharedPreferences preferences = getSharedPreferences("data", Context.MODE_PRIVATE);
        name = preferences.getString("name", "");
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                if (msg.what == 1) {
                    mAdapter.Refresh();
                }
            }
        };
        new Get(name).start();
        BtnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                if (InputBox.getText().toString() != "") {
                    //获取时间
                    Calendar c = Calendar.getInstance();
                    StringBuilder mBuilder = new StringBuilder();
                    mBuilder.append(Integer.toString(c.get(Calendar.YEAR)) + "年");
                    mBuilder.append(Integer.toString(c.get(Calendar.MONTH)) + "月");
                    mBuilder.append(Integer.toString(c.get(Calendar.DATE)) + "日");
                    mBuilder.append(Integer.toString(c.get(Calendar.HOUR_OF_DAY)) + ":");
                    mBuilder.append(Integer.toString(c.get(Calendar.MINUTE)));
                    //构造时间消息
                    ChatMessage Message = new ChatMessage(ChatMessage.MessageType_Time, mBuilder.toString());
                    mData.add(Message);
                    //构造输入消息
                    Message = new ChatMessage(ChatMessage.MessageType_To, InputBox.getText().toString());
                    mData.add(Message);
                    if (InputBox.getText().toString() != null&&!InputBox.getText().toString().equals("")) {
                        new Send(name + "#2#222#2#" + InputBox.getText().toString()).start();
                    } else {
                        Toast.makeText(getApplicationContext(), "输入信息不能为空",//测试数据
                                Toast.LENGTH_SHORT).show();
                    }

                    mAdapter.Refresh();
                }
                //清空输入框
                InputBox.setText("");
                //关闭输入法
                imm.hideSoftInputFromWindow(null, InputMethodManager.HIDE_IMPLICIT_ONLY);
                //滚动列表到当前消息
                mListView.smoothScrollToPositionFromTop(mData.size(), 0);
            }
        });

        initView();
    }

    private void initView() {

        music_bar = (RelativeLayout) findViewById(R.id.music_bar);
        music_bar.setOnClickListener(this);

        music_control_btn = (ChangeButton) findViewById(R.id.music_control_btn);
        music_control_btn.setOnClickListener(this);

        last = (Button) findViewById(R.id.last);
        last.setOnClickListener(this);

        next = (Button) findViewById(R.id.next);
        next.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.music_bar://点击顶部音乐条跳转到音乐页面
                Intent intent = new Intent(roomActivity.this, MusicActivity.class);
                roomActivity.this.startActivity(intent);
                break;
            case R.id.music_control_btn://点击开始暂停控制音乐播放
                music_control_btn.setIsStart(!music_control_btn.isStart());
                if (music_control_btn.isStart())
                    Toast.makeText(getApplicationContext(), "开始播放",//测试数据
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

    private class Send extends Thread {
        DataOutputStream out;
        DataInputStream in;
        String a;

        public Send(String a) {
            this.a = a;
        }

        public void run() {
            Socket socket = null;
            out = null;
            try {
                socket = new Socket(IP_ADDR, PORT);
                out = new DataOutputStream(socket.getOutputStream());
            } catch (Exception e1) {
                e1.printStackTrace();
            }
            try {
                out.writeUTF(a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private class Get extends Thread {
        DataOutputStream out;
        DataInputStream in;
        String a;

        public Get(String a) {
            this.a = a;
        }

        public void run() {
            Socket socket = null;
            out = null;
            try {

                while (true) {
                    socket = new Socket(IP_ADDR, PORT + 1);
                    out = new DataOutputStream(socket.getOutputStream());
                    out.writeUTF(a);
                    out.writeInt(current);
                    in = new DataInputStream(socket.getInputStream());
                    current = in.readInt();
                    String m = in.readUTF();
                    String a[] = m.split("#44#22#33#");
                    for (int k = 0; k < a.length; k++) {
                        if (a[k] != null&&!a[k].equals("")) {
                            ChatMessage Message = new ChatMessage(ChatMessage.MessageType_From, a[k]);
                            mData.add(Message);
                            Message message = new Message();
                            message.what = 1;
                            handler.sendMessage(message);
                        }
                    }
                    sleep(50);
                }
            } catch (Exception e1) {
                e1.printStackTrace();
            }


        }
    }

    //测试数据
    private List<ChatMessage> LoadData() {
        List<ChatMessage> Messages = new ArrayList<ChatMessage>();

        ChatMessage Message = new ChatMessage(ChatMessage.MessageType_Time, "2017年8月8日");
        Messages.add(Message);

        Message = new ChatMessage(ChatMessage.MessageType_From, "山重水复疑无路");
        Messages.add(Message);

        Message = new ChatMessage(ChatMessage.MessageType_To, "柳暗花明又一村");
        Messages.add(Message);

        Message = new ChatMessage(ChatMessage.MessageType_From, "青青子衿，悠悠我心");
        Messages.add(Message);

        Message = new ChatMessage(ChatMessage.MessageType_To, "但为君故，沉吟至今");
        Messages.add(Message);

        Message = new ChatMessage(ChatMessage.MessageType_Time, "19：25");
        Messages.add(Message);

        Message = new ChatMessage(ChatMessage.MessageType_From, "这是你做的Android程序吗？");
        Messages.add(Message);

        Message = new ChatMessage(ChatMessage.MessageType_To, "是的是的是的是的我是一个长长长长长长长长长的消息，我长长长长长长长长长吗");
        Messages.add(Message);

        Message = new ChatMessage(ChatMessage.MessageType_From, "为什么对话框的颜色这么丑");
        Messages.add(Message);

        Message = new ChatMessage(ChatMessage.MessageType_To, "因为还没有进行调整");
        Messages.add(Message);

        Message = new ChatMessage(ChatMessage.MessageType_From, "哦哦，呵呵，你又在偷懒了");
        Messages.add(Message);

        Message = new ChatMessage(ChatMessage.MessageType_To, "因为时间紧迫");
        Messages.add(Message);

        Message = new ChatMessage(ChatMessage.MessageType_From, "好吧，可是怎么发语音啊");
        Messages.add(Message);

        Message = new ChatMessage(ChatMessage.MessageType_To, "过两天再发语音吧，这两天还是多练练打字");
        Messages.add(Message);
        return Messages;
    }
}

