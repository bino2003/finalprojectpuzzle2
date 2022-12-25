package com.example.finalprojectpuzzle;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalprojectpuzzle.databinding.FragmentTruOrFalseBinding;


public class TruOrFalse extends Fragment {



    private static final String ARG_Questions = "q";

    private String questions;

    public TruOrFalse() {
        // Required empty public constructor
    }


    public static TruOrFalse newInstance(String questions ) {
        TruOrFalse fragment = new TruOrFalse();
        Bundle args = new Bundle();
        args.putString(ARG_Questions, questions);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            questions = getArguments().getString(ARG_Questions);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v=inflater.inflate(R.layout.fragment_tru_or_false, container, false);
       FragmentTruOrFalseBinding binding=FragmentTruOrFalseBinding.inflate(getLayoutInflater());
        binding.etQuestion.setText(questions);


        return v;
    }
}