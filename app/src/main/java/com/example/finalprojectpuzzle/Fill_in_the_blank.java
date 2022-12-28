package com.example.finalprojectpuzzle;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalprojectpuzzle.databinding.FragmentChooseBinding;
import com.example.finalprojectpuzzle.databinding.FragmentFillInTheBlankBinding;


public class Fill_in_the_blank extends Fragment {


    private static final String ARG_questions = "questions";
    private static final String ARG_true_Answer = "true_Answer";

    private String questions;
    private String true_Answer;

    public Fill_in_the_blank() {
        // Required empty public constructor
    }


    public static Fill_in_the_blank newInstance(String questions, String true_Answer) {
        Fill_in_the_blank fragment = new Fill_in_the_blank();
        Bundle args = new Bundle();
        args.putString(ARG_true_Answer, true_Answer);
        args.putString(ARG_questions, questions);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            questions = getArguments().getString(ARG_questions);
            true_Answer = getArguments().getString(ARG_true_Answer);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentFillInTheBlankBinding binding=FragmentFillInTheBlankBinding.inflate(getLayoutInflater());
        binding.etQuestion.setText(questions);



        return binding.getRoot();
    }
}