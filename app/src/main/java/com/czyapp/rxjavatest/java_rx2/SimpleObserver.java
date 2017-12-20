package com.czyapp.rxjavatest.java_rx2;

import android.util.Log;

import java.util.Observable;
import java.util.Observer;

/**
 * Created by czy on 2017/12/19.
 * 创建一个观察者
 */

public class SimpleObserver implements Observer{

    public SimpleObserver(SimpleObservable observable){
        observable.addObserver(this);
    }

    public void update(Observable observable,Object object){
        Log.i("CZYAPP","data is change"+((SimpleObservable)observable).getData());

    }


}
