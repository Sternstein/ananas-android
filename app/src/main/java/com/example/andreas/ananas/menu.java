package com.example.andreas.ananas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class menu extends AppCompatActivity {

    public String[] titleb;
    public String[] bodyb;
    public String[] picb;
    public String co;
    public int c;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        Bundle bb = getIntent().getExtras();
        titleb = bb.getStringArray("tit");
        bodyb = bb.getStringArray("bod");
        picb = bb.getStringArray("pic");
        co = intent.getStringExtra("c");
        c = Integer.parseInt(co);

        // находим список
        ListView lvMain = (ListView) findViewById(R.id.listView3);

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, titleb);

        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        //       R.layout.mystyle, R.id.label, names);


        // присваиваем адаптер списку
        lvMain.setAdapter(adapter);

        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                TextView textView = (TextView) view;
                String strText = textView.getText().toString(); // получаем текст нажатого элемента

                for (int i = 0; i < c; i++){
                if(position == i) {

                    String titl = titleb[i];
                    String bod = bodyb[i];
                    String pi = picb[i];
                    Intent intent = new Intent(getApplicationContext(), list2.class);
                    intent.putExtra("tit", titl);
                    intent.putExtra("bo", bod);
                    intent.putExtra("p", pi);
                    startActivity(intent);
                }
                }





            }
        });
    }

}
