package com.example.retrofit_java;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.w3c.dom.Text;

import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecycViewHolder> {
   Context context;
   List<Source> sourceList;

    public RecyclerAdapter(Context context, List<Source> sourceList) {
        this.context = context;
        this.sourceList = sourceList;
    }

    @NonNull
    @Override
    public RecyclerAdapter.RecycViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new RecycViewHolder(LayoutInflater.from(context).inflate(R.layout.list_item,parent,false ));
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecycViewHolder holder, int position) {
           holder.textView.setText(sourceList.get(position).getBody());
    }

    @Override
    public int getItemCount() {
        return sourceList.size();
    }

    public class RecycViewHolder extends RecyclerView.ViewHolder{
        TextView textView;
        public RecycViewHolder(@NonNull View itemView) {

            super(itemView);
            textView=(TextView) itemView.findViewById(R.id.source_data);
        }
    }
}
