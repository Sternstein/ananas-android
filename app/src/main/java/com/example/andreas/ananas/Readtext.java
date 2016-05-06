package com.example.andreas.ananas;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.URI;

public class Readtext extends AppCompatActivity {
    TextView tRead;
    ImageView imV;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readtext);
        TextView tRead  = (TextView) findViewById(R.id.tRead);
        ImageView imV = (ImageView) findViewById(R.id.imV);

        Intent intent = getIntent();
        String l = intent.getStringExtra("l");

        tRead.setText(l);

    }
}
