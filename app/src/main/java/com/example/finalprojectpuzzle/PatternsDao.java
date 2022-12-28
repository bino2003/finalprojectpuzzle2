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
public interface PatternsDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    void insertPattern(Patterns patterns);
    @Delete
    void DeletePattern(Patterns patterns);
    @Update
    void UpdatePattern(Patterns patterns);
    @Query("select * from Patterns")
    LiveData<List<Patterns>> getAllPattern();
}
