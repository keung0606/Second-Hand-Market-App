package com.example.second_handmarketapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class CatRecAdapter extends RecyclerView.Adapter<CatRecAdapter.ViewHolder> {

    Context context;
    List<CatModel> catModList;

    public CatRecAdapter(Context context, List<CatModel> catModList){
        this.context = context;
        this. catModList = catModList;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cat_item,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CatRecAdapter.ViewHolder holder, int position) {
        Glide.with(context).load(catModList.get(position).getCat_img()).into(holder.cat_img);
        holder.name.setText(catModList.get(position).getName());
        holder.des.setText(catModList.get(position).getDes());
        holder.dis.setText(catModList.get(position).getDis());

    }

    @Override
    public int getItemCount() {
        return catModList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView cat_img;
        TextView des,dis,name;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            cat_img = itemView.findViewById(R.id.catImage);
            name = itemView.findViewById(R.id.catName);
            dis = itemView.findViewById(R.id.catDis);
            des = itemView.findViewById(R.id.catDes);
        }
    }
}
