package com.example.news;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Button entertainment , sports , health , technology , business;
    RecyclerView recyclerView;
    ArrayList<News> news;

    myAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();
        //  String url = "https://saurav.tech/NewsAPI/top-headlines/category/business/in.json";
        recyclerView=findViewById(R.id.newsList);
        entertainment=findViewById(R.id.entertainment);
        sports=findViewById(R.id.sports);
        health = findViewById(R.id.health);
        technology=findViewById(R.id.technology);
        business = findViewById(R.id.business);


        news = new ArrayList<>();
        extractNews("https://saurav.tech/NewsAPI/top-headlines/category/business/in.json");

        entertainment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://saurav.tech/NewsAPI/top-headlines/category/entertainment/in.json";
                adapter.updatedNews(news);
                extractNews(url);
            }
        });
        sports.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://saurav.tech/NewsAPI/top-headlines/category/sports/in.json";
                adapter.updatedNews(news);
                extractNews(url);
            }


        });
        health.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://saurav.tech/NewsAPI/top-headlines/category/health/in.json";
                adapter.updatedNews(news);
                extractNews(url);
            }


        });
        technology.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://saurav.tech/NewsAPI/top-headlines/category/technology/in.json";
                adapter.updatedNews(news);
                extractNews(url);
            }


        });
        business.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = "https://saurav.tech/NewsAPI/top-headlines/category/business/in.json";
                adapter.updatedNews(news);
                extractNews(url);
            }


        });





    }

    private void extractNews(String url) {
        RequestQueue queue = Volley.newRequestQueue(this);
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                JSONArray newsJsonArray = null;
                try {
                    newsJsonArray = response.getJSONArray("articles");
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                for (int i = 0; i < 90; i++) {
                    try {
                        JSONObject newsJsonObject = newsJsonArray.getJSONObject(i);
                        News obj = new News();
                        obj.setTitle(newsJsonObject.getString("title").toString());
                        obj.setAuthor(newsJsonObject.getString("author").toString());
                        obj.setImageUrl(newsJsonObject.getString("urlToImage".toString()));
                        obj.setUrl(newsJsonObject.getString("url").toString());
                        news.add(obj);



                    } catch (JSONException e) {
                        e.printStackTrace();
                    }

                }
                recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
                adapter = new myAdapter(getApplication(), news  );
                recyclerView.setAdapter(adapter);


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this , "Error" , Toast.LENGTH_SHORT).show();
            }
        });
        queue.add(jsonObjectRequest);


    }

}