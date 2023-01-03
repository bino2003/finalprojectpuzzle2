package com.example.finalprojectpuzzle;

import java.util.regex.Pattern;

public class Email {
    class Test {
        public  void main(String[] args){
            String email1= "info@infybuzz.com";
            String email2= "infoinfybuzz.com";
            System.out.println("email1="+validateemail(email1));
            System.out.println("email2="+validateemail(email2));
        }
        public  String validateemail(String emile){
            if (emile==null|| emile.isEmpty()){
                return "Invalid";
            }
            String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." +
                    "[a-zA-Z0-9_+&*-]+)*@" +
                    "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                    "A-Z]{2,7}$";
            Pattern pattern= Pattern.compile(emailRegex);
            if (pattern.matcher(emile).matches()){
                return "valid";}
            else{ return "Invalid";}

        }
    }
}
