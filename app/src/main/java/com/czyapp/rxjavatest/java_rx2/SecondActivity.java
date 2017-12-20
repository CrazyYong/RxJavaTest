package com.czyapp.rxjavatest.java_rx2;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import com.czyapp.rxjavatest.R;

/**
 * Created by czy on 2017/12/19.
 */

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SimpleObservable simple = new SimpleObservable();
        SimpleObserver observer = new SimpleObserver(simple);


        simple.setData(1);
        simple.setData(2);
        simple.setData(3);
        simple.setData(4);
    }
}
