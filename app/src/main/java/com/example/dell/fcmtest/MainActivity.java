package com.example.dell.fcmtest;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button button;

    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        button = (Button) findViewById(R.id.btn);

        button.setOnClickListener(this);

    }
    @Override
    public void onClick(View v)
    {
        Intent intent=new Intent(MainActivity.this,MoreInfoNotification.class);
        int user=0;
        intent.putExtra("user",user);
        startActivity(intent);
       // finish();

    }


}
