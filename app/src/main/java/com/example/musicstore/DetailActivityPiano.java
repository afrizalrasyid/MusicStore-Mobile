package com.example.musicstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class DetailActivityPiano extends AppCompatActivity {
    TextView detailName, detailSeri, detailPrice, detailAbout;
    ImageView detailImage;
    DatabaseReference databaseReference;
    private pianos piano;


    public static final String EXTRA_HEROES = "extra_heroes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_piano);
        databaseReference = FirebaseDatabase.getInstance().getReference();

        detailName = findViewById(R.id.detailNamePiano);
        detailSeri = findViewById(R.id.detailSeriPiano);
        detailPrice = findViewById(R.id.detailPricePiano);
        detailAbout = findViewById(R.id.detailAboutPiano);

        detailImage = (ImageView) findViewById(R.id.detailImage);
        Intent intent= getIntent();
        piano = (pianos)intent.getSerializableExtra("piano");
        detailName.setText(piano.getName());
        detailSeri.setText(piano.getSeri());
        detailPrice.setText(piano.getPrice());
        detailAbout.setText(piano.getAbout());
        String PianoFileName = piano.getImage();

        String imageUri=null;
        imageUri=piano.getImage();
        Picasso.get().load(imageUri).into(detailImage);

        if(piano != null){
            detailName.setText(piano.getName());
            detailSeri.setText(piano.getSeri());
            detailPrice.setText(piano.getPrice());
            detailAbout.setText(piano.getAbout());

        } else{
        }

    }
}