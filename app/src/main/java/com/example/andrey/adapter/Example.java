package com.example.andrey.adapter;

import android.app.Activity;

/**
 * Created by Andrey on 29.10.2015.
 */
public class Example extends Activity {

    public String name;
    public String description;

    public Example(String name, String description) {
        this.name = name;
        this.description = description;
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
}
