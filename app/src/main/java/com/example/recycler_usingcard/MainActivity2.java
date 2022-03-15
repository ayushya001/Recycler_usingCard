package com.example.recycler_usingcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
    ImageView imageView;
    TextView t3,t4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        imageView = findViewById(R.id.im1);
        t3 = findViewById(R.id.t3);
        t4 = findViewById(R.id.t4);

        imageView.setImageResource(getIntent().getIntExtra("imagename",0));
        t3.setText(getIntent().getStringExtra("header"));
        t4.setText(getIntent().getStringExtra("desc"));
    }
}