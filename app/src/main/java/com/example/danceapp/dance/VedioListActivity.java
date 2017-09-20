package com.example.danceapp.dance;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
/**
 * 动态添加视频listview
 */
public class VedioListActivity extends Activity{

    private Button back_to_home;
    private List<VedioData> mData;
    private VedioAdapter mAdapter;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.vedios);

        ListView mListView=(ListView)findViewById(R.id.vedio_list);//listview
        mData=LoadData();//测试数据
        mAdapter=new VedioAdapter(this, mData);
        mListView.setAdapter(mAdapter);
        Toast.makeText(getApplicationContext(), "set了",
                Toast.LENGTH_SHORT).show();

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id){
                Toast.makeText(getApplicationContext(), "默认Toast样式",
                        Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(VedioListActivity.this, vedioActivity.class);
                startActivity(intent);
            }
        });

        Toast.makeText(getApplicationContext(), "话了",
                Toast.LENGTH_SHORT).show();

        mListView.smoothScrollToPositionFromTop(mData.size(), 0);
    }

    //测试数据
    private List<VedioData> LoadData() {
        List<VedioData> datas = new ArrayList<VedioData>();

        VedioData data = new VedioData("http://image2.sina.com.cn/blog/tmpl/v3/images/error_link.gif","视频名称");
        datas.add(data);
        data = new VedioData("http://hiphotos.baidu.com/baidu/pic/item/7d8aebfebf3f9e125c6008d8.jpg","视频名称");
        datas.add(data);
        data = new VedioData("http://image2.sina.com.cn/blog/tmpl/v3/images/error_link.gif","视频名称");
        datas.add(data);
        data = new VedioData("http://hiphotos.baidu.com/baidu/pic/item/7d8aebfebf3f9e125c6008d8.jpg","视频名称");
        datas.add(data);
        data = new VedioData("http://image2.sina.com.cn/blog/tmpl/v3/images/error_link.gif","视频名称");
        datas.add(data);
        data = new VedioData("http://hiphotos.baidu.com/baidu/pic/item/7d8aebfebf3f9e125c6008d8.jpg","视频名称");
        datas.add(data);
        data = new VedioData("http://image2.sina.com.cn/blog/tmpl/v3/images/error_link.gif","视频名称");
        datas.add(data);
        data = new VedioData("http://image2.sina.com.cn/blog/tmpl/v3/images/error_link.gif","视频名称");
        datas.add(data);
        data = new VedioData("http://image2.sina.com.cn/blog/tmpl/v3/images/error_link.gif","视频名称");
        datas.add(data);
        data = new VedioData("http://image2.sina.com.cn/blog/tmpl/v3/images/error_link.gif","视频名称");
        datas.add(data);
        data = new VedioData("http://image2.sina.com.cn/blog/tmpl/v3/images/error_link.gif","视频名称");
        datas.add(data);

        return datas;
    }
}
