package com.example.finalprojectpuzzle;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
    public class Level {
        @PrimaryKey(autoGenerate = true)
        private int Level1;
        private      int  unlock_points;

    public int getLevel1() {
        return Level1;
    }

    public void setLevel1(int level1) {
        Level1 = level1;
    }

    public int getUnlock_points() {
        return unlock_points;
    }

    public void setUnlock_points(int unlock_points) {
        this.unlock_points = unlock_points;
    }

    public Level() {

    }

    public Level(int level1, int unlock_points) {
        Level1 = level1;
        this.unlock_points = unlock_points;
    }
}
