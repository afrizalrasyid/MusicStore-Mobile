package com.example.musicstore;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import java.util.ArrayList;
import java.util.List;

public class DrumProductActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private drumAdapter itemAdapter;
    private List<drums> ListDrum;
    private DatabaseReference databaseReference;
    private ImageView imageView;
    FloatingActionButton fab;

    ValueEventListener eventListener;

    @Override
    protected void onStart() {
        overridePendingTransition(0, 0);
        super.onStart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drum_product);
        initializeViews();
        setupRecyclerView();
        retrieveItemDataFromFirebase();
//        fab = (FloatingActionButton) findViewById(R.id.fab);
        imageView = (ImageView) findViewById(R.id.fragmentCategory);

//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(GuitarProductActivity.this, UploadActivity.class);
//                startActivity(intent);
//            }
//        });
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                openNavbarActivity();
            }
        });

    }

    private void initializeViews() {
        recyclerView = findViewById(R.id.drcard);
    }

    private void setupRecyclerView() {
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(
                new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL)
        );
        ListDrum = new ArrayList<>();
        itemAdapter = new drumAdapter((Context) this, (ArrayList<drums>) ListDrum);
        recyclerView.setAdapter(itemAdapter);
    }

    private void retrieveItemDataFromFirebase() {
        databaseReference = FirebaseDatabase.getInstance().getReference().child("product_drum");
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ListDrum.clear();
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    String name = snapshot.child("name").getValue(String.class);
                    String seri = snapshot.child("seri").getValue(String.class);
                    String price = snapshot.child("price").getValue(String.class);
                    String about = snapshot.child("about").getValue(String.class);
                    String image = snapshot.child("image").getValue(String.class);

                    drums drum = new drums(name, seri, price, about, image);
                    ListDrum.add(drum);
                }
                itemAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.d("fragment_category", "Database Error: " + databaseError.getMessage());
            }
        });
    }

    public void openNavbarActivity(){
        Intent intent = new Intent(this, NavbarActivity.class);
        startActivity(intent);
    }
}