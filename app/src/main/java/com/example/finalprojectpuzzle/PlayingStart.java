package com.example.finalprojectpuzzle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.finalprojectpuzzle.databinding.ActivityPlayingStartBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class PlayingStart extends AppCompatActivity {
    ActivityPlayingStartBinding binding;
    MyViewModel myViewModel;
    int counter=0;
    int level_num;
    int allPoint;
    int level_num2;
    int allPoint2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding=ActivityPlayingStartBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        myViewModel= new ViewModelProvider(this).get(MyViewModel.class);
        parseJson();

        myViewModel.getAllLevel().observe(this, new Observer<List<Level>>() {
            @Override
            public void onChanged(List<Level> levels) {

                LevelAdapter levelAdapter = new LevelAdapter((ArrayList<Level>) levels, PlayingStart.this, new OnClickItem() {
                    @Override
                    public void onclick(int levelnum) {
                        Puzzle puzzle=new Puzzle();
                        puzzle.setNum_level(levelnum);
                  int puzzle_num_level=      puzzle.getNum_level();
                        if (levelnum==puzzle_num_level){
                            Intent intent=new Intent(PlayingStart.this,LevelActivity.class);
                            intent.putExtra("level_num",levelnum);
                            startActivity(intent);
                        }
                    }
                });
                binding.rv.setLayoutManager(new LinearLayoutManager(PlayingStart.this, RecyclerView.VERTICAL, false));
                binding.rv.setAdapter(levelAdapter);
            }
        });



    }
    private void parseJson() {

        String json=AppUtility.readFromAssets(PlayingStart.this,"Puzzle.json");
        try {
            JSONArray PlayingJsonArray=new JSONArray(json);
            ArrayList playingArrayList=new ArrayList();
            ArrayList<Level> levelArrayList=new ArrayList<>();
            for (int i = 0; i < PlayingJsonArray.length(); i++) {
                JSONObject PlayingJsonObject=new JSONObject(PlayingJsonArray.get(i).toString());
                level_num=  PlayingJsonObject.getInt("level_no");
                allPoint= PlayingJsonObject.getInt("unlock_points");
                Level level=new Level(level_num,allPoint);

                myViewModel.insertLevel(level);

                JSONArray questionsJsonArray=PlayingJsonObject.getJSONArray("questions");
                ArrayList questionsArrayList=new ArrayList();
                Log.d(" questions123", String.valueOf(questionsJsonArray.length()));
                for (int x = 0; x < questionsJsonArray.length(); x++) {
                    JSONObject questionsJsonObject=new JSONObject(questionsJsonArray.get(x).toString());
                    int id=   questionsJsonObject.getInt("id");
                    String  title=  questionsJsonObject.getString("title");
                    String  answer_1= questionsJsonObject.getString("answer_1");
                    String answer_2=      questionsJsonObject.getString("answer_2");
                    String answer_3=     questionsJsonObject.getString("answer_3");
                    String answer_4=      questionsJsonObject.getString("answer_4");
                    String   true_answer=   questionsJsonObject.getString("true_answer");
                    int points=    questionsJsonObject.getInt("points");
                    int duration=       questionsJsonObject.getInt("duration");
                    JSONObject patternJsonObject=questionsJsonObject.getJSONObject("pattern");
                    int pattern_id= Integer.parseInt(patternJsonObject.getString("pattern_id"));
                    String pattern_name1=patternJsonObject.getString("pattern_name");
                    String hint =questionsJsonObject.getString("hint");
                    Patterns patterns=new Patterns(pattern_name1,pattern_id);
                    myViewModel.insertPattern(patterns);
         Puzzle puzzle=new Puzzle(id,title,answer_1,answer_2,answer_3,answer_4,true_answer,points,level_num,duration,pattern_id,hint);
                    myViewModel.insertPuzzle(puzzle);
                }

            }
        } catch (JSONException e) {

            e.printStackTrace();
        }
    }


}