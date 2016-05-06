package com.example.andreas.ananas;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
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

import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity {
    public static String LOG_TAG = "my_log";
    int leng;
    String[] titleb;
    String[] bodyb;
    String[] picb;

    TextView tV;
    ImageView iv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new ParseTask().execute();
        ImageView iv = (ImageView) findViewById(R.id.imV);
        TextView tV = (TextView) findViewById(R.id.tV);
    }

    private class ParseTask extends AsyncTask<Void, Void, String> {
        HttpURLConnection urlConnection = null;
        BufferedReader reader = null;
        String resultJson = "";
        @Override
        protected String doInBackground(Void... params) {
            // получаем данные с внешнего ресурса
            try {
                URL url = new URL("http://192.168.1.7/site/4.json");
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
                leng =info.length();
                String[] titleb= new String[leng];
                String[] bodyb= new String[leng];
                String[] picb= new String[leng];
                for (int i = 0; i < info.length(); i++) {
                    JSONObject friend = info.getJSONObject(i);
                    String title = friend.getString("title");
                    String body = friend.getString("body");
                    String pic = friend.getString("pic");
                    Log.d(LOG_TAG, "Title " + title);
                    Log.d(LOG_TAG, "Body: " + body);
                    Log.d(LOG_TAG, "Url for pic: " + pic);
                    titleb[i]=title;
                    bodyb[i]=body;
                    picb[i]=pic;


                }
                Log.d(LOG_TAG, "Title Massive " + titleb);
                Log.d(LOG_TAG, "Body Massive: " + bodyb);
                Log.d(LOG_TAG, "Url Massive: " + picb);
            } catch (JSONException e) {
                e.printStackTrace();
                
            }
        }
    }
}
