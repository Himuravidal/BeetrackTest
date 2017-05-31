package com.example.spaceghost.recipefragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.spaceghost.recipefragments.adapters.IngredientAdapter;

/**
 * Created by spaceghost on 30-01-15.
 */

public class IngredientsFragment extends IndexFragment {


    public IngredientsFragment() {
    }

    public static IngredientsFragment newInstance(int index) {
        IngredientsFragment ingredientsFragment = new IngredientsFragment();
        Bundle args = new Bundle();
        args.putInt(INDEX, index);
        ingredientsFragment.setArguments(args);
        return ingredientsFragment;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        IngredientAdapter adapter = new IngredientAdapter(index);
        recyclerView.setAdapter(adapter);
    }
}
