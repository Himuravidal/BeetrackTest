package com.example.spaceghost.recipefragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements ListFragment.OnRecipeSelectedInterface {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new SeedValidation().seedData();

    }

    @Override
    public void onListRecipeSelected(int index) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra(IndexFragment.INDEX, index);
        startActivity(intent);
    }
}
