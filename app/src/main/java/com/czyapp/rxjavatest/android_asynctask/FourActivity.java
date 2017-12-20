package com.czyapp.rxjavatest.android_asynctask;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.czyapp.rxjavatest.R;
import com.czyapp.rxjavatest.android_asynctask.utils.DownUtils;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by czy on 2017/12/19.
 */
/**
 * 在实际的开发中Activity 充当的角色太多了：
 * 1、UI主线程负责绘制 UI
 * 2、开启子线程获取网络数据
 * 3、赋值到控件中
 * 4、逻辑判断等等
 */
public class FourActivity extends AppCompatActivity {
    private Button btn_download;
    private ImageView imageView;
    private String PATH = "http://pic32.nipic.com/20130829/12906030_124355855000_2.png";
    private DownUtils utils;
    /**
     * 传统方式采用handler 结合了activity使用
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_asynctask);
        btn_download=(Button)findViewById(R.id.btn_download);
        imageView=(ImageView)findViewById(R.id.imageView);
        utils = new DownUtils();
        btn_download.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
 utils.downLoadImage(PATH).observeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<byte[]>() {
     @Override
     public void onCompleted() {
    Log.i("CZYAPP","onCompleted");
     }

     @Override
     public void onError(Throwable e) {

     }

     @Override
     public void onNext(byte[] bytes) {
         Bitmap bitmap = BitmapFactory.decodeByteArray(bytes,0,bytes.length);
         imageView.setImageBitmap(bitmap);
         Log.i("CZYAPP",bitmap.toString());
     }
 });
            }
        });

    }
}
