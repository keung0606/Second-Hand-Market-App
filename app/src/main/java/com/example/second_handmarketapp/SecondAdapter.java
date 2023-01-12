package com.example.second_handmarketapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class SecondAdapter extends RecyclerView.Adapter<SecondAdapter.ViewHolder> {

    private Context context;
    private List<SecondMod> secondModList;


    public SecondAdapter(Context context,List<SecondMod> secondModList) {
        this.secondModList = secondModList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolder viewHolder = new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.sechand_product, parent, false));
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Glide.with(context).load(secondModList.get(position).getSecImg()).into(holder.popImg);
        holder.name.setText(secondModList.get(position).getName());
        holder.des.setText(secondModList.get(position).getDes());
        holder.score.setText(secondModList.get(position).getScore());
        holder.dis.setText(secondModList.get(position).getDis());

    }



    @Override
    public int getItemCount() {
        return secondModList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        ImageView popImg;
        TextView name,des,score,dis;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            popImg = itemView.findViewById(R.id.pop_img);
            name = itemView.findViewById(R.id.pop_proName);
            des = itemView.findViewById(R.id.pop_desc);
            score = itemView.findViewById(R.id.pop_score);
            dis = itemView.findViewById(R.id.pop_dis);
        }
    }
}
