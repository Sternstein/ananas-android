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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Intent intent = getIntent();
        Bundle bb = getIntent().getExtras();
        titleb = bb.getStringArray("tit");
        bodyb = bb.getStringArray("bod");
        picb = bb.getStringArray("pic");

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

                if(position == 0) {

                    String titl = titleb[0];
                    String bod = bodyb[0];
                    String pi = picb[0];
                    Intent intent = new Intent(getApplicationContext(), list2.class);
                    intent.putExtra("tit", titl);
                    intent.putExtra("bo", bod);
                    intent.putExtra("p", pi);
                    startActivity(intent);
                }

                if(position == 1) {

                    String titl = titleb[1];
                    String bod = bodyb[1];
                    String pi = picb[1];
                    Intent intent2 = new Intent(getApplicationContext(), list2.class);
                    intent2.putExtra("tit", titl);
                    intent2.putExtra("bo", bod);
                    intent2.putExtra("p", pi);
                    startActivity(intent2);
                }
                if(position == 2) {

                    String titl = titleb[2];
                    String bod = bodyb[2];
                    String pi = picb[2];
                    Intent intent3 = new Intent(getApplicationContext(), list2.class);
                    intent3.putExtra("tit", titl);
                    intent3.putExtra("bo", bod);
                    intent3.putExtra("p", pi);
                    startActivity(intent3);



                }
                if(position == 3) {

                    Intent intent4 = new Intent(getApplicationContext(), Readtext.class);
                    startActivity(intent4);
                }
                if(position == 4) {

                    startActivity(new Intent(getApplicationContext(), list.class));
                }



            }
        });
    }

}
