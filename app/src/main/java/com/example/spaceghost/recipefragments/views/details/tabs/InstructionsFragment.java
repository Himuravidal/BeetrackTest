package com.example.spaceghost.recipefragments.views.details.tabs;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.example.spaceghost.recipefragments.adapters.InstructionsAdapter;

/**
 * Created by spaceghost on 30-01-15.
 */

public class InstructionsFragment extends IndexFragment {


    public InstructionsFragment() {
    }

    public static InstructionsFragment newInstance(int index) {
        InstructionsFragment instructionsFragment = new InstructionsFragment();
        Bundle args = new Bundle();
        args.putInt(INDEX, index);
        instructionsFragment.setArguments(args);
        return instructionsFragment;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        InstructionsAdapter adapter = new InstructionsAdapter(index);
        recyclerView.setAdapter(adapter);


    }


}
