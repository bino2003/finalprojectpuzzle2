package com.example.finalprojectpuzzle;

import android.content.Context;

import java.io.IOException;
import java.io.InputStream;

public class AppUtility {
    public static String readFromAssets(Context context,String fileJsonName) {
        String string = "";
        try {
            InputStream inputStream=context.getAssets().open("Puzzle.json");
            int size =inputStream.available();
            byte [] byteObject=new byte[size];
            inputStream.read(byteObject);
            inputStream.close();
            string=new String(byteObject,"UTF-8");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return string;
    }
    public static void parsJson(){

    }

}
