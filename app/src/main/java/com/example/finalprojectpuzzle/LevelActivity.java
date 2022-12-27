package com.example.finalprojectpuzzle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;

import com.example.finalprojectpuzzle.databinding.ActivityLevelBinding;

import java.util.ArrayList;
import java.util.List;

public class LevelActivity extends AppCompatActivity {
ActivityLevelBinding binding;
    MyViewModel myViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityLevelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        myViewModel= new ViewModelProvider(this).get(MyViewModel.class);

        ArrayList<Fragment> fragmentPuzzleArrayList=new ArrayList<>();

myViewModel.getAllPuzzle().observe(this, new Observer<List<Puzzle>>() {
    @Override
    public void onChanged(List<Puzzle> puzzles) {

        for (int i = 0; i <puzzles.size() ; i++) {

            if (puzzles.get(i).getPattern().equals(String.valueOf(1))&&puzzles.get(i).getNum_level()==getIntent().getIntExtra("level_num",0)){



                TruOrFalse truOrFalse=  TruOrFalse.newInstance(puzzles.get(i).getLabel(),puzzles.get(i).right_answer);
                fragmentPuzzleArrayList.add(truOrFalse);

        }else if (puzzles.get(i).getPattern().equals(String.valueOf(2))&&puzzles.get(i).getNum_level()==getIntent().getIntExtra("level_num",0)){

                Choose choose=  Choose.newInstance(puzzles.get(i).label,puzzles.get(i).answer1,puzzles.get(i).answer2,puzzles.get(i).answer3,puzzles.get(i).answer4,puzzles.get(i).right_answer);
                fragmentPuzzleArrayList.add(choose);

            }else if (puzzles.get(i).getPattern().equals(String.valueOf(3))&&puzzles.get(i).getNum_level()==getIntent().getIntExtra("level_num",0)){
                Fill_in_the_blank fill_in_the_blank=  Fill_in_the_blank.newInstance(puzzles.get(i).label,puzzles.get(i).right_answer);
                fragmentPuzzleArrayList.add(fill_in_the_blank);


            }
}}});
        PuzzleAdapter puzzleAdapter=new PuzzleAdapter(this,fragmentPuzzleArrayList);
        binding.viewPager2.setAdapter(puzzleAdapter);



        }

    }
