package com.example.spaceghost.recipefragments.models;

import com.orm.SugarRecord;

/**
 * Created by adacher on 31-05-17.
 */

public class Instruction extends SugarRecord {

    private String name;
    private int position;
    private boolean status;


    public Instruction() {
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
