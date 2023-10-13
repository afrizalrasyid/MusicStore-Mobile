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

public class drumAdapter extends RecyclerView.Adapter<drumAdapter.DrumViewHolder> {
    Context context;
    ArrayList<drums> ListDrum;

    public drumAdapter(Context context, ArrayList<drums> ListDrum) {
        this.context = context;
        this.ListDrum = ListDrum;
    }

    @NonNull
    @Override
    public DrumViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_drum, parent, false);
        return new DrumViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DrumViewHolder holder, @SuppressLint("RecyclerView") int position) {
        drums drum = ListDrum.get(position);

        holder.drum_name.setText(drum.getName());
        holder.drum_seri.setText(drum.getSeri());
        holder.drum_price.setText(drum.getPrice());
        holder.drum_about.setText(drum.getAbout());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivityDrum.class);
                intent.putExtra("drum",(Serializable) ListDrum.get(position));
                context.startActivity(intent);
            }
        });

        String imageUri = null;
        imageUri = drum.getImage();
        Picasso.get().load(imageUri).into(holder.drumImageView);
    }

    @Override
    public int getItemCount() {
        return ListDrum.size();
    }

    public static class DrumViewHolder extends RecyclerView.ViewHolder{
        ImageView drumImageView;
        TextView drum_name, drum_seri, drum_price, drum_about;
        CardView cardView;
        public DrumViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.drum_cards);
            drumImageView = itemView.findViewById(R.id.drum_image);
            drum_name = itemView.findViewById(R.id.drum_name);
            drum_seri = itemView.findViewById(R.id.drum_seri);
            drum_price = itemView.findViewById(R.id.drum_price);
            drum_about = itemView.findViewById(R.id.drum_about);
        }
    }
}
