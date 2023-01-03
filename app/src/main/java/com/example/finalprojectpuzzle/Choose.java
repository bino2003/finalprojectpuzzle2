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

import com.example.finalprojectpuzzle.databinding.FragmentChooseBinding;


public class Choose extends Fragment {


    private static final String ARG_First_option = "First_option";
    private static final String ARG_Option_Two = "Option_Two";
    private static final String ARG_HINT = "hint";
    private static final String ARG_Option_Three = "Option_Three";
    private static final String ARG_Fourth_option = "Fourth_option";
    private static final String ARG_questions = "questions";
    private static final String ARG_true_Answer="true_Answer";
    final int FirstOption = R.id.First_option;
    final int OptionTwo = R.id.Option_Two;
    final int OptionThree = R.id.Option_Three;
    final int FourthOption = R.id.Fourth_option;
    OnAnswerChoose onAnswerChoose;



    private String Question;
    private String First_option;
    private String Option_Two;
    private String Option_Three;
    private String HINT;
    private String Fourth_option ;
    private String true_Answer ;

    public Choose() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        onAnswerChoose= (OnAnswerChoose) context;
    }

    public static Choose newInstance(String Question, String First_option, String Option_Two, String Option_Three, String Fourth_option , String true_Answer,String HINT) {
        Choose fragment = new Choose();
        Bundle args = new Bundle();
        args.putString(ARG_First_option, First_option);
        args.putString(ARG_HINT, HINT);
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
            HINT = getArguments().getString(ARG_HINT);

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
        binding.radioGroup2.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                MediaPlayer mediaPlayer=MediaPlayer.create(getContext(),R.raw.succed);
                MediaPlayer mediaPlayer1=MediaPlayer.create(getContext(),R.raw.fill);

                Log.d("mmm", "answered index =  " + i);
                switch (i) {
                    case FirstOption:
                        if (true_Answer.equalsIgnoreCase(First_option)) {
                            Toast.makeText(getContext(), "Answered correctly", Toast.LENGTH_SHORT).show();
                            onAnswerChoose.OnAnswerChoose();
                            FragmentDialog dialog=FragmentDialog.newInstance(String.valueOf(R.drawable.correct),HINT);
                            dialog.show(getParentFragmentManager(),"CustomDialog");

                            mediaPlayer.start();
                        } else{
                            Toast.makeText(getContext(), "Answered Wrong", Toast.LENGTH_SHORT).show();
                            mediaPlayer1.start();
                            FragmentDialog dialog=FragmentDialog.newInstance(String.valueOf(R.drawable.wrong),HINT);
                            dialog.show(getParentFragmentManager(),"CustomDialog");
                            onAnswerChoose.OnAnswerChooseWrong();
                        }

                        break;
                    case OptionTwo:
                        if (true_Answer.equalsIgnoreCase(Option_Two)) {
                            Toast.makeText(getContext(), "Answered correctly", Toast.LENGTH_SHORT).show();
                            onAnswerChoose.OnAnswerChoose();
                            FragmentDialog dialog=FragmentDialog.newInstance(String.valueOf(R.drawable.correct),HINT);
                            dialog.show(getParentFragmentManager(),"CustomDialog");

                            mediaPlayer.start();
                        } else {
                            Toast.makeText(getContext(), "Answered Wrong", Toast.LENGTH_SHORT).show();
mediaPlayer1.start();
                            onAnswerChoose.OnAnswerChooseWrong();
                            FragmentDialog dialog=FragmentDialog.newInstance(String.valueOf(R.drawable.wrong),HINT);
                            dialog.show(getParentFragmentManager(),"CustomDialog");
                        }
                        break;
                    case OptionThree:
                        if (true_Answer.equalsIgnoreCase(Option_Three)) {
                            Toast.makeText(getContext(), "Answered correctly", Toast.LENGTH_SHORT).show();
                            onAnswerChoose.OnAnswerChoose();
                            FragmentDialog dialog=FragmentDialog.newInstance(String.valueOf(R.drawable.correct),HINT);
                            dialog.show(getParentFragmentManager(),"CustomDialog");
                            mediaPlayer.start();
                        } else {
                            onAnswerChoose.OnAnswerChooseWrong();
                            Toast.makeText(getContext(), "Answered Wrong", Toast.LENGTH_SHORT).show();
mediaPlayer1.start();
                            FragmentDialog dialog=FragmentDialog.newInstance(String.valueOf(R.drawable.wrong),HINT);
                            dialog.show(getParentFragmentManager(),"CustomDialog");
                        }
                        break;
                    case FourthOption:
                        if (true_Answer.equalsIgnoreCase(Fourth_option)) {
                            Toast.makeText(getContext(), "Answered correctly", Toast.LENGTH_SHORT).show();
                            onAnswerChoose.OnAnswerChoose();
                            mediaPlayer.start();
                            FragmentDialog dialog=FragmentDialog.newInstance(String.valueOf(R.drawable.correct),HINT);
                            dialog.show(getParentFragmentManager(),"CustomDialog");

                        } else {
                            onAnswerChoose.OnAnswerChooseWrong();
                            Toast.makeText(getContext(), "Answered Wrong", Toast.LENGTH_SHORT).show();
mediaPlayer1.start();
                            FragmentDialog dialog=FragmentDialog.newInstance(String.valueOf(R.drawable.wrong),HINT);
                            dialog.show(getParentFragmentManager(),"CustomDialog");
                        }
                        break;
                }
            }
        });




        return binding.getRoot();
    }}