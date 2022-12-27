package com.example.finalprojectpuzzle;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalprojectpuzzle.databinding.FragmentTruOrFalseBinding;


public class TruOrFalse extends Fragment {



    private static final String ARG_Questions = "Questions";
    private static final String ARG_true_Answer = "true_Answer";

    private String questions;
private String true_Answer;
    public TruOrFalse() {
        // Required empty public constructor
    }


    public static TruOrFalse newInstance(String questions,String true_Answer ) {
        TruOrFalse fragment = new TruOrFalse();
        Bundle args = new Bundle();
        args.putString(ARG_Questions, questions);
        args.putString(ARG_true_Answer, true_Answer);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            questions = getArguments().getString(ARG_Questions);
            true_Answer = getArguments().getString(ARG_true_Answer);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
       FragmentTruOrFalseBinding binding = FragmentTruOrFalseBinding.inflate(inflater,container,false);
        binding.etQuestion.setText(questions);
        Log.d("pagerTest", "onCreateView: "+questions);
        return binding.getRoot();
    }
}