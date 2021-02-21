package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Adapter.HomeArticleAdapter;
import Classes.Data;
import Classes.HttpRequest;
import okhttp3.Call;
import okhttp3.Response;


public class FragmentMain extends Fragment {
    private View view;
    private List<Data> homeData=new ArrayList<>();
    private TextView author;
    private TextView niceDate;
    private TextView title;
    private TextView chapterName;
    private ImageView imageView2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_main, container, false);
        author=(TextView)view.findViewById(R.id.author);
        niceDate=(TextView)view.findViewById(R.id.nice_date);
        title=(TextView)view.findViewById(R.id.title);
        chapterName=(TextView)view.findViewById(R.id.chapterName);
        imageView2=(ImageView)view.findViewById(R.id.image_view2);
        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(),SearchActivity.class);
                startActivity(intent);
            }
        });

        HttpRequest.sendOkHttpRequest(
                "https://www.wanandroid.com/article/list/0/json"
                , new okhttp3.Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String responseData = response.body().string();
                        parseJSONWithGSON(responseData);
                    }
                });
        HomeArticleAdapter homeArticleAdapter = new HomeArticleAdapter(homeData);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view1);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(homeArticleAdapter);
        return view;
    }

    private void parseJSONWithGSON(String jsonData) {
        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
            JSONArray jsonArray = jsonObject1.getJSONArray("datas");
            for (int i = 0; i < jsonArray.length(); i++) {
                String dataString = jsonArray.get(i).toString();
                Data data = new Gson().fromJson(dataString, Data.class);
                homeData.add(data);//homeData是private List<Data> homeData
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}