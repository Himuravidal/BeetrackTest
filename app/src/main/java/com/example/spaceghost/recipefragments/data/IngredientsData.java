package com.example.spaceghost.recipefragments.data;

import com.example.spaceghost.recipefragments.models.Ingredient;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adacher on 29-05-17.
 */

public class IngredientsData {


    public List<Ingredient> notDone(){
        List<Ingredient> pendings =new ArrayList<>();
        List<Ingredient> pendingList = Ingredient.find(Ingredient.class,"done=0");
        if (pendingList != null &&pendingList.size()>0){
            pendings.addAll(pendingList);
        }

        return pendings;
    }

    public void seedData() {
        long count = Ingredient.count(Ingredient.class);
        if (count == 0) {
            String[] ingredients = Recipes.ingredients;
            for (int i = 0; i < ingredients.length; i++) {
                String[] content = ingredients[i].split("`");
                for (String text : content) {
                    Ingredient ingredient = new Ingredient();
                    ingredient.setIndex(i);
                    ingredient.setName(text);
                    ingredient.setStatus(false);
                    ingredient.save();
                }
            }

        }
    }

}
