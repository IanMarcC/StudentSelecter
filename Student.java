package com.codebind;

import java.util.ArrayList;

public class Student {
    private String name;
    private int score = 0;
    private boolean good =false;
    public Student(String n){
        name = n;
    }
    public void correctAnswer(){
        score++;
    }
    public void isGood(){
        good = true;
    }
    public void addGoodStudents(ArrayList<Student> gs){
        gs.add(this);
    }
    public void resetScores(){
        score = 0;
    }
    public int getScore(){
        return score;
    }
    public boolean checkGood(){
        return good;
    }
    public String getName(){
        return name;
    }
}
