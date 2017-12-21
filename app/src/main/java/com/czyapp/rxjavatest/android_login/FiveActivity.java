package com.czyapp.rxjavatest.android_login;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.czyapp.rxjavatest.R;

import java.util.HashMap;
import java.util.Map;

import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by czy on 2017/12/20.
 */

public class FiveActivity extends AppCompatActivity {

    private Button button;
    private EditText username;
    private EditText password;

    private ProgressDialog dialog;

    private LoginUtil loginUtil;

    private final String LOGIN = "http://192.168.72.196:8080/webproject/LoginAction";


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button = (Button) this.findViewById(R.id.button);
        username = (EditText) this.findViewById(R.id.editText);

        loginUtil = new LoginUtil();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Map<String,String> parms = new HashMap<String,String>();
                parms.put("username",username.getText().toString().trim());
                parms.put("password",password.getText().toString().trim());
                    loginUtil.login(LOGIN,parms).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Subscriber<String>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onError(Throwable e) {

                        }

                        @Override
                        public void onNext(String s) {
                            if (JsonUtils.parserJson(s)){
                                //Log.i(TAG,"success");
                                Intent intent = new Intent(FiveActivity.this,MainScreen.class);
                                startActivity(intent);

                            }
                        }
                    });
            }
        });

        dialog = new ProgressDialog(this);
        dialog.setTitle("login......");
    }
}
