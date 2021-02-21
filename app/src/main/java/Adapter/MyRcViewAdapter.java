package Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;

import java.util.List;

import Classes.MyChoice;

public class MyRcViewAdapter extends RecyclerView.Adapter<MyRcViewAdapter.ViewHolder> {
    private List<MyChoice> myChoiceList;
    private View view;
    private Context context;
    public MyRcViewAdapter(List<MyChoice> myChoiceList){
        this.myChoiceList=myChoiceList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view= LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view,
                parent,false);
        ViewHolder viewHolder=new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {
        MyChoice myChoice=myChoiceList.get(position);
        viewHolder.imageView1.setImageResource(myChoice.getIconId());
        viewHolder.textView.setText(myChoice.getText());
        viewHolder.imageView2.setImageResource(R.drawable.go);

    }

    @Override
    public int getItemCount() {
        return myChoiceList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder{
        ImageView imageView1,imageView2;
        TextView textView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView1=(ImageView) itemView.findViewById(R.id.imageView1);
            imageView2=(ImageView) itemView.findViewById(R.id.imageView2);
            textView=(TextView)itemView.findViewById(R.id.text_view);
        }
    }
}
