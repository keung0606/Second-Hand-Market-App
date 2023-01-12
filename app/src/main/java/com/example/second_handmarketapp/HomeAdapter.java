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

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    Context context;
    List<SecondCat> secondCatList;

    public HomeAdapter(Context context, List<SecondCat> secondCatList) {
        this. context = context;
        this.secondCatList = secondCatList;


    }
    @NonNull
    @Override
    public HomeAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.second_cat,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull HomeAdapter.ViewHolder holder, int position) {

        Glide.with(context).load(secondCatList.get(position).getCatImg()).into(holder.catImg);
        holder.name.setText(secondCatList.get(position).getName());

    }

    @Override
    public int getItemCount() {
        return secondCatList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView catImg;
        TextView name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            catImg = itemView.findViewById(R.id.secCat_img);
            name = itemView.findViewById(R.id.secCat_name);


        }
    }
}
