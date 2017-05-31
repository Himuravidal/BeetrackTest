package com.example.spaceghost.recipefragments.data;

import com.example.spaceghost.recipefragments.models.Instruction;
import com.orm.SugarRecord;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adacher on 31-05-17.
 */

public class InstructionsData extends SugarRecord {


    public List<Instruction> notDone() {
        List<Instruction> pendings = new ArrayList<>();
        List<Instruction> pendingList = Instruction.find(Instruction.class, "done=0");
        if (pendingList != null && pendingList.size() > 0) {
            pendings.addAll(pendingList);
        }

        return pendings;
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
