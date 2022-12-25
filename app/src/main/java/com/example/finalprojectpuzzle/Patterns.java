package com.example.finalprojectpuzzle;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Patterns {
  private   String name;
    @PrimaryKey()

  private   int number;

    @Override
    public String toString() {
        return "Patterns{" +
                "name='" + name + '\'' +
                ", number=" + number +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Patterns(String name, int number) {
        this.name = name;
        this.number = number;
    }

    public Patterns() {

    }
}
