package com.example.finalprojectpuzzle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;

import com.example.finalprojectpuzzle.databinding.ActivityLevelBinding;

import java.util.ArrayList;

public class LevelActivity extends AppCompatActivity implements OnAnswerTruOrFalse,OnAnswerChoose,OnAnswerFillBlank{
    ActivityLevelBinding binding;
    MyViewModel myViewModel;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int all_questions=0;
    private CountDownTimer countDownTimer;
    private long timeLiftInMilliseconds;
    int counter = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLevelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.timer.setText(String.valueOf(100));

        startTimer();
        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        binding.levelnum.setText(String.valueOf(getIntent().getIntExtra("level_num", 0)));
        ArrayList<Fragment> fragmentPuzzleArrayList = new ArrayList<>();

        myViewModel.getAllPuzzle().observe(this, puzzles -> {

            for (int i = 0; i < puzzles.size(); i++) {

                editor.putInt("timer", puzzles.get(i).getTime());
                editor.commit();
                if (puzzles.get(i).getPattern() == 1
                        && puzzles.get(i).getNum_level() == getIntent().getIntExtra("level_num", 0)) {

all_questions=all_questions+1;
                    TruOrFalse truOrFalse = TruOrFalse.newInstance(puzzles.get(i).getLabel(), puzzles.get(i).right_answer,puzzles.get(i).hint);
                    fragmentPuzzleArrayList.add(truOrFalse);

                } else if (puzzles.get(i).getPattern() == 2 && puzzles.get(i).getNum_level() == getIntent().getIntExtra("level_num", 0)) {
                    all_questions=all_questions+1;
                    Choose choose = Choose.newInstance(puzzles.get(i).label, puzzles.get(i).answer1, puzzles.get(i).answer2, puzzles.get(i).answer3, puzzles.get(i).answer4, puzzles.get(i).right_answer,puzzles.get(i).hint);
                    fragmentPuzzleArrayList.add(choose);

                } else if (puzzles.get(i).getPattern() == 3 && puzzles.get(i).getNum_level() == getIntent().getIntExtra("level_num", 0)) {
                    Fill_in_the_blank fill_in_the_blank = Fill_in_the_blank.newInstance(puzzles.get(i).label, puzzles.get(i).right_answer,puzzles.get(i).hint);
                    fragmentPuzzleArrayList.add(fill_in_the_blank);

                    all_questions=all_questions+1;
                }
                binding.numAllquestion.setText(String.valueOf(all_questions));

            }
        });
        PuzzleAdapter puzzleAdapter = new PuzzleAdapter(this, fragmentPuzzleArrayList);
        binding.viewPager2.setAdapter(puzzleAdapter);

    }

    public void startTimer() {
        countDownTimer = new CountDownTimer(timeLiftInMilliseconds, 1000) {
            @Override
            public void onTick(long l) {
                timeLiftInMilliseconds = l;
            }

            @Override
            public void onFinish() {

            }
        }.start();
    }


    @Override
    public void OnAnswerChoose() {
        counter=counter+2;
        binding.playerPoint.setText(String.valueOf(counter));

    }

    @Override
    public void OnAnswer() {
        counter=counter+1;
        binding.playerPoint.setText(String.valueOf(counter));
    }

    @Override
    public void OnAnswerFillBlank() {
        counter=counter+5;
        binding.playerPoint.setText(String.valueOf(counter));
    }
}
