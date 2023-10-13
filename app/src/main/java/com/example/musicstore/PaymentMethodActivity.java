package com.example.musicstore;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PaymentMethodActivity extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_method);

        button = (Button) findViewById(R.id.confirm_payment_method);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openOrderDetailActivity();
            }
        });
    }

    public void openOrderDetailActivity(){
        Intent intent = new Intent(this, OrderDetailActivity.class);
        startActivity(intent);
    }
}