package com.example.musicstore;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link wishlist#newInstance} factory method to
 * create an instance of this fragment.
 */
public class wishlist extends Fragment {
    private DatabaseReference databaseReference;
    Button submitButton;
    private EditText submitName, submitEmail, submitMessage;


    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public wishlist() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_wishlist, container, false);

        submitName = view.findViewById(R.id.submitName);
        submitEmail = view.findViewById(R.id.submitEmail);
        submitMessage = view.findViewById(R.id.submitMessage);

        Button submitButton = view.findViewById(R.id.submitButton);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submitData();
            }
        });

        return view;
    }

    private void submitData() {
        String name = submitName.getText().toString().trim();
        String email = submitEmail.getText().toString().trim();
        String message = submitMessage.getText().toString().trim();

        // Validasi input
        if (TextUtils.isEmpty(name)) {
            submitName.setError("Insert Name");
            return;
        }

        if (TextUtils.isEmpty(email)) {
            submitEmail.setError("Insert Email");
            return;
        }

        if (TextUtils.isEmpty(message)) {
            submitMessage.setError("Insert Message");
            return;
        }

        // Membuat objek data yang akan ditambahkan
        contact contact = new contact(name, email, message);

        // Menambahkan data ke database Firebase
        databaseReference.child("Contact").push().setValue(contact);

        // Reset input
        submitName.setText("");
        submitEmail.setText("");
        submitMessage.setText("");
    }

    public static wishlist newInstance(String param1, String param2) {
        wishlist fragment = new wishlist();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        databaseReference = FirebaseDatabase.getInstance().getReference();



        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
    
}