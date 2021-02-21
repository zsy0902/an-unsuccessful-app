package Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

import Classes.Data;

public class HomeArticleAdapter extends RecyclerView.Adapter<HomeArticleAdapter.ViewHolder> {
    private List<Data> homeData;
    private View view;
    private Context context;
    public HomeArticleAdapter(List<Data> homeData){
        this.homeData=homeData;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view= LayoutInflater.from(parent.getContext()).inflate(R.layout.home_articleitem,
                parent,false);
        final ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Data data=homeData.get(position);
        viewHolder.author.setText(data.getAuthor());
        viewHolder.niceDate.setText(data.getPublishTime());
        viewHolder.title.setText(data.getTitle());
        viewHolder.chapterName.setText(data.getChapterName());
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
            }
        });

    }

    @Override
    public int getItemCount() {
        return homeData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView author,niceDate,title,chapterName;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            author=(TextView)itemView.findViewById(R.id.author);
            niceDate=(TextView)itemView.findViewById(R.id.nice_date);
            title=(TextView)itemView.findViewById(R.id.title);
            chapterName=(TextView)itemView.findViewById(R.id.chapterName);
        }
    }
}