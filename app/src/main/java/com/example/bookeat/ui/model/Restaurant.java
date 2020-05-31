package com.example.bookeat.ui.model;
import org.json.JSONObject;

import java.io.Serializable;

public class Restaurant implements Serializable {

    private String name="";
    private String description="";
    private String pictureUrl="";

    public Restaurant(JSONObject jsonObject){
        name=jsonObject.optString("name","");
        description=jsonObject.optString("description","");
        pictureUrl=jsonObject.optString("picture_url","");
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }
}
