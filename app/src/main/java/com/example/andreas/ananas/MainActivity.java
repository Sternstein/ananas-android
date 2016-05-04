package com.example.andreas.ananas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import android.os.AsyncTask;
import android.util.Log;


public class MainActivity extends AppCompatActivity {
    public static String LOG_TAG = "my_log";
    String[] names = {"Тест 1","Test 2","Test 3","Test 4" };
    String[] names2 = {"Вкусная пицца","Гречка","Коты атакуют людей","Свежий хлеб уже в продаже" };
    ListView lvMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new ParseTask().execute();

        // находим список
        ListView lvMain = (ListView) findViewById(R.id.listView);

        // создаем адаптер
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, names2);

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

                    startActivity(new Intent(getApplicationContext(), Readtext.class));
                }

                if(position == 1) {

                    startActivity(new Intent(getApplicationContext(), list.class));
                }
                if(position == 2) {

                    startActivity(new Intent(getApplicationContext(), list2.class));
                }

            }
        });









    }

    private class ParseTask extends AsyncTask<Void, Void, String> {

        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String resultJson = "";

        @Override
        protected String doInBackground(Void... params) {
            // получаем данные с внешнего ресурса
            try {
                URL url = new URL("http://192.168.1.7/site/3.json");

                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setRequestMethod("GET");
                urlConnection.connect();

                InputStream inputStream = urlConnection.getInputStream();
                StringBuffer buffer = new StringBuffer();

                reader = new BufferedReader(new InputStreamReader(inputStream));

                String line;
                while ((line = reader.readLine()) != null) {
                    buffer.append(line);
                }

                resultJson = buffer.toString();

            } catch (Exception e) {
                e.printStackTrace();
            }
            return resultJson;
        }

        @Override
        protected void onPostExecute(String strJson) {
            super.onPostExecute(strJson);
            // выводим целиком полученную json-строку
            Log.d(LOG_TAG, strJson);

            JSONObject dataJsonObj = null;


            try {
                dataJsonObj = new JSONObject(strJson);
                JSONArray info = dataJsonObj.getJSONArray("info");

                for (int i = 0; i < info.length(); i++) {
                    JSONObject friend = info.getJSONObject(i);


                    String phone = friend.getString("title");
                    String email = friend.getString("body");
                    String skype = friend.getString("pic");

                    Log.d(LOG_TAG, "Title " + phone);
                    Log.d(LOG_TAG, "Body: " + email);
                    Log.d(LOG_TAG, "PicUr: " + skype);
                }

            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }



}
