package com.example.dell.fcmtest;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.squareup.picasso.Picasso;

public class MoreInfoNotification extends AppCompatActivity {

    private TextView mvalueView;
    private Firebase mRef;

    private TextView url;
    private ImageView img;


    private FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
    private DatabaseReference reference=firebaseDatabase.getReference();
    private  DatabaseReference childrefrence=reference.child("url");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_info_notification2);
        String user = getIntent().getStringExtra("user");

        url = (TextView) findViewById(R.id.text);
        img = (ImageView) findViewById(R.id.image);
        mvalueView = (TextView) findViewById(R.id.textView);


        mRef = new Firebase("https://chitraka-c28e1.firebaseio.com/Name");


        mRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String value = dataSnapshot.getValue(String.class);
                mvalueView.setText(value);


            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }

        });

    }
    @Override
    protected void onStart() {
        super.onStart();
        childrefrence.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(@NonNull com.google.firebase.database.DataSnapshot dataSnapshot)
            {
                String message=dataSnapshot.getValue(String.class);
                url.setText(message);
                Picasso.get()
                        .load(message)
                        .into(img);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}






