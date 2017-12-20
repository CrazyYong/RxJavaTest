package com.czyapp.rxjavatest.java_rx;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.czyapp.rxjavatest.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Watched xiaoming = new ConcreteWatched();

        Watcher watcher1 = new ConcreteWatcher();
        Watcher watcher2 = new ConcreteWatcher();
        Watcher watcher3 = new ConcreteWatcher();

        xiaoming.addwatcher(watcher1);
        xiaoming.addwatcher(watcher2);
        xiaoming.addwatcher(watcher3);

        xiaoming.notifywatchers("我要偷东西");




    }
}
