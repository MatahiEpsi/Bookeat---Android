package com.example.bookeat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import com.example.bookeat.ui.model.Restaurant;

public class RestaurantDetailsActivity extends DemoActivity {
    private Restaurant restaurant;

    public static void display(DemoActivity activity, Restaurant restaurant){
        Intent intent=new Intent(activity,RestaurantDetailsActivity.class);
        intent.putExtra("restaurant",restaurant);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);
        restaurant = (Restaurant) getIntent().getExtras().get("restaurant");
        TextView textName = findViewById(R.id.textViewNameDetails);
        TextView textDescription = findViewById(R.id.textViewDescriptionDetails);
        ImageView imageViewDetails= findViewById(R.id.imageViewRestaurantDetails);

        textName.setText(restaurant.getName());
        textDescription.setText(restaurant.getDescription());
        Picasso.get().load(restaurant.getPictureUrl()).into(imageViewDetails);

        setTitle(restaurant.getName());

    }
}
