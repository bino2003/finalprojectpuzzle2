package com.example.finalprojectpuzzle;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

    @Dao
    public interface PersonDao {
        @Insert
        void insertPerson(Person person);
        @Delete
        void DeletePerson(Person person);
        @Update
        void UpdatePerson(Person person);
        @Query("select * from Person")
        LiveData<List<Person>> getAllPerson();
    }


