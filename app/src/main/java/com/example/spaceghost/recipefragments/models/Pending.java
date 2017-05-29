package com.example.spaceghost.recipefragments.models;

import com.orm.SugarRecord;

/**
 * Created by adacher on 29-05-17.
 */

public class Pending extends SugarRecord {

    private boolean done;

    public Pending() {
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

}
