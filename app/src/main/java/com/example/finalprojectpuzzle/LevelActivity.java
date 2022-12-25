package com.example.finalprojectpuzzle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;

import com.example.finalprojectpuzzle.databinding.ActivityLevelBinding;

import java.util.ArrayList;

public class LevelActivity extends AppCompatActivity {
ActivityLevelBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLevelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        ArrayList<Fragment> fragmentsPuzzleArrayList=new ArrayList<>();

        ArrayList<Fragment> fragmentMathArrayList=new ArrayList<>();






        }
}