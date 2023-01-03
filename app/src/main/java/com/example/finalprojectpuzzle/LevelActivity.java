package com.example.finalprojectpuzzle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.example.finalprojectpuzzle.databinding.ActivityLevelBinding;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.List;

public class LevelActivity extends AppCompatActivity implements OnAnswerTruOrFalse,OnAnswerChoose,OnAnswerFillBlank{
    ActivityLevelBinding binding;
    MyViewModel myViewModel;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    int all_questions=0;
    private CountDownTimer countDownTimer;
    private long timeLiftInMilliseconds;
    int counter = 0;

    int correctAnswer=0;
    int WrongAnswer=0;
    int PersonQuestion;
    ArrayList<Fragment> fragmentPuzzleArrayList;

    int Puzzle_Timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityLevelBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
binding.skip.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        counter=counter-3;
        binding.playerPoint.setText(String.valueOf(counter));
        binding.viewPager2.setCurrentItem(binding.viewPager2.getCurrentItem() + 1);

    }
});


        sharedPreferences = getSharedPreferences("MySharedPref", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        myViewModel = new ViewModelProvider(this).get(MyViewModel.class);
        binding.levelnum.setText(String.valueOf(getIntent().getIntExtra("level_num", 0)));
         fragmentPuzzleArrayList = new ArrayList<>();
        myViewModel.getAllPuzzle().observe(this, puzzles -> {

            for (int i = 0; i < puzzles.size(); i++) {
                binding.viewPager2.setUserInputEnabled(false);


                if (puzzles.get(i).getPattern() == 1
                        && puzzles.get(i).getNum_level() == getIntent().getIntExtra("level_num", 0)) {
                    int point=puzzles.get(i).getPoint();

                    all_questions=all_questions+1;
                    TruOrFalse truOrFalse = TruOrFalse.newInstance(puzzles.get(i).getLabel(), puzzles.get(i).right_answer,puzzles.get(i).hint);
                    fragmentPuzzleArrayList.add(truOrFalse);
                    editor.putInt("trueorfalsepoint",point);
                    editor.putInt("timer", puzzles.get(i).getTime());
                    editor.commit();

                    startTimer();


                } else if (puzzles.get(i).getPattern() == 2 && puzzles.get(i).getNum_level() == getIntent()
                        .getIntExtra("level_num", 0)) {
                    all_questions=all_questions+1;

                    Choose choose = Choose.newInstance(puzzles.get(i).label, puzzles.get(i).answer1,
                            puzzles.get(i).answer2, puzzles.get(i).answer3, puzzles.get(i).answer4,
                            puzzles.get(i).right_answer,puzzles.get(i).hint);
                    fragmentPuzzleArrayList.add(choose);
                    editor.putInt("timer", puzzles.get(i).getTime());
                    editor.commit();
                    startTimer();


                } else if (puzzles.get(i).getPattern() == 3 && puzzles.get(i).getNum_level() ==
                        getIntent().getIntExtra("level_num", 0)) {
                    Fill_in_the_blank fill_in_the_blank = Fill_in_the_blank.newInstance(puzzles.get(i).label,
                            puzzles.get(i).right_answer,puzzles.get(i).hint);
                    fragmentPuzzleArrayList.add(fill_in_the_blank);
                    all_questions=all_questions+1;
                    editor.putInt("timer", puzzles.get(i).getTime());
                    editor.commit();
                    startTimer();

                }
                binding.numAllquestion.setText(String.valueOf(all_questions));

            }



        });

        PuzzleAdapter puzzleAdapter = new PuzzleAdapter(this, fragmentPuzzleArrayList);
        binding.viewPager2.setAdapter(puzzleAdapter);

        myViewModel.getAllLevel().observe(this, new Observer<List<Level>>() {
            @Override
            public void onChanged(List<Level> levels) {
                for (int i = 0; i < levels.size(); i++) {
                    if (binding.viewPager2.getCurrentItem()==all_questions&&Integer.parseInt(binding.levelnum
                            .getText().toString())==getIntent().getIntExtra("level_num", 0)){
                        String point=binding.playerPoint.getText().toString();
                        if (Integer.parseInt(point)>=levels.get(i).getUnlock_points()&&Integer.
                                parseInt(binding.levelnum.getText().toString())==getIntent()
                                .getIntExtra("level_num", 0)){



                        }
                    }

                }
            }
        });

    }

    public void startTimer() {
        Puzzle_Timer=   sharedPreferences.getInt("timer",0);
        new CountDownTimer(Puzzle_Timer, 100){
            public void onTick(long millisUntilFinished){

                Puzzle_Timer++;

                binding.timer.setText(String.valueOf(Puzzle_Timer));

            }
            public  void onFinish(){
                binding.timer.setText("FINISH!!");

            }
        }.start();
    }


    @Override
    public void OnAnswerChoose() {
        correctAnswer++;
        counter=counter+2;
        PersonQuestion++;

        editor.putInt("playerPoint",Integer.parseInt(binding.playerPoint.getText().toString()));
        editor.commit();
        binding.playerPoint.setText(String.valueOf(counter));
        if (binding.viewPager2.getCurrentItem()==all_questions-1){
            Intent intent=new Intent(getBaseContext(),PlayingStart.class);
            startActivity(intent);
            editor.putInt("WrongAnswer",WrongAnswer);
            editor.putInt("CorrectAnswer",correctAnswer);
            editor.putInt("PersonQuestion",PersonQuestion);
            editor.commit();
        }

        binding.viewPager2.setCurrentItem(binding.viewPager2.getCurrentItem() + 1);

    }

    @Override
    public void OnAnswerChooseWrong() {
        WrongAnswer=WrongAnswer+1;
        PersonQuestion++;

        editor.putInt("playerPoint",Integer.parseInt(binding.playerPoint.getText().toString()));
        editor.commit();
        if (binding.viewPager2.getCurrentItem()==all_questions-1){
            Intent intent=new Intent(getBaseContext(),PlayingStart.class);
            startActivity(intent);
            editor.putInt("WrongAnswer",WrongAnswer);
            editor.putInt("CorrectAnswer",correctAnswer);
            editor.putInt("PersonQuestion",PersonQuestion);
            editor.commit();
        }

        binding.viewPager2.setCurrentItem(binding.viewPager2.getCurrentItem() + 1);

    }

    @Override
    public void OnAnswer() {
        PersonQuestion++;
  int trueOrfalsepoint=      sharedPreferences.getInt("trueorfalsepoint",0);

        counter=counter+trueOrfalsepoint;
        binding.playerPoint.setText(String.valueOf(counter));
        correctAnswer++;

        editor.putInt("playerPoint",Integer.parseInt(binding.playerPoint.getText().toString()));
        editor.commit();
        if (binding.viewPager2.getCurrentItem()==all_questions-1){
            Intent intent=new Intent(getBaseContext(),PlayingStart.class);
            startActivity(intent);
            editor.putInt("WrongAnswer",WrongAnswer);
            editor.putInt("PersonQuestion",PersonQuestion);
            editor.putInt("CorrectAnswer",correctAnswer);
            editor.commit();
        }

        binding.viewPager2.setCurrentItem(binding.viewPager2.getCurrentItem() + 1);

    }

    @Override
    public void OnAnswerWrong() {
        PersonQuestion++;
        WrongAnswer=WrongAnswer+1;

        editor.putInt("playerPoint",Integer.parseInt(binding.playerPoint.getText().toString()));
        editor.commit();
        if (binding.viewPager2.getCurrentItem()==all_questions-1){
            Intent intent=new Intent(getBaseContext(),PlayingStart.class);
            startActivity(intent);
            editor.putInt("WrongAnswer",WrongAnswer);
            editor.putInt("CorrectAnswer",correctAnswer);
            editor.putInt("PersonQuestion",PersonQuestion);
            editor.commit();
        }


        binding.viewPager2.setCurrentItem(binding.viewPager2.getCurrentItem() + 1);

    }

    @Override
    public void OnAnswerFillBlank() {
        counter=counter+5;
        PersonQuestion++;
        binding.playerPoint.setText(String.valueOf(counter));
        correctAnswer++;

        editor.putInt("playerPoint",Integer.parseInt(binding.playerPoint.getText().toString()));
        editor.commit();
        if (binding.viewPager2.getCurrentItem()==all_questions-1){
            Intent intent=new Intent(getBaseContext(),PlayingStart.class);
            startActivity(intent);
            editor.putInt("WrongAnswer",WrongAnswer);
            editor.putInt("CorrectAnswer",correctAnswer);
            editor.putInt("PersonQuestion",PersonQuestion);
            editor.commit();
        }

        binding.viewPager2.setCurrentItem(binding.viewPager2.getCurrentItem() + 1);

    }

    @Override
    public void OnAnswerFillBlankWrong() {

        PersonQuestion++;
        WrongAnswer=WrongAnswer+1;
        editor.putInt("playerPoint",Integer.parseInt(binding.playerPoint.getText().toString()));
        editor.commit();
        if (binding.viewPager2.getCurrentItem()==all_questions-1){
            Intent intent=new Intent(getBaseContext(),PlayingStart.class);
            startActivity(intent);
            editor.putInt("WrongAnswer",WrongAnswer);
            editor.putInt("PersonQuestion",PersonQuestion);
            editor.putInt("CorrectAnswer",correctAnswer);
            editor.commit();
        }
        binding.viewPager2.setCurrentItem(binding.viewPager2.getCurrentItem() + 1);


    }

    public SharedPreferences.Editor getEditor() {
        return editor;
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        PuzzleAdapter puzzleAdapter = new PuzzleAdapter(this, fragmentPuzzleArrayList);
        binding.viewPager2.setAdapter(puzzleAdapter);

    }
}
