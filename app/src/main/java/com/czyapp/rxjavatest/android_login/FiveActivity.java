package com.czyapp.rxjavatest.android_login;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;

import com.czyapp.rxjavatest.R;

/**
 * Created by czy on 2017/12/20.
 */

public class FiveActivity extends AppCompatActivity {

    private Button button;
    private EditText username;
    private EditText password;

    private ProgressDialog dialog;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button = (Button) this.findViewById(R.id.button);
        username = (EditText) this.findViewById(R.id.editText);

        dialog = new ProgressDialog(this);
        dialog.setTitle("login......");
    }
}
