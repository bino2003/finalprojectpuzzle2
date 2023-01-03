package com.example.finalprojectpuzzle;

import android.content.Context;
import android.media.MediaPlayer;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.finalprojectpuzzle.databinding.FragmentChooseBinding;
import com.example.finalprojectpuzzle.databinding.FragmentFillInTheBlankBinding;


public class Fill_in_the_blank extends Fragment {


    private static final String ARG_questions = "questions";
    private static final String ARG_HINT = "hint";
    private static final String ARG_true_Answer = "true_Answer";
OnAnswerFillBlank onAnswerFillBlank;
    private String questions;
    private String true_Answer;
    private String HINT;

    public Fill_in_the_blank() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        onAnswerFillBlank= (OnAnswerFillBlank) context;
    }

    public static Fill_in_the_blank newInstance(String questions, String true_Answer,String HINT) {
        Fill_in_the_blank fragment = new Fill_in_the_blank();
        Bundle args = new Bundle();
        args.putString(ARG_true_Answer, true_Answer);
        args.putString(ARG_HINT, HINT);
        args.putString(ARG_questions, questions);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            questions = getArguments().getString(ARG_questions);
            HINT = getArguments().getString(ARG_HINT);

            true_Answer = getArguments().getString(ARG_true_Answer);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        FragmentFillInTheBlankBinding binding=FragmentFillInTheBlankBinding.inflate(getLayoutInflater());
        binding.etQuestion.setText(questions);
binding.ConfirmConfirm.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        MediaPlayer mediaPlayer=MediaPlayer.create(getContext(),R.raw.succed);
        MediaPlayer mediaPlayer1=MediaPlayer.create(getContext(),R.raw.fill);

        String answer=binding.Answer.getText().toString();

        if (answer.equals(true_Answer)){
            Toast.makeText(getContext(), "Answered correctly", Toast.LENGTH_SHORT).show();
mediaPlayer.start();
            FragmentDialog dialog=FragmentDialog.newInstance(String.valueOf(R.drawable.correct),HINT);
            dialog.show(getParentFragmentManager(),"CustomDialog");
            onAnswerFillBlank.OnAnswerFillBlank();
        }else {
            Toast.makeText(getContext(), "Answered Wrong", Toast.LENGTH_SHORT).show();
mediaPlayer1.start();
onAnswerFillBlank.OnAnswerFillBlankWrong();
            FragmentDialog dialog=FragmentDialog.newInstance(String.valueOf(R.drawable.wrong),HINT);
            dialog.show(getParentFragmentManager(),"CustomDialog");
        }
    }
});




        return binding.getRoot();
    }
}