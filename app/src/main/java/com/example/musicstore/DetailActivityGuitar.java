package com.example.musicstore;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class DetailActivityGuitar extends AppCompatActivity {
    TextView detailName, detailSeri, detailPrice, detailAbout;
    ImageView detailImage;
    DatabaseReference databaseReference;
    private guitars guitar;

    public static final String EXTRA_HEROES = "extra_heroes";

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_guitar);
        databaseReference = FirebaseDatabase.getInstance().getReference();

        detailName = findViewById(R.id.detailNameGuitar);
        detailSeri = findViewById(R.id.detailSeriGuitar);
        detailPrice = findViewById(R.id.detailPriceGuitar);
        detailAbout = findViewById(R.id.detailAboutGuitar);

        detailImage = (ImageView) findViewById(R.id.detailImage);
        Intent intent= getIntent();
        guitar = (guitars)intent.getSerializableExtra("guitar");
        detailName.setText(guitar.getName());
        detailSeri.setText(guitar.getSeri());
        detailPrice.setText(guitar.getPrice());
        detailAbout.setText(guitar.getAbout());
        String GuitarFileName = guitar.getImage();

        String imageUri=null;
        imageUri=guitar.getImage();
        Picasso.get().load(imageUri).into(detailImage);

        if(guitar != null){
            detailName.setText(guitar.getName());
            detailSeri.setText(guitar.getSeri());
            detailPrice.setText(guitar.getPrice());
            detailAbout.setText(guitar.getAbout());

        } else{
        }

    }
}