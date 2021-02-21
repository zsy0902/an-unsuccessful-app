package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Adapter.MyRcViewAdapter;
import Classes.MyChoice;

public class FragmentMine extends Fragment {


    private View view;
    private Button button0;
    private List<MyChoice> list = new ArrayList<>();
    private MyRcViewAdapter myRcViewAdapter = new MyRcViewAdapter(list);

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public FragmentMine() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_mine, container, false);
        button0 = (Button) view.findViewById(R.id.button0);
        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                Toast.makeText(getActivity(), "登录...", Toast.LENGTH_SHORT).show();
            }
        });
        initMyChoice();
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(myRcViewAdapter);
        return view;
    }

    public void initMyChoice() {
        list.add(new MyChoice(R.drawable.score, "我的积分"));
        list.add(new MyChoice(R.drawable.share, "我的分享"));
        list.add(new MyChoice(R.drawable.mylike, "我的收藏"));
        list.add(new MyChoice(R.drawable.read, "稍后阅读"));
        list.add(new MyChoice(R.drawable.history, "阅读历史"));
        list.add(new MyChoice(R.drawable.github, "开源项目"));
        list.add(new MyChoice(R.drawable.settings, "系统设置"));
        myRcViewAdapter.notifyDataSetChanged();
    }
}