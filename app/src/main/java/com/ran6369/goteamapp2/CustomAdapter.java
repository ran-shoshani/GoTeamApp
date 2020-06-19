package com.ran6369.goteamapp2;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.MyViewHolder> {

    private Context context;
    private ArrayList task_id, task_title;



    CustomAdapter(Context context, ArrayList task_id, ArrayList task_title){
        this.context = context;
        this.task_id = task_id;
        this.task_title = task_title;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_item_view, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {
        holder.task_id_txt.setText(String.valueOf(task_id.get(position)));
        holder.task_title_txt.setText(String.valueOf(task_title.get(position)));
        holder.mainLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Intent intent = new Intent(context, UpdateActivity.class);
                //intent.putExtra("id", String.valueOf(task_id.get(position)));
                //intent.putExtra("title", String.valueOf(task_title.get(position)));
                //context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return task_id.size();
    }

     class MyViewHolder extends RecyclerView.ViewHolder {

        TextView task_id_txt, task_title_txt;
        LinearLayout mainLayout;

         MyViewHolder(@NonNull View itemView) {
            super(itemView);
            task_id_txt = itemView.findViewById(R.id.task_id_txt);
            task_title_txt = itemView.findViewById(R.id.task_title_txt);
            mainLayout = itemView.findViewById(R.id.mainLayout);
        }
    }


}
