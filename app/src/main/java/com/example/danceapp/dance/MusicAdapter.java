package com.example.danceapp.dance;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Jinya LIANG on 2017/8/9.
 */

public class MusicAdapter extends BaseAdapter
    {
        private Context mContext;
        private List<MusicData> mData;

        public MusicAdapter(Context context,List<MusicData> data)
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
    public View getView(int Index, View mView, ViewGroup mParent) {
        TextView Content_song, Content_singer;
        Button delete_btn;

        mView = LayoutInflater.from(mContext).inflate(R.layout.musiclist_music, null);
        Content_song = (TextView) mView.findViewById(R.id.song);
        Content_song.setText(mData.get(Index).getSong());
        Content_singer = (TextView) mView.findViewById(R.id.singer);
        Content_singer.setText(mData.get(Index).getSinger());

        delete_btn=(Button)mView.findViewById(R.id.delete_song);
        //delete_btn.setOnClickListener(onDelItem);
        //delete_btn.setTag(Index);

        return mView;
    }
        /*删除单条item的接口
    private View.OnClickListener onDelItem;
    //监听接口,设置该接口的对象，给接口对象赋值
    public void setOnDelItem(View.OnClickListener onDelItem)
    {
       this.onDelItem=onDelItem;
    }*/

}
