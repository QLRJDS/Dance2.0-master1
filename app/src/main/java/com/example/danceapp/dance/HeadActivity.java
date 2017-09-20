package com.example.danceapp.dance;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Jinya LIANG on 2017/9/19.
 */
public class HeadActivity extends Activity {

    private Button select;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mine_head);

        select= (Button) findViewById(R.id.select);
        select.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {

                finish();
            }
        });
    }
}
