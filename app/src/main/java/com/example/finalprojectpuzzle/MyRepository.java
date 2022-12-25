package com.example.finalprojectpuzzle;


import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public class MyRepository {
    private PersonDao personDao;
    private LevelDao levelDao;
    private  PatternsDao patternsDao;
    private   PuzzleDao puzzleDao ;

    private  LiveData<List<Puzzle>> allPuzzle;
    private LiveData<List<Person>> allPerson;
    private LiveData<List<Level>> allLevel;
    private LiveData<List<Patterns>> allPattern;
    MyRepository(Application application){
        MyRoomDataBase db=  MyRoomDataBase.getDatabase(application);
        personDao =db.personDao();
        levelDao=db.levelDao();
        patternsDao=db.patternsDao();
        puzzleDao=db.puzzleDao();
        allPuzzle =puzzleDao.getAllPuzzle();
        allPerson=personDao.getAllPerson();
        allLevel=levelDao.getAllLevel();
        allPattern=patternsDao.getAllPattern();


    }

    void insertPerson(Person person){
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                personDao.insertPerson(person);
            }
        });
    }

    void DeletePerson(Person person){
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                personDao.DeletePerson(person);
            }
        });
    }

    void UpdatePerson(Person person){
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                personDao.UpdatePerson(person);
            }
        });
    }

    LiveData<List<Person>> getAllPerson(){
        return personDao.getAllPerson();
    }
    void insertLevel(Level level){
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                levelDao.insertLevel(level);
            }
        });
    }

    void DeleteLevel(Level level){
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {levelDao.deleteLevel(level);}
        });
    }

    void UpdateLevel(Level level){
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                levelDao.updateLevel(level);
            }
        });
    }

    LiveData<List<Level>> getAllLevel(){
        return levelDao.getAllLevel();
    }

    void insertPattern(Patterns patterns){
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                patternsDao.insertPattern(patterns);
            }
        });
    }

    void DeletePattern(Patterns patterns){
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                patternsDao.DeletePattern(patterns);
            }
        });
    }

    void UpdatePattern(Patterns patterns){
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                patternsDao.UpdatePattern(patterns);
            }
        });
    }


    LiveData<List<Patterns>> getAllPattern(){
        return patternsDao.getAllPattern();
    }

    void insertPuzzle(Puzzle puzzle){
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                puzzleDao.insertPuzzle(puzzle);
            }
        });
    }

    void DeletePuzzle(Puzzle puzzle){
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                puzzleDao.DeletePuzzle(puzzle);
            }
        });
    }

    void UpdatePuzzle(Puzzle puzzle){
        MyRoomDataBase.databaseWriteExecutor.execute(new Runnable() {
            @Override
            public void run() {
                puzzleDao.UpdatePuzzle(puzzle);
            }
        });
    }
    LiveData<List<Puzzle>> getAllPuzzle(){
        return puzzleDao.getAllPuzzle();
    }
}

