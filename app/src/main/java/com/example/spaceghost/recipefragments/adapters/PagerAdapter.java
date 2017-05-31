package com.example.spaceghost.recipefragments.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.spaceghost.recipefragments.IngredientsFragment;
import com.example.spaceghost.recipefragments.InstructionsFragment;

/**
 * Created by adacher on 29-05-17.
 */

public class PagerAdapter extends FragmentPagerAdapter {

    private int index;

    public PagerAdapter(FragmentManager fm, int index) {
        super(fm);
        this.index = index;
    }


    @Override
    public Fragment getItem(int position) {

        switch (position) {
            case 0:
                return IngredientsFragment.newInstance(index);
            case 1:
                return InstructionsFragment.newInstance(index);

            default:
                return IngredientsFragment.newInstance(index);

        }


    }

    @Override
    public int getCount() {
        return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return position == 0 ? "Ingredients" : "Directions";
    }
}
