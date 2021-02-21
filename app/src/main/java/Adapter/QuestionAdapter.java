package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

import Classes.Question;


public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder> {
    private List<Question> questionList;
    private View view;
    private Context context;
    public QuestionAdapter(List<Question> questionList){
        this.questionList=questionList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view= LayoutInflater.from(parent.getContext()).inflate(R.layout.question_item,
                parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        Question question=questionList.get(position);
        viewHolder.author.setText(question.getAuthor());
        viewHolder.niceDate.setText(question.getPublishTime());
        viewHolder.title.setText(question.getTitle());
        viewHolder.chapterName.setText(question.getChapterName());
        viewHolder.desc.setText(question.getDesc());

    }

    @Override
    public int getItemCount() {
        return questionList.size();
    }
    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView author,niceDate,title,chapterName,desc;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            author=(TextView)itemView.findViewById(R.id.author);
            niceDate=(TextView)itemView.findViewById(R.id.nice_date);
            title=(TextView)itemView.findViewById(R.id.title);
            chapterName=(TextView)itemView.findViewById(R.id.chapterName);
            desc=(TextView)itemView.findViewById(R.id.desc);

        }
    }
}
