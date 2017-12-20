package com.czyapp.rxjavatest.android_rx;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.czyapp.rxjavatest.R;

/**
 * Created by czy on 2017/12/19.
 */

public class ThreeActivity extends AppCompatActivity {
private Button create_btn1,create_btn2;
private Button from_btn,just_btn,filter_btn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.android_rx_activity);
        create_btn1=(Button)findViewById(R.id.create_btn1);
        create_btn2=(Button)findViewById(R.id.create_btn2);
        from_btn=(Button)findViewById(R.id.from_btn);
        just_btn=(Button)findViewById(R.id.just_btn);
        filter_btn=(Button)findViewById(R.id.filter_btn);

        create_btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RxUtils.createObserable();//调用create方法1
            }
        });

        create_btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RxUtils.createPrint();//调用create方法2
            }
        });


        from_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RxUtils.from();
            }
        });

        just_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RxUtils.just();
            }
        });

        filter_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RxUtils.filter();
            }
        });

    }
}
