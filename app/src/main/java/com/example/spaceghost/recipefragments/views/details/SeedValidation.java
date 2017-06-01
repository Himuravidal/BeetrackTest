package com.example.spaceghost.recipefragments.views.details;

import com.example.spaceghost.recipefragments.data.IngredientsData;
import com.example.spaceghost.recipefragments.data.InstructionsData;
import com.example.spaceghost.recipefragments.models.Ingredient;

/**
 * Created by adacher on 31-05-17.
 */

public class SeedValidation {


    public void seedData() {
        long count = Ingredient.count(Ingredient.class);
        if (count == 0) {
            new IngredientsData().seedData();
            new InstructionsData().seedData();
        }


    }
}