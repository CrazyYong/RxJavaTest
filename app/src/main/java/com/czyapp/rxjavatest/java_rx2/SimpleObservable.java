package com.czyapp.rxjavatest.java_rx2;

import java.util.Observable;

/**
 * Created by czy on 2017/12/19.
 * 创建一个被观察者
 */

public class SimpleObservable extends Observable{
    private int data=0;
    public int getData(){

        return data;
    }


    public void setData(int i){
        if(this.data!=i){
            this.data=i;
            setChanged();
            notifyObservers();//通知观察者，表示状态发生改变

        }
    }

}
