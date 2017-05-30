package com.example.spaceghost.recipefragments.models;

import com.orm.SugarRecord;

/**
 * Created by adacher on 29-05-17.
 */

public class Ingredient extends SugarRecord {

    private String name;
    private boolean status;
    private int index;

    public Ingredient() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }
}
