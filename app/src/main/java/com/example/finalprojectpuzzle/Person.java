package com.example.finalprojectpuzzle;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;



    @Entity
    public class Person {
        @PrimaryKey(autoGenerate = true)
        private   int id;
        @NonNull
        private String FullName;
        @NonNull


        private String Email;
        @NonNull




        private String Nationality;
        @NonNull

        private String DateOfBirth;
        @NonNull

        private String Gender;


        public Person() {

        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @NonNull
        public String getFullName() {
            return FullName;
        }

        public void setFullName(@NonNull String fullName) {
            FullName = fullName;
        }

        @NonNull
        public String getEmail() {
            return Email;
        }

        public void setEmail(@NonNull String email) {
            Email = email;
        }

        @NonNull
        public String getNationality() {
            return Nationality;
        }

        public void setNationality(@NonNull String nationality) {
            Nationality = nationality;
        }

        @NonNull
        public String getDateOfBirth() {
            return DateOfBirth;
        }

        public void setDateOfBirth(@NonNull String dateOfBirth) {
            DateOfBirth = dateOfBirth;
        }

        @NonNull
        public String getGender() {
            return Gender;
        }

        public void setGender(@NonNull String gender) {
            Gender = gender;
        }

        public Person(@NonNull String fullName, @NonNull String email, @NonNull String nationality, @NonNull String dateOfBirth, @NonNull String gender) {
            FullName = fullName;
            Email = email;
            Nationality = nationality;
            DateOfBirth = dateOfBirth;
            Gender = gender;
        }

        public Person(int id, @NonNull String fullName, @NonNull String email, @NonNull String nationality, @NonNull String dateOfBirth, @NonNull String gender) {
            this.id = id;
            FullName = fullName;
            Email = email;
            Nationality = nationality;
            DateOfBirth = dateOfBirth;
            Gender = gender;
        }
    }




