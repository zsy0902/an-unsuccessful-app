package com.example.myapplication;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import Adapter.HomeArticleAdapter;
import Adapter.QuestionAdapter;
import Classes.Data;
import Classes.HttpRequest;
import Classes.Question;
import okhttp3.Call;
import okhttp3.Response;


public class FragmentQuestion extends Fragment {
    private View view;
    private TextView author;
    private TextView niceDate;
    private TextView title;
    private TextView chapterName;
    private TextView desc;
    private List<Question> questionList=new ArrayList<>();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view=inflater.inflate(R.layout.fragment_question, container, false);
        author=(TextView)view.findViewById(R.id.author);
        niceDate=(TextView)view.findViewById(R.id.nice_date);
        title=(TextView)view.findViewById(R.id.title);
        chapterName=(TextView)view.findViewById(R.id.chapterName);
        desc=(TextView)view.findViewById(R.id.desc);
        HttpRequest.sendOkHttpRequest("https://wanandroid.com/wenda/list/1/json"
        , new okhttp3.Callback() {
                    @Override
                    public void onFailure(Call call, IOException e) {

                    }

                    @Override
                    public void onResponse(Call call, Response response) throws IOException {
                        String responseQuestion=response.body().string();
                        parseJSONWithGSON(responseQuestion);
                    }
                });
        QuestionAdapter questionAdapter = new QuestionAdapter(questionList);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.recycler_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(questionAdapter);
        return view;
    }
    private void parseJSONWithGSON(String jsonData) {
        try {
            JSONObject jsonObject = new JSONObject(jsonData);
            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
            JSONArray jsonArray = jsonObject1.getJSONArray("datas");
            for (int i = 0; i < jsonArray.length(); i++) {
                String dataString = jsonArray.get(i).toString();
                Question question= new Gson().fromJson(dataString, Question.class);
                questionList.add(question);//homeData是private List<Data> homeData
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}