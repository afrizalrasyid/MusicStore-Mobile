package com.example.musicstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class TotalTransactionActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_total_transaction);

        button = (Button) findViewById(R.id.detail_total_transaction);
        imageView = (ImageView) findViewById(R.id.back_total_transaction);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOrderDetailActivity2();
            }
        });

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNavbarActivity2();
            }
        });
    }

    public void openOrderDetailActivity2(){
        Intent intent = new Intent(this, OrderDetailActivity.class);
        startActivity(intent);
    }

    public void openNavbarActivity2(){
        Intent intent = new Intent(this, NavbarActivity.class);
        startActivity(intent);
    }
}