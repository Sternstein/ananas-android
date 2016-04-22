package com.example.andreas.ananas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    String[] names = {"Тест 1","Test 2","Test 3","Test 4" };
    ListView lvMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // находим список
        ListView lvMain = (ListView) findViewById(R.id.listView);

        // создаем адаптер
        //ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
        //        R.layout.mystyle, R.id.label, names);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                R.layout.mystyle, R.id.label, names);


        // присваиваем адаптер списку
        lvMain.setAdapter(adapter);

        lvMain.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                TextView textView = (TextView) view;
                String strText = textView.getText().toString(); // получаем текст нажатого элемента

                if(strText.equalsIgnoreCase(getResources().getString(R.string.test))) {

                    startActivity(new Intent(getApplicationContext(), Readtext.class));
                }

                if(strText.equalsIgnoreCase(getResources().getString(R.string.test2))) {

                    startActivity(new Intent(getApplicationContext(), list.class));
                }
            }
        });









    }





}
