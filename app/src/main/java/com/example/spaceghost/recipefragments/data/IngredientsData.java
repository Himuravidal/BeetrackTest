package com.example.spaceghost.recipefragments.data;

import com.example.spaceghost.recipefragments.models.Ingredient;

import java.util.List;

/**
 * Created by adacher on 29-05-17.
 */

public class IngredientsData {

    //List of data ingredients and return value by position

    public List<Ingredient> byPosition(int position) {
        return Ingredient.find(Ingredient.class, "position = ?", String.valueOf(position));
    }

    public void seedData() {
        String[] ingredients = Recipes.ingredients;
        for (int i = 0; i < ingredients.length; i++) {
            String[] content = ingredients[i].split("`");
            for (String text : content) {
                Ingredient ingredient = new Ingredient();
                ingredient.setPosition(i);
                ingredient.setName(text);
                ingredient.setStatus(false);
                ingredient.save();
            }
        }

    }


}
