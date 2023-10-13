package com.example.musicstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ProductActivity extends AppCompatActivity {
    private ImageView imageView1, imageView2;
    private Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        imageView1 = (ImageView) findViewById(R.id.back_product);
        imageView2 = (ImageView) findViewById(R.id.cart_product);
        button = (Button) findViewById(R.id.order_product);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openNavbarActivity();
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTotalTransactionActivity();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOrderDetailsActivity();
            }
        });
    }

    public void openNavbarActivity(){
        Intent intent = new Intent(this, NavbarActivity.class);
        startActivity(intent);
    }

    public void openTotalTransactionActivity(){
        Intent intent = new Intent(this, TotalTransactionActivity.class);
        startActivity(intent);
    }

    public void openOrderDetailsActivity(){
        Intent intent = new Intent(this, OrderDetailActivity.class);
        startActivity(intent);
    }

}