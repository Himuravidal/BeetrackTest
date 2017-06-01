package com.example.spaceghost.recipefragments.views.details;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import com.example.spaceghost.recipefragments.R;
import com.example.spaceghost.recipefragments.adapters.PagerAdapter;
import com.example.spaceghost.recipefragments.data.Recipes;
import com.example.spaceghost.recipefragments.views.details.tabs.IndexFragment;

public class DetailsActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        int index = getIntent().getIntExtra(IndexFragment.INDEX, 0);
        getSupportActionBar().setTitle(Recipes.names[index]);

        PagerAdapter pagerAdapter = new PagerAdapter(getSupportFragmentManager(), index);

        ViewPager viewPager = (ViewPager) findViewById(R.id.container);
        viewPager.setAdapter(pagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
    }


}
