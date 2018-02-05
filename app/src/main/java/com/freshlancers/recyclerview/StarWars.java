package com.freshlancers.recyclerview;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Leon on 05-02-18.
 */

public class StarWars {

    @SerializedName("gender")
    @Expose
    String gender;
    @SerializedName("name")
    @Expose
    String name;

    public void setName(String name) {
        this.name = name;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getName() {

        return name;
    }

    public String getGender() {
        return gender;
    }
}
