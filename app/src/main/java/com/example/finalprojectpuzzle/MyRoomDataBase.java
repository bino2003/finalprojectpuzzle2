package com.example.finalprojectpuzzle;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Person.class,Level.class,Patterns.class,Puzzle.class}, version = 2, exportSchema = false)
public abstract class MyRoomDataBase extends RoomDatabase {
    public  abstract  PuzzleDao puzzleDao();
    public abstract PersonDao personDao();
    public abstract LevelDao levelDao();
    public abstract PatternsDao patternsDao();

    private static volatile MyRoomDataBase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static MyRoomDataBase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (MyRoomDataBase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                                    MyRoomDataBase.class, "word_database")
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}





