package com.example.finalprojectpuzzle;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;
@Dao
public interface LevelDao {
    @Insert(onConflict=OnConflictStrategy.IGNORE)
    void insertLevel(Level level);
    @Delete
    void deleteLevel(Level level);
    @Update
    void updateLevel(Level level);
    @Query("select * from Level")
    LiveData<List<Level>> getAllLevel();
}
