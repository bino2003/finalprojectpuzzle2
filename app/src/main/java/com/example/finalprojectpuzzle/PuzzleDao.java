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
public interface PuzzleDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertPuzzle(Puzzle puzzle);
    @Delete
    void DeletePuzzle(Puzzle puzzle);
    @Update
    void UpdatePuzzle(Puzzle puzzle);
    @Query("select * from Puzzle inner join Level on Puzzle.num_level = Level.Level1 ")
    LiveData<List<Puzzle>> getAllPuzzle();
}
