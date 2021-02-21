package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.Toast;

import com.example.myapplication.ViewPagerActivity.VPagerAdapter;

import java.util.List;

public class LoginActivity extends AppCompatActivity {
    private Button button1;
    private ImageButton imabutton1;
    private ImageButton imabutton2;
    private ImageButton imabutton3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().setStatusBarColor(Color.GRAY);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        button1 = (Button) findViewById(R.id.button1);
        imabutton1 = (ImageButton) findViewById(R.id.imabutton1);
        imabutton2 = (ImageButton) findViewById(R.id.imabutton2);
        imabutton3 = (ImageButton) findViewById(R.id.imabutton3);
        setClickListener();
    }

    public void setClickListener() {
        OnClick onClick = new OnClick();
        button1.setOnClickListener(onClick);
        imabutton1.setOnClickListener(onClick);
        imabutton2.setOnClickListener(onClick);
        imabutton3.setOnClickListener(onClick);
    }

    class OnClick implements View.OnClickListener {
        private Intent intent = null;

        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.button1: {
                    intent = new Intent(LoginActivity.this, RegisterActivity.class);
                    startActivity(intent);
                    break;
                }
                case R.id.imabutton1:
                    Toast.makeText(LoginActivity.this, "QQ登录...", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.imabutton2:
                    Toast.makeText(LoginActivity.this, "微信登录...", Toast.LENGTH_SHORT).show();
                    break;
                case R.id.imabutton3:
                    Toast.makeText(LoginActivity.this, "微博登录...", Toast.LENGTH_SHORT).show();
                    break;
            }
        }
    }
}