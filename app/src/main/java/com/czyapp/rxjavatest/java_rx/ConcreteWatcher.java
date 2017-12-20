package com.czyapp.rxjavatest.java_rx;

import android.util.Log;

/**
 * Created by luoliwen on 16/5/31.
 */
public class ConcreteWatcher implements Watcher {
    @Override
    public void update(String str) {
        Log.i("CZYAPP",str);
    }
}
