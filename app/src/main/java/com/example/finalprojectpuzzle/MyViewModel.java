package com.example.finalprojectpuzzle;


import android.app.Application;

import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

public class MyViewModel extends AndroidViewModel {

    private MyRepository myRepository;



    public MyViewModel (Application application) {
        super(application);
        myRepository = new MyRepository(application);

    }
    void insertPerson(Person person){
        myRepository.insertPerson(person);
    }

    void DeletePerson(Person person){
        myRepository.DeletePerson(person);
    }

    void UpdatePerson(Person person){
        myRepository.UpdatePerson(person);
    }

    LiveData<List<Person>> getAllPerson(){
        return myRepository.getAllPerson();
    }
    void insertLevel(Level level){
        myRepository.insertLevel(level);
    }

    void DeleteLevel(Level level){
        myRepository.DeleteLevel(level);
    }

    void UpdateLevel(Level level){
        myRepository.UpdateLevel(level);
    }

    LiveData<List<Level>> getAllLevel(){
        return myRepository.getAllLevel();
    }
    void insertPattern(Patterns patterns){
        myRepository.insertPattern(patterns);
    }

    void DeletePattern(Patterns patterns){
        myRepository.DeletePattern(patterns);
    }

    void UpdatePattern(Patterns patterns){
        myRepository.UpdatePattern(patterns);
    }
    LiveData<List<Patterns>> getAllPattern(){
        return myRepository.getAllPattern();
    }
    void insertPuzzle(Puzzle puzzle){
        myRepository.insertPuzzle(puzzle);
    }

    void DeletePuzzle(Puzzle puzzle){
        myRepository.DeletePuzzle(puzzle);
    }

    void UpdatePuzzle(Puzzle puzzle){
        myRepository.UpdatePuzzle(puzzle);
    }
    LiveData<List<Puzzle>> getAllPuzzle(){
        return myRepository.getAllPuzzle();
    }
}

