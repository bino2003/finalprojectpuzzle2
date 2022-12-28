package com.example.finalprojectpuzzle;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalprojectpuzzle.databinding.FragmentChooseBinding;
import com.example.finalprojectpuzzle.databinding.FragmentTruOrFalseBinding;


public class Choose extends Fragment {


    private static final String ARG_First_option = "First_option";
    private static final String ARG_Option_Two = "Option_Two";
    private static final String ARG_Option_Three = "Option_Three";
    private static final String ARG_Fourth_option = "Fourth_option";
    private static final String ARG_questions = "questions";
    private static final String ARG_true_Answer="true_Answer";


    private String Question;
    private String First_option;
    private String Option_Two;
    private String Option_Three;
    private String Fourth_option ;
    private String true_Answer ;

    public Choose() {
        // Required empty public constructor
    }


    public static Choose newInstance(String Question, String First_option,String Option_Two,String Option_Three,String Fourth_option ,String true_Answer) {
        Choose fragment = new Choose();
        Bundle args = new Bundle();
        args.putString(ARG_First_option, First_option);
        args.putString(ARG_Option_Three, Option_Three);
        args.putString(ARG_questions, Question);
        args.putString(ARG_Option_Two, Option_Two);
        args.putString(ARG_Fourth_option, Fourth_option);
        args.putString(ARG_true_Answer, true_Answer);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            Question = getArguments().getString(ARG_questions);
            true_Answer = getArguments().getString(ARG_true_Answer);
            First_option = getArguments().getString(ARG_First_option);
            Option_Three = getArguments().getString(ARG_Option_Three);
            Option_Two = getArguments().getString(ARG_Option_Two);

            Fourth_option = getArguments().getString(ARG_Fourth_option);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentChooseBinding binding=FragmentChooseBinding.inflate(getLayoutInflater());
        binding.etQuestion.setText(Question);
        binding.FirstOption.setText(First_option);
        binding.FourthOption.setText(Fourth_option);
        binding.OptionThree.setText(Option_Three);
        binding.OptionTwo.setText(Option_Two);




        return binding.getRoot();
    }
}