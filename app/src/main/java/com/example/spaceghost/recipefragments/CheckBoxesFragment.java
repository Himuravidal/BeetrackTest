package com.example.spaceghost.recipefragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

/**
 * Created by spaceghost on 30-01-15.
 */

public abstract class CheckBoxesFragment extends Fragment {
    private static final String KEY_CHECKBOXES = "KEY_CHECKBOXES";
    private CheckBox[] mCheckboxes;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        int index = getArguments().getInt(ViewPagerFragment.KEY_RECIPE_INDEX);

        View view = inflater.inflate(R.layout.fragment_checkboxes, container, false);
        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.checkboxesLayout);

        String[] contents = getContents(index);

        mCheckboxes = new CheckBox[contents.length];


        boolean[] checkboxes = new boolean[mCheckboxes.length];
        if (savedInstanceState != null && savedInstanceState.getBooleanArray(KEY_CHECKBOXES) != null) {
            checkboxes = savedInstanceState.getBooleanArray(KEY_CHECKBOXES);
            Log.d("CHECKBOXES", String.valueOf(checkboxes.length));
        }

        setUpCheckBoxes(contents, linearLayout, checkboxes);


        return view;
    }

    public abstract String[] getContents(int index);

    private void setUpCheckBoxes(String[] contents, ViewGroup container, boolean[] checkboxes) {
        int i = 0;
        for (String content : contents) {
            mCheckboxes[i] = new CheckBox(getActivity());
            mCheckboxes[i].setPadding(8, 16, 8, 16);
            mCheckboxes[i].setTextSize(20f);
            mCheckboxes[i].setText(content);
            container.addView(mCheckboxes[i]);
            if (checkboxes[i]) {
                mCheckboxes[i].toggle();
            }
            i++;
        }

    }


}
