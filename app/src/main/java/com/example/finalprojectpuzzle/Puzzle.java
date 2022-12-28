package com.example.finalprojectpuzzle;

import static androidx.room.ForeignKey.CASCADE;

import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.PrimaryKey;

@Entity(
        foreignKeys ={
                @ForeignKey(
                        entity = Level.class,
                        parentColumns = "Level1",
                        childColumns = "num_level",
                        onDelete = CASCADE),@ForeignKey(
                entity = Patterns.class,
                parentColumns = "number",
                childColumns = "pattern",
                onDelete = CASCADE)


        }


)
public class Puzzle {
    @PrimaryKey(autoGenerate = true)
    int num;
    int puzzle_num;
    String label;
    String answer1;
    String answer2;
    String answer3;
    String answer4;
    String right_answer;
    int point;
    int num_level;
    int time;
    int pattern;
    String hint;



    public int getPuzzle_num() {
        return puzzle_num;
    }

    public void setPuzzle_num(int puzzle_num) {
        this.puzzle_num = puzzle_num;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getAnswer1() {
        return answer1;
    }

    public void setAnswer1(String answer1) {
        this.answer1 = answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

    public void setAnswer2(String answer2) {
        this.answer2 = answer2;
    }

    public String getAnswer3() {
        return answer3;
    }

    public void setAnswer3(String answer3) {
        this.answer3 = answer3;
    }

    public String getAnswer4() {
        return answer4;
    }

    public void setAnswer4(String answer4) {
        this.answer4 = answer4;
    }

    public String getRight_answer() {
        return right_answer;
    }

    public void setRight_answer(String right_answer) {
        this.right_answer = right_answer;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getNum_level() {
        return num_level;
    }

    public void setNum_level(int num_level) {
        this.num_level = num_level;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getPattern() {
        return pattern;
    }

    public void setPattern(int pattern) {
        this.pattern = pattern;
    }

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public Puzzle() {

    }

    public Puzzle(int puzzle_num, String label, String answer1, String answer2, String answer3, String answer4,
                  String right_answer, int point, int num_level, int time, int pattern, String hint) {
        this.puzzle_num = puzzle_num;
        this.label = label;
        this.answer1 = answer1;
        this.answer2 = answer2;
        this.answer3 = answer3;
        this.answer4 = answer4;
        this.right_answer = right_answer;
        this.point = point;
        this.num_level = num_level;
        this.time = time;
        this.pattern = pattern;
        this.hint = hint;
    }
}
