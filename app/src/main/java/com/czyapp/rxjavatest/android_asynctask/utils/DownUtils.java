package com.czyapp.rxjavatest.android_asynctask.utils;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import rx.Observable;
import rx.Subscriber;

/**
 * Created by czy on 2017/12/19.
 */

public class DownUtils {

    private OkHttpClient client;

    public DownUtils(){
        client=new OkHttpClient();
    }

    /**
     * 声明一个被观察者对象，作为结果返回
     * @param path
     * @return
     */
    public Observable<byte[]> downLoadImage(final String path){
        return Observable.create(new Observable.OnSubscribe<byte[]>() {
            @Override
            public void call(final Subscriber<? super byte[]> subscriber) {
           if(!subscriber.isUnsubscribed()){
                 //访问网络操作
               Request request = new Request.Builder().url(path).build();
               client.newCall(request).enqueue(new Callback() {
                   @Override
                   public void onFailure(Call call, IOException e) {
             subscriber.onError(e);
                   }

                   @Override
                   public void onResponse(Call call, Response response) throws IOException {
                    if(response.isSuccessful()){
                        byte[] data = response.body().bytes();
                        if(data!=null){
                            subscriber.onNext(data);
                        }
                    }
                       subscriber.onCompleted();
                   }
               });


           }
            }
        });
    }
}
