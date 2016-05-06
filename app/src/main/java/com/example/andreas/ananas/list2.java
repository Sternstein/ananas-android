package com.example.andreas.ananas;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class list2 extends AppCompatActivity {
    TextView tRead;
    ImageView imV;
    String url;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.listm);

      //  ListView lvMain = (ListView) findViewById(R.id.listView2);
      //  ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
       //        R.layout.listm);


        // присваиваем адаптер списку
       // lvMain.setAdapter(adapter);

        Intent intent = getIntent();
        String t = intent.getStringExtra("tit");
        String b = intent.getStringExtra("bo");
        String p = intent.getStringExtra("p");
        TextView Zag = (TextView) findViewById(R.id.label);
        TextView tRead = (TextView) findViewById(R.id.label2);
        Zag.setText(t);
        ImageView imV = (ImageView) findViewById(R.id.icon);

        tRead.setText(b);

        url=p;
        Picasso.with(this).load(url).into(imV);

    }
}
