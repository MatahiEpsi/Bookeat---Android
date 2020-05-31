package com.example.bookeat;

import android.os.Bundle;
import android.view.View;

import androidx.annotation.Nullable;

public class HomeActivity extends DemoActivity implements View.OnClickListener {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        setContentView(R.layout.activity_home);
        super.onCreate(savedInstanceState);
        findViewById(R.id.buttonListNames).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.buttonListNames:
                RestaurantsActivity.display(HomeActivity.this);
                break;
        }
    }
}