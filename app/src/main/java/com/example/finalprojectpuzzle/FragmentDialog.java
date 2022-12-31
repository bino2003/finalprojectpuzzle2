package com.example.finalprojectpuzzle;

import android.os.Bundle;

import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.finalprojectpuzzle.databinding.FragmentDialogBinding;


public class FragmentDialog extends DialogFragment {


    private static final String ARG_ANSWER = "answer";
    private static final String ARG_HINT = "hint";

    // TODO: Rename and change types of parameters
    private String ANSWER;
    private String HINT;

    public FragmentDialog() {
        // Required empty public constructor
    }


    public static FragmentDialog newInstance(String ANSWER, String HINT) {
        FragmentDialog fragment = new FragmentDialog();
        Bundle args = new Bundle();
        args.putString(ARG_ANSWER, ANSWER);
        args.putString(ARG_HINT, HINT);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            HINT = getArguments().getString(ARG_HINT);
            ANSWER = getArguments().getString(ARG_ANSWER);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        FragmentDialogBinding binding=FragmentDialogBinding.inflate(inflater,container,false);
        binding.answer.setImageResource(Integer.parseInt(ANSWER));
        binding.hint.setText(HINT);

        return binding.getRoot();
    }
}