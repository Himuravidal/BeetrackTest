package com.example.spaceghost.recipefragments;

/**
 * Created by spaceghost on 30-01-15.
 */

public class IngredientsFragmentClass extends CheckBoxesFragment {
    @Override
    public String[] getContents(int index) {
        return Recipes.ingredients[index].split("`");
    }
}
