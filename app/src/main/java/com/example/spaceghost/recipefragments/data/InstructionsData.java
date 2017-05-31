package com.example.spaceghost.recipefragments.data;

import com.example.spaceghost.recipefragments.models.Instruction;
import com.orm.SugarRecord;

import java.util.List;

/**
 * Created by adacher on 31-05-17.
 */

public class InstructionsData extends SugarRecord {


    public List<Instruction> byPosition(int position) {
        return Instruction.find(Instruction.class, "position = ?", String.valueOf(position));
    }

    public void seedData() {
        String[] ingredients = Recipes.directions;
        for (int i = 0; i < ingredients.length; i++) {
            String[] content = ingredients[i].split("`");
            for (String text : content) {
                Instruction instruction = new Instruction();
                instruction.setPosition(i);
                instruction.setName(text);
                instruction.setStatus(false);
                instruction.save();
            }
        }

    }

}
