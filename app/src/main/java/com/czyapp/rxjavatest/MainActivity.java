package com.czyapp.rxjavatest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

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
