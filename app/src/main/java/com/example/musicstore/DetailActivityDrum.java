package com.example.musicstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class DetailActivityDrum extends AppCompatActivity {
    TextView detailName, detailSeri, detailPrice, detailAbout;
    ImageView detailImage;
    DatabaseReference databaseReference;
    private drums drum;

    public static final String EXTRA_HEROES = "extra_heroes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_drum);
        databaseReference = FirebaseDatabase.getInstance().getReference();

        detailName = findViewById(R.id.detailNameDrum);
        detailSeri = findViewById(R.id.detailSeriDrum);
        detailPrice = findViewById(R.id.detailPriceDrum);
        detailAbout = findViewById(R.id.detailAboutDrum);

        detailImage = (ImageView) findViewById(R.id.detailImage);
        Intent intent= getIntent();
        drum = (drums)intent.getSerializableExtra("drum");
        detailName.setText(drum.getName());
        detailSeri.setText(drum.getSeri());
        detailPrice.setText(drum.getPrice());
        detailAbout.setText(drum.getAbout());
        String DrumFileName = drum.getImage();

        String imageUri=null;
        imageUri=drum.getImage();
        Picasso.get().load(imageUri).into(detailImage);

        if(drum != null){
            detailName.setText(drum.getName());
            detailSeri.setText(drum.getSeri());
            detailPrice.setText(drum.getPrice());
            detailAbout.setText(drum.getAbout());

        } else{
        }

    }
}