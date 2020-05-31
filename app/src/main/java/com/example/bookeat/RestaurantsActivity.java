package com.example.bookeat;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.annotation.Nullable;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

import com.example.bookeat.ui.model.Restaurant;

public class RestaurantsActivity extends DemoActivity {

    private RestaurantAdapter adapter;
    private String data = "{ \"items\": [" +
            "  {" +
            "    \"picture_url\": \"https://www.snacking.fr/upload/news/xlarge/news_4816.jpg\"," +
            "    \"name\": \"Buffalo Grill\"," +
            "    \"description\": \"De tendres et savoureuses pièces de viande, des burgers ultra gourmands, des portions trèèèès généreuses et un service chaleureux et décontracté…\"" +
            "  }," +
            "  {" +
            "    \"picture_url\": \"https://www.snacking.fr/upload/news/xlarge/news_4816.jpg\"," +
            "    \"name\": \"Buffalo Grill\"," +
            "    \"description\": \"De tendres et savoureuses pièces de viande, des burgers ultra gourmands, des portions trèèèès généreuses et un service chaleureux et décontracté…\"" +
            "  }," +
            "  {" +
            "    \"picture_url\": \"https://www.snacking.fr/upload/news/xlarge/news_4816.jpg\"," +
            "    \"name\": \"Buffalo Grill\"," +
            "    \"description\": \"De tendres et savoureuses pièces de viande, des burgers ultra gourmands, des portions trèèèès généreuses et un service chaleureux et décontracté…\"" +
            "  }," +
            "  {" +
            "    \"picture_url\": \"https://www.snacking.fr/upload/news/xlarge/news_4816.jpg\"," +
            "    \"name\": \"Buffalo Grill\",\n" +
            "    \"description\": \"De tendres et savoureuses pièces de viande, des burgers ultra gourmands, des portions trèèèès généreuses et un service chaleureux et décontracté…\"" +
            "  }," +
            "  {" +
            "    \"picture_url\": \"https://www.snacking.fr/upload/news/xlarge/news_4816.jpg\"," +
            "    \"name\": \"Buffalo Grill\"," +
            "    \"description\": \"De tendres et savoureuses pièces de viande, des burgers ultra gourmands, des portions trèèèès généreuses et un service chaleureux et décontracté…\"" +
            "  }," +
            "]" +
            "  " +
            "};";
    private ArrayList<Restaurant> restaurants;

    public static void display(DemoActivity activity){
        Intent intent=new Intent(activity, RestaurantsActivity.class);
        activity.startActivity(intent);
    }
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_name);
        restaurants=new ArrayList<>();
        ListView listView=findViewById(R.id.listViewRestaurants);
        adapter=new RestaurantAdapter(this,R.layout.c_restaurant,restaurants);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                RestaurantDetailsActivity.display(RestaurantsActivity.this,restaurants.get(position));
            }
        });
        initData(data);
    }

    private void initData(String data) {
        try {
            JSONObject jsonObject;
            jsonObject=new JSONObject(data);
            JSONArray jsonArray=jsonObject.getJSONArray("items");
            for(int i=0;i<jsonArray.length();i++){
                Restaurant restaurant=new Restaurant(jsonArray.getJSONObject(i));
                restaurants.add(restaurant);
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        adapter.notifyDataSetChanged();
    }
}
