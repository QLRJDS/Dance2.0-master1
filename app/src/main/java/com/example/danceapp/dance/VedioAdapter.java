package com.example.danceapp.dance;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.net.URL;
import java.util.List;

/**
 * vedioAdapter
 */
public class VedioAdapter extends BaseAdapter {
    private Context mContext;
    private List<VedioData> mData;
    private ImageView vedio_img;
    private int index;
    public VedioAdapter(Context context, List<VedioData> data) {
        this.mContext = context;
        this.mData = data;
    }

    public void Refresh() {
        this.notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int Index) {
        return mData.get(Index);
    }

    @Override
    public long getItemId(int Index) {
        return Index;
    }

    @Override
    public View getView(int Index, View mView, ViewGroup mParent) {
        TextView vedio_name;
        index = Index;
        mView = LayoutInflater.from(mContext).inflate(R.layout.vediolist_vedio, null);
        vedio_name = (TextView) mView.findViewById(R.id.vedio_name);
        vedio_name.setText(mData.get(Index).getContent());
        vedio_img = (ImageView) mView.findViewById(R.id.vedio_img);
        new Thread(networkTask).start();
        return mView;
    }

    Runnable networkTask = new Runnable() {
        @Override
        public void run() {
            try {
                URL thumb_u = new URL(mData.get(index).getImgId());
                Drawable thumb_d = Drawable.createFromStream(thumb_u.openStream(), "src");
                vedio_img.setImageDrawable(thumb_d);
            } catch (Exception e) {
                // handle it
                e.printStackTrace();
            }
        }
    };
}