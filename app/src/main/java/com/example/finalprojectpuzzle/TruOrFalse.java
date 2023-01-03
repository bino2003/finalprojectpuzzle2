package com.example.finalprojectpuzzle;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.finalprojectpuzzle.databinding.FragmentTruOrFalseBinding;


public class TruOrFalse extends Fragment {
    OnAnswerTruOrFalse onAnswer;
    final int TRUE_INDEX = R.id.True;
    final int FALSE_INDEX = R.id.False;


    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        onAnswer = (OnAnswerTruOrFalse) context;
    }

    private static final String ARG_Questions = "Questions";
    private static final String ARG_true_Answer = "true_Answer";
    private static final String ARG_HINT = "hint";

    private String questions;
    private String true_Answer;
    private String HINT;


    public TruOrFalse() {
        // Required empty public constructor
    }


    public static TruOrFalse newInstance(String questions, String true_Answer,String HINT) {
        TruOrFalse fragment = new TruOrFalse();
        Bundle args = new Bundle();
        args.putString(ARG_Questions, questions);
        args.putString(ARG_HINT, HINT);
        args.putString(ARG_true_Answer, true_Answer);

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            questions = getArguments().getString(ARG_Questions);
            HINT = getArguments().getString(ARG_HINT);
            true_Answer = getArguments().getString(ARG_true_Answer);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentTruOrFalseBinding binding = FragmentTruOrFalseBinding.inflate(inflater, container, false);
        binding.etQuestion.setText(questions);
        Log.d("pagerTest", "onCreateView: " + questions);
        binding.radioGroupAnswers.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                MediaPlayer mediaPlayer=MediaPlayer.create(getContext(),R.raw.succed);
                MediaPlayer mediaPlayer1=MediaPlayer.create(getContext(),R.raw.fill);

                Log.d("mmm", "answered index =  " + i);
                switch (i) {
                    case TRUE_INDEX:
                        if (true_Answer.equalsIgnoreCase("true")) {
                            Toast.makeText(getContext(), "Answered correctly", Toast.LENGTH_SHORT).show();
                            onAnswer.OnAnswer();
                            mediaPlayer.start();
                            FragmentDialog dialog=FragmentDialog.newInstance(String.valueOf(R.drawable.correct),HINT);
                            dialog.show(getParentFragmentManager(),"CustomDialog");
                        } else{
                            Toast.makeText(getContext(), "Answered Wrong", Toast.LENGTH_SHORT).show();
                            mediaPlayer1.start();
                            FragmentDialog dialog=FragmentDialog.newInstance(String.valueOf(R.drawable.wrong),HINT);
                            dialog.show(getParentFragmentManager(),"CustomDialog");
                            onAnswer.OnAnswerWrong();
                        }

                        break;
                    case FALSE_INDEX:
                        if (true_Answer.equalsIgnoreCase("false")) {
                            Toast.makeText(getContext(), "Answered correctly", Toast.LENGTH_SHORT).show();
                            onAnswer.OnAnswer();
                            mediaPlayer.start();
                            FragmentDialog dialog=FragmentDialog.newInstance(String.valueOf(R.drawable.correct),HINT);
                            dialog.show(getParentFragmentManager(),"CustomDialog");
                        } else {
                            Toast.makeText(getContext(), "Answered Wrong", Toast.LENGTH_SHORT).show();
mediaPlayer1.start();
                            FragmentDialog dialog=FragmentDialog.newInstance(String.valueOf(R.drawable.wrong),HINT);
                            dialog.show(getParentFragmentManager(),"CustomDialog");
                            onAnswer.OnAnswerWrong();
                        }
                        break;
                }
            }
        });

        return binding.getRoot();
    }
}