package com.example.bookeat;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.squareup.picasso.Picasso;

import java.util.List;

import com.example.bookeat.ui.model.Restaurant;

public class RestaurantAdapter extends ArrayAdapter<Restaurant> {

    public RestaurantAdapter(@NonNull Context context, int resource, @NonNull List<Restaurant> objects) {
        super(context, resource, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater li = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = li.inflate(R.layout.c_restaurant, null);

        TextView textViewName=convertView.findViewById(R.id.textViewName);
        TextView textViewDescription=convertView.findViewById(R.id.textViewDescription);
        ImageView imageView =convertView.findViewById(R.id.imageViewRestaurant);

        Restaurant restaurant=getItem(position);

        textViewName.setText(restaurant.getName());
        textViewDescription.setText(restaurant.getDescription());
        Picasso.get().load(restaurant.getPictureUrl()).into(imageView);
        return convertView;
    }
}
