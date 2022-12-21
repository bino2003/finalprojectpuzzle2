package com.example.finalprojectpuzzle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.os.Bundle;
import android.util.Log;

import com.example.finalprojectpuzzle.databinding.ActivityPlayingStartBinding;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

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



String json=AppUtility.readFromAssets(PlayingStart.this,"Puzzle.json");
        try {
            JSONArray PlayingJsonArray=new JSONArray(json);
            ArrayList playingArrayList=new ArrayList();
            ArrayList<Level> levelArrayList=new ArrayList<>();
            for (int i = 0; i < PlayingJsonArray.length(); i++) {
                JSONObject PlayingJsonObject=new JSONObject(PlayingJsonArray.get(i).toString());
               level_num=  PlayingJsonObject.getInt("level_no");
                allPoint= PlayingJsonObject.getInt("unlock_points");


                    JSONArray questionsJsonArray=PlayingJsonObject.getJSONArray("questions");
                    ArrayList questionsArrayList=new ArrayList();
                Log.d(" questions", String.valueOf(questionsJsonArray.length()));
                    for (int x = 0; x < questionsJsonArray.length(); x++) {
                        JSONObject questionsJsonObject=new JSONObject(questionsJsonArray.get(i).toString());
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
               int pattern_id1=patternJsonObject.getInt("pattern_id");
                String pattern_name1=patternJsonObject.getString("pattern_name");
                Patterns patterns=new Patterns(pattern_name1,pattern_id1);
               myViewModel.insertPattern(patterns);
           String hint=    questionsJsonObject.getString("hint");

                        JSONObject questions2JsonObject=new JSONObject(questionsJsonArray.get(i).toString());
                        questions2JsonObject.getInt("id");
                        questions2JsonObject.getString("title");
                        questions2JsonObject.getString("answer_1");
                        questions2JsonObject.getString("answer_2");
                        questions2JsonObject.getString("answer_3");
                        questions2JsonObject.getString("answer_4");
                        questions2JsonObject.getString("true_answer");
                        questions2JsonObject.getInt("points");
                        questions2JsonObject.getInt("duration");
                        JSONObject pattern2JsonObject=         questionsJsonObject.getJSONObject("pattern");
                       int patterns_id2= pattern2JsonObject.getInt("pattern_id");
                     String pattern_name2=   pattern2JsonObject.getString("pattern_name");
                        Patterns patterns2=new Patterns(pattern_name2,patterns_id2);
                        myViewModel.insertPattern(patterns2);
                        pattern2JsonObject.getString("hint");
                        JSONObject questions3JsonObject=new JSONObject(questionsJsonArray.get(i).toString());
                        questions3JsonObject.getInt("id");
                        questions3JsonObject.getString("title");
                        questions3JsonObject.getString("answer_1");
                        questions3JsonObject.getString("answer_2");
                        questions3JsonObject.getString("answer_3");
                        questions3JsonObject.getString("answer_4");
                        questions3JsonObject.getString("true_answer");
                        questions3JsonObject.getInt("points");
                        questions3JsonObject.getInt("duration");
                        JSONObject pattern3JsonObject=         questionsJsonObject.getJSONObject("pattern");
                       int pattern_id3= pattern3JsonObject.getInt("pattern_id");
                     String patternName3=   pattern3JsonObject.getString("pattern_name");
                        Patterns patterns3=new Patterns(patternName3,pattern_id3);
                        myViewModel.insertPattern(patterns3);
                        pattern3JsonObject.getString("hint");
                        JSONObject questions4JsonObject=new JSONObject(questionsJsonArray.get(i).toString());
                        questions4JsonObject.getInt("id");
                        questions4JsonObject.getString("title");
                        questions4JsonObject.getString("answer_1");
                        questions4JsonObject.getString("answer_2");
                        questions4JsonObject.getString("answer_3");
                        questions4JsonObject.getString("answer_4");
                        questions4JsonObject.getString("true_answer");
                        questions4JsonObject.getInt("points");
                        questions4JsonObject.getInt("duration");
                        JSONObject pattern4JsonObject=         questionsJsonObject.getJSONObject("pattern");
                       int patterns_id4= pattern4JsonObject.getInt("pattern_id");
                      String pattern_name4=  pattern4JsonObject.getString("pattern_name");
                        Patterns patterns4=new Patterns(pattern_name4,patterns_id4);
                        myViewModel.insertPattern(patterns4);
                        pattern4JsonObject.getString("hint");








                    }
                JSONObject Playing2JsonObject=new JSONObject(PlayingJsonArray.get(i).toString());
            level_num2=     Playing2JsonObject.getInt("level_no");
        allPoint2    =     Playing2JsonObject.getInt("unlock_points");

                JSONArray questions2JsonArray=PlayingJsonObject.getJSONArray("questions");
                ArrayList questions2ArrayList=new ArrayList();
                for (int x = 0; x < questions2JsonArray.length(); x++) {
                    JSONObject questionsJsonObject=new JSONObject(questions2JsonArray.get(i).toString());
                    questionsJsonObject.getInt("id");
                    questionsJsonObject.getString("title");
                    questionsJsonObject.getString("answer_1");
                    questionsJsonObject.getString("answer_2");
                    questionsJsonObject.getString("answer_3");
                    questionsJsonObject.getString("answer_4");
                    questionsJsonObject.getString("true_answer");
                    questionsJsonObject.getInt("points");
                    questionsJsonObject.getInt("duration");
                    JSONObject patternJsonObject=         questionsJsonObject.getJSONObject("pattern");
                    patternJsonObject.getInt("pattern_id");
                    patternJsonObject.getString("pattern_name");
                    questionsJsonObject.getString("hint");
                    JSONObject questions2JsonObject=new JSONObject(questionsJsonArray.get(i).toString());
                    questions2JsonObject.getInt("id");
                    questions2JsonObject.getString("title");
                    questions2JsonObject.getString("answer_1");
                    questions2JsonObject.getString("answer_2");
                    questions2JsonObject.getString("answer_3");
                    questions2JsonObject.getString("answer_4");
                    questions2JsonObject.getString("true_answer");
                    questions2JsonObject.getInt("points");
                    questions2JsonObject.getInt("duration");
                    JSONObject pattern2JsonObject=         questionsJsonObject.getJSONObject("pattern");
                    pattern2JsonObject.getInt("pattern_id");
                    pattern2JsonObject.getString("pattern_name");
                    pattern2JsonObject.getString("hint");
                    JSONObject questions3JsonObject=new JSONObject(questionsJsonArray.get(i).toString());
                    questions3JsonObject.getInt("id");
                    questions3JsonObject.getString("title");
                    questions3JsonObject.getString("answer_1");
                    questions3JsonObject.getString("answer_2");
                    questions3JsonObject.getString("answer_3");
                    questions3JsonObject.getString("answer_4");
                    questions3JsonObject.getString("true_answer");
                    questions3JsonObject.getInt("points");
                    questions3JsonObject.getInt("duration");
                    JSONObject pattern3JsonObject=         questionsJsonObject.getJSONObject("pattern");
                    pattern3JsonObject.getInt("pattern_id");
                    pattern3JsonObject.getString("pattern_name");
                    pattern3JsonObject.getString("hint");
                    JSONObject questions4JsonObject=new JSONObject(questionsJsonArray.get(i).toString());
                    questions4JsonObject.getInt("id");
                    questions4JsonObject.getString("title");
                    questions4JsonObject.getString("answer_1");
                    questions4JsonObject.getString("answer_2");
                    questions4JsonObject.getString("answer_3");
                    questions4JsonObject.getString("answer_4");
                    questions4JsonObject.getString("true_answer");
                    questions4JsonObject.getInt("points");
                    questions4JsonObject.getInt("duration");
                    JSONObject pattern4JsonObject=         questionsJsonObject.getJSONObject("pattern");
                    pattern4JsonObject.getInt("pattern_id");
                    pattern4JsonObject.getString("pattern_name");
                    pattern4JsonObject.getString("hint");








                }





            }
        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

}