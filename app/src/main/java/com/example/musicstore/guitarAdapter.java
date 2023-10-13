package com.example.musicstore;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.io.Serializable;
import java.util.ArrayList;

public class guitarAdapter extends RecyclerView.Adapter<guitarAdapter.GuitarViewHolder> {
    Context context;
    ArrayList<guitars> ListGuitar;

    public guitarAdapter(Context context, ArrayList<guitars> ListGuitar) {
        this.context = context;
        this.ListGuitar = ListGuitar;
    }

    @NonNull
    @Override
    public GuitarViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_guitar, parent, false);
        return new GuitarViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GuitarViewHolder holder, @SuppressLint("RecyclerView") int position) {
        guitars guitar = ListGuitar.get(position);

        holder.guitar_name.setText(guitar.getName());
        holder.guitar_seri.setText(guitar.getSeri());
        holder.guitar_price.setText(guitar.getPrice());
        holder.guitar_about.setText(guitar.getAbout());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivityGuitar.class);
                intent.putExtra("guitar",(Serializable) ListGuitar.get(position));
                context.startActivity(intent);
            }
        });

        String imageUri = null;
        imageUri = guitar.getImage();
        Picasso.get().load(imageUri).into(holder.guitarImageView);
    }

    @Override
    public int getItemCount() {
        return ListGuitar.size();
    }

    public static class GuitarViewHolder extends RecyclerView.ViewHolder{
        ImageView guitarImageView;
        TextView guitar_name, guitar_seri, guitar_price, guitar_about;
        CardView cardView;
        public GuitarViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.guitar_cards);
            guitarImageView = itemView.findViewById(R.id.guitar_image);
            guitar_name = itemView.findViewById(R.id.guitar_name);
            guitar_seri = itemView.findViewById(R.id.guitar_seri);
            guitar_price = itemView.findViewById(R.id.guitar_price);
            guitar_about = itemView.findViewById(R.id.guitar_about);
        }
    }
}
