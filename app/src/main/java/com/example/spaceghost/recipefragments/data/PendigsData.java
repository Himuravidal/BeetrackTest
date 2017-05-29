package com.example.spaceghost.recipefragments.data;

import com.example.spaceghost.recipefragments.models.Pending;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adacher on 29-05-17.
 */

public class PendigsData {


    public List<Pending> notDone(){
        List<Pending> pendings =new ArrayList<>();
        List<Pending> pendingList = Pending.find(Pending.class,"done=0");
        if (pendingList != null &&pendingList.size()>0){
            pendings.addAll(pendingList);
        }

        return pendings;
    }

}
