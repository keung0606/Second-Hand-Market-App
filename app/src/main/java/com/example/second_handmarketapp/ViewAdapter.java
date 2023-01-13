package com.example.second_handmarketapp;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class ViewAdapter extends RecyclerView.Adapter<ViewAdapter.ViewHolder> {

    private Context context;
    private List<ViewMod> viewModList;


    public ViewAdapter(Context context,List<ViewMod> viewModList) {
        this.viewModList = viewModList;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewAdapter.ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.view_products,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewAdapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
        Glide.with(context).load(viewModList.get(position).getView_img()).into(holder.view_img);
        holder.name.setText(viewModList.get(position).getName());
        holder.des.setText(viewModList.get(position).getDes());
        holder.price.setText("$ "+viewModList.get(position).getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context,InfoProduct.class);
                intent.putExtra("info",viewModList.get(position));
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return viewModList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView view_img;
        TextView name,des,price,score, type;
        public ViewHolder(@NonNull View itemView) {


            super(itemView);
            view_img = itemView.findViewById(R.id.viewImage);
            name = itemView.findViewById(R.id.viewName);
            price = itemView.findViewById(R.id.viewPrice);
            des = itemView.findViewById(R.id.viewDes);
            score = itemView.findViewById(R.id.viewScore);
        }
    }
}
