package com.example.danceapp.dance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * 聊天
 */
public class ChatAdapter extends BaseAdapter
{
    private Context mContext;
    private List<ChatMessage> mData;

    public ChatAdapter(Context context,List<ChatMessage> data)
    {
        this.mContext=context;
        this.mData=data;
    }

    public void Refresh()
    {
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount()
    {
        return mData.size();
    }

    @Override
    public Object getItem(int Index)
    {
        return mData.get(Index);
    }

    @Override
    public long getItemId(int Index)
    {
        return Index;
    }

    @Override
    public View getView(int Index, View mView, ViewGroup mParent)
    {
        TextView Content;
        switch(mData.get(Index).getType())
        {
            //时间类型
            case ChatMessage.MessageType_Time:
                mView= LayoutInflater.from(mContext).inflate(R.layout.text_time, null);
                Content=(TextView)mView.findViewById(R.id.Time);
                Content.setText(mData.get(Index).getContent());
                break;
            //接受的消息
            case ChatMessage.MessageType_From:
                mView=LayoutInflater.from(mContext).inflate(R.layout.text_receive, null);
                Content=(TextView)mView.findViewById(R.id.From_Content);
                Content.setText(mData.get(Index).getContent());
                break;
            //发送的消息
            case ChatMessage.MessageType_To:
                mView=LayoutInflater.from(mContext).inflate(R.layout.text_send, null);
                Content=(TextView)mView.findViewById(R.id.To_Content);
                Content.setText(mData.get(Index).getContent());
                break;
        }
        return mView;
    }
}
