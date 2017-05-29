package com.example.spaceghost.recipefragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.spaceghost.recipefragments.adapters.ListAdapter;

/**
 * Created by spaceghost on 29-01-15.
 */

public class ListFragment extends Fragment {

  public interface OnRecipeSelectedInterface {
    void onListRecipeSelected(int index);
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_list, container, false);
  }


  //There is no need for an extra view variable, we must use the Android Fragments life cycle, not fight against it
  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);

    OnRecipeSelectedInterface listener = (OnRecipeSelectedInterface) getActivity();

    RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.listRecycler);
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());
    recyclerView.setLayoutManager(layoutManager);


    ListAdapter listAdapter = new ListAdapter(listener);
    recyclerView.setAdapter(listAdapter);

  }
}
