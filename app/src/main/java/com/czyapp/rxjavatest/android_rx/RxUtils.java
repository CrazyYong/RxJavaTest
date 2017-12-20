package com.czyapp.rxjavatest.android_rx;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import rx.Observable;
import rx.Subscriber;
import rx.functions.Action1;
import rx.functions.Func1;
import rx.schedulers.Schedulers;

/**
 * Created by czy on 2017/12/19.
 */

public class RxUtils {

    public static String TAG="CZYAPP";

    /**
     * 第一种方式：使用create方式
     */
    public static void createObserable() {

        /**
         * 被观察者
         */
        Observable<String> observable = Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                if(!subscriber.isUnsubscribed()){
                    subscriber.onNext("Hello");
                    subscriber.onNext("hi");
                    subscriber.onNext("嘿嘿");
                    subscriber.onNext(downLoadJson());
                    subscriber.onCompleted();
                }
            }
        });


        /**
         * 观察者
         */
        Subscriber<String> showsub = new Subscriber<String>() {
            @Override
            public void onCompleted() {
//正常终止，如果没有遇到错误，Observable在最后一次调用onNext之后调用此方法
                Log.i(TAG,"onCompleted");
            }

            @Override
            public void onError(Throwable e) {
//当Observable遇到错误或无法返回期望的数据时会调用这个方法，这个调用会终止Observable,后续不会再调用onNext和onCompleted
                //onError方法的参数是抛出的异常
                Log.i(TAG,"onError");
            }

            @Override
            public void onNext(String s) {
       //Observable调用这个方法发射数据，方法参数就是Observable发射的数据，这个方法可能会被调用多次，取决于你的实现
                Log.i(TAG,"onNext---"+s);
            }
        };

        observable.subscribe(showsub);//关联被观察者
    }

    public static String downLoadJson(){

        return "json data";
    }

    /**
     * 第二种方式
     */
    public static void createPrint(){
        Observable.create(new Observable.OnSubscribe<Integer>(){
            @Override
            public void call(Subscriber<? super Integer> subscriber) {
                if(!subscriber.isUnsubscribed()){
                    for(int i=1;i<10;i++){
                        subscriber.onNext(i);
                    }
                    subscriber.onCompleted();
                }
            }
        }).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                Log.i(TAG,"onCompleted");
            }

            @Override
            public void onError(Throwable e) {
                Log.i(TAG,e.getMessage());
            }

            @Override
            public void onNext(Integer integer) {
                Log.i(TAG,"onNext"+integer);
            }
        });
    }

    /**
     * 使用在被观察者，返回的对象一般都是数值类型
     */
    public static void from(){
        Integer[] intems = {1,2,3,4,5,6,7,8,9};
        Observable observable = Observable.from(intems);
        observable.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                Log.i(TAG,o.toString());
            }
        });
    }

    /**
     * 指定某一时刻进行数据发送
     */
    public static void interval(){
        Integer[] intems={1,2,3,4};
        Observable observable = Observable.interval(1,1, TimeUnit.SECONDS);//每一个发送数据间隔一秒发送一次
        observable.subscribe(new Action1() {
            @Override
            public void call(Object o) {
                Log.i(TAG,o.toString());
            }
        });
    }

    /**
     * 处理数组集合
     */
    public static void just(){
        Integer[] intems1={1,2,3,4,6};
        Integer[] intems2={3,4,5,6,7,8};
        Observable observable = Observable.just(intems1,intems2);
        observable.subscribe(new Subscriber<Integer[]>() {
            @Override
            public void onCompleted() {
                Log.i(TAG,"onCompleted--");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer[] o) {
             for(int i=0;i<o.length;i++){
                 Log.i(TAG,o[i].toString());
             }
            }
        });
    }

    /**
     * 指定范围数据，指定数据输出的范围
     */
    public static void range(){
        Observable observable = Observable.range(1,40);
        observable.subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {
                Log.i(TAG,"onCompleted--");
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer o) {
                Log.i(TAG,o.toString());
            }
        });
    }

    /**
     * 使用过滤功能
     */
    public static void filter(){
        Observable observable= Observable.just(1,2,3,5,6);
        observable.filter(new Func1<Integer,Boolean>() {
            @Override
            public Boolean call(Integer o) {

                return o<5;
            }
        }).observeOn(Schedulers.io()).subscribe(new Subscriber<Integer>() {
            @Override
            public void onCompleted() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(Integer o) {
                Log.i(TAG,o.toString());
            }
        });
    }

}
