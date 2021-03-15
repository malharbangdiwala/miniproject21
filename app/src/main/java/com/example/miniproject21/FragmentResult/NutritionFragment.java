package com.example.miniproject21.FragmentResult;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.miniproject21.R;
import com.example.miniproject21.RecipeCard.RecipeCardAdapter;
import com.example.miniproject21.RecipeCard.RecipeCardModel;
import com.example.miniproject21.ResultsActivity;

import java.util.ArrayList;

public class NutritionFragment extends Fragment {
    public static RecyclerView nutrientRecyclerView;
    public ArrayList<RecipeCardModel> nutrientArrayList;
    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);

        if (isVisibleToUser) {
            ResultsActivity.getMenu().getItem(2).setChecked(true);
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nutrition_result, container, false);

        // code here

        return view;
    }
    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        nutrientRecyclerView = getActivity().findViewById(R.id.idNutrient);
        // here we have created new array list and added data to it.
        nutrientArrayList = new ArrayList<>();
        nutrientArrayList.add(new RecipeCardModel("DSA in Java", "4"));
        nutrientArrayList.add(new RecipeCardModel("Java Course", "1"));
        nutrientArrayList.add(new RecipeCardModel("C++ Course", "4"));
        nutrientArrayList.add(new RecipeCardModel("DSA in C++", "1"));
        nutrientArrayList.add(new RecipeCardModel("Kotlin for Android", "!"));
        nutrientArrayList.add(new RecipeCardModel("Java for Android", "Abc"));
        nutrientArrayList.add(new RecipeCardModel("HTML and CSS", "abc"));

        // we are initializing our adapter class and passing our arraylist to it.
        RecipeCardAdapter recipeAdapter = new RecipeCardAdapter(requireContext(), nutrientArrayList);

        // below line is for setting a layout manager for our recycler view.
        // here we are creating vertical list so we will provide orientation as vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false);

        // in below two lines we are setting layoutmanager and adapter to our recycler view.
        nutrientRecyclerView.setLayoutManager(linearLayoutManager);
        nutrientRecyclerView.setAdapter(recipeAdapter);
    }
}
