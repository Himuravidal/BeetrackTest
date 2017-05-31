package com.example.spaceghost.recipefragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

/**
 * Created by spaceghost on 30-01-15.
 */

public class DirectionFragment extends IndexFragment {


    public DirectionFragment() {
    }

    public static DirectionFragment newInstance(int index) {
        DirectionFragment directionFragment = new DirectionFragment();
        Bundle args = new Bundle();
        args.putInt(INDEX, index);
        directionFragment.setArguments(args);
        return directionFragment;

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        Toast.makeText(getContext(), String.valueOf(index), Toast.LENGTH_SHORT).show();
    }


}
