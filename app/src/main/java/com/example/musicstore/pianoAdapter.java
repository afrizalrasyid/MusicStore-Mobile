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

public class pianoAdapter extends RecyclerView.Adapter<pianoAdapter.PianoViewHolder> {
    Context context;
    ArrayList<pianos> ListPiano;

    public pianoAdapter(Context context, ArrayList<pianos> ListPiano) {
        this.context = context;
        this.ListPiano = ListPiano;
    }

    @NonNull
    @Override
    public PianoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_item_piano, parent, false);
        return new PianoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PianoViewHolder holder, @SuppressLint("RecyclerView") int position) {
        pianos piano = ListPiano.get(position);

        holder.piano_name.setText(piano.getName());
        holder.piano_seri.setText(piano.getSeri());
        holder.piano_price.setText(piano.getPrice());
        holder.piano_about.setText(piano.getAbout());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivityPiano.class);
                intent.putExtra("piano",(Serializable) ListPiano.get(position));
                context.startActivity(intent);
            }
        });

        String imageUri = null;
        imageUri = piano.getImage();
        Picasso.get().load(imageUri).into(holder.pianoImageView);
    }

    @Override
    public int getItemCount() {
        return ListPiano.size();
    }

    public static class PianoViewHolder extends RecyclerView.ViewHolder{
        ImageView pianoImageView;
        TextView piano_name, piano_seri, piano_price, piano_about;
        CardView cardView;
        public PianoViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView = itemView.findViewById(R.id.piano_cards);
            pianoImageView = itemView.findViewById(R.id.piano_image);
            piano_name = itemView.findViewById(R.id.piano_name);
            piano_seri = itemView.findViewById(R.id.piano_seri);
            piano_price = itemView.findViewById(R.id.piano_price);
            piano_about = itemView.findViewById(R.id.piano_about);
        }
    }
}
