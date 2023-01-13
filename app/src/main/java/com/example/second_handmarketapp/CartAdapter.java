package com.example.second_handmarketapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.ViewHolder> {

    Context context;
    List<cartMod> cartModList;

    public CartAdapter(Context context, List<cartMod> cartModList){
        this.context = context;
        this.cartModList = cartModList;
    }

    @NonNull
    @Override
    public CartAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cart_products,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull CartAdapter.ViewHolder holder, int position) {
        holder.name.setText(cartModList.get(position).getName());
        holder.des.setText(cartModList.get(position).getIntroduction());
        holder.score.setText(cartModList.get(position).getScore());
        holder.time.setText(cartModList.get(position).getTime());
        holder.price.setText(cartModList.get(position).getPrice());

    }

    @Override
    public int getItemCount() {
        return cartModList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView name,price,des,score,date,time;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            price = itemView.findViewById(R.id.cart_price);
            name = itemView.findViewById(R.id.cart_name);
            score = itemView.findViewById(R.id.cart_score);
            des = itemView.findViewById(R.id.cart_des);
            time = itemView.findViewById(R.id.cart_time);


        }
    }
}
