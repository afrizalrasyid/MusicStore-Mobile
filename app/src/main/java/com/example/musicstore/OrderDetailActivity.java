package com.example.musicstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class OrderDetailActivity extends AppCompatActivity {
    private ImageView imageView1, imageView2;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_detail);

        imageView1 = (ImageView) findViewById(R.id.back_order_detail);
        imageView2 = (ImageView) findViewById(R.id.payment_method);
        button = (Button) findViewById(R.id.place_order_detail);

        imageView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPageProductActivity();
            }
        });

        imageView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openPaymentMethodActivity();
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openTotalTransactionActivity();
            }
        });
    }

    public void openPageProductActivity(){
        Intent intent = new Intent(this, ProductActivity.class);
        startActivity(intent);
    }

    public void openTotalTransactionActivity(){
        Intent intent = new Intent(this, TotalTransactionActivity.class);
        startActivity(intent);
    }

    public void openPaymentMethodActivity(){
        Intent intent = new Intent(this, PaymentMethodActivity.class);
        startActivity(intent);
    }

}